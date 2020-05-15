package com.kidder.Generator;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.HibernateException;
import java.util.logging.*; 

public class LongIdHelper {
	private static final Logger logger = Logger.getLogger(LongIdHelper.class.getName());
	private String objectKey = null;
	private long blockSize = 1;

	public LongIdHelper(String objectKey, long blockSize) {
		if (blockSize <= 0) {
			throw new IllegalArgumentException("Invalid block size " + blockSize + " passed to id helper");
		}

		this.objectKey = objectKey;
		this.blockSize = blockSize;
	}

	class IdBlock {
		final long limit;
		final AtomicLong nextId;

		IdBlock(long start, long limit) {
			this.limit = limit;
			this.nextId = new AtomicLong(start);
		}
	}

	final Object mutex = new Object();
	IdBlock currentBlock = null;

	public long getNextId() throws HibernateException {
		IdBlock block = currentBlock;
		if (block != null) {
			long id = block.nextId.getAndIncrement();
			if (id < block.limit)
				return id;
		}

		synchronized (mutex) {
			// We may have a new block by now, so try again.
			if (currentBlock != null && currentBlock != block) {
				long id = currentBlock.nextId.getAndIncrement();
				if (id < currentBlock.limit)
					return id;
			}

			// Allocate a new block
			IdGenerator idGenerator = new IdGeneratorImpl();
			long lowId = idGenerator.generate(objectKey, blockSize);
			currentBlock = new IdBlock(lowId + 1, lowId + blockSize);
			return lowId;
		}
	}

	// Map of stsId -> Map of String -> IdHelper
	private static Map<String, LongIdHelper> idHelpers = new HashMap<>();

	public static synchronized LongIdHelper getIdHelper(String objectKey, long blockSize) {
		LongIdHelper idHelper = null;
		if (null != objectKey) {
			idHelpers.computeIfAbsent(objectKey, k -> new LongIdHelper(objectKey, blockSize));
			idHelper = idHelpers.get(objectKey);
		} else

		{
			logger.info("objectKey is null in LongIdHelper Class");
		}
		return idHelper;
	}

	public static long generateId(String objectKey) {
		return generateId(objectKey, 1);
	}

	public static long generateId(String objectKey, int required) {
		return new LongIdHelper(objectKey, required).getNextId();
	}
}
