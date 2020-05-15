package com.kidder.Generator;


import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.kidder.springBootStarter.Pojo.AbstractHibernateObject;

import Constant.Constant.LongIdConstants;

import java.util.logging.*; 



public class HibernateIntegerPrimaryKeyAttacher
{
	private Logger log = Logger.getLogger(HibernateIntegerPrimaryKeyAttacher.class.getName());

	@PreUpdate
	@PrePersist
	public void generateKey( AbstractHibernateObject hibernateObject )
	{
		if ( hibernateObject.getId() <= 0 )
		{
			LongIdHelper longIdHelper = LongIdHelper.getIdHelper( hibernateObject.getClass().getSimpleName(), LongIdConstants.LONG_ID_HELPER_BLOCK_SIZE );
			Long id = longIdHelper.getNextId();
			{
				log.info( "Class: {}, id:{}" + hibernateObject.getClass().getSimpleName() + " , " + id );
			}
			hibernateObject.setId( id.longValue() );
		}
	}
}
