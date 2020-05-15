package com.kidder.Generator;
import org.hibernate.HibernateException;




public interface IdGenerator {
	public long generate(String objectKey, long required) throws HibernateException;
}
