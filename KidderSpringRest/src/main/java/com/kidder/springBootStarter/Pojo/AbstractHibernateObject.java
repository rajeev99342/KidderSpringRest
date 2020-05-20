package com.kidder.springBootStarter.Pojo;


	import java.io.Serializable;

import com.kidder.Generator.HibernateIntegerPrimaryKeyAttacher;

	public abstract class AbstractHibernateObject implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private long id = -1L;

		private String uniqueCode;

		public String getUniqueCode() {
			return uniqueCode;
		}

		public void setUniqueCode(String uniqueCode) {
			this.uniqueCode = uniqueCode;
		}

		private Boolean deleteFl = false;


		private int tenantId = -1;

		public Long getId()
		{
			return id;
		}

		public void setId( Long id )
		{
			this.id = id;
		}



		public Boolean getDeleteFl()
		{
			return deleteFl;
		}

		public void setDeleteFl( Boolean deleteFl )
		{
			this.deleteFl = deleteFl;
		}



		public int getTenantId()
		{
			return this.tenantId;
		}

		public void setTenantId( int tenantId )
		{
			this.tenantId = tenantId;
		}

		public String toString()
		{
			// Return the class name and the primary key
			return this.getClass().toString() + " - " + getId();
		}

		public final boolean equals( Object other )
		{
			// Check for reference equality
			if ( this == other )
			{
				return true;
			}

			if ( other == null )
			{
				return false;
			}

			// Check the type is the same (this also checks for null)
			if ( !( other instanceof AbstractHibernateObject ) )
			{
				return false;
			}

			if ( !getClass().isInstance( other ) && !other.getClass().isInstance( this ) )
			{
				return false;
			}

			// Check only the primary keys
			AbstractHibernateObject otherHibernateObject = ( AbstractHibernateObject ) other;
			return this.getId() == otherHibernateObject.getId();
		}

		public final int hashCode()
		{
			// Base the hashcode on the primary key
			return ( int ) getId().intValue();
		}

		public void generateId()
		{
			HibernateIntegerPrimaryKeyAttacher keyHelper = new HibernateIntegerPrimaryKeyAttacher();
			keyHelper.generateKey( this );
		}
	}


