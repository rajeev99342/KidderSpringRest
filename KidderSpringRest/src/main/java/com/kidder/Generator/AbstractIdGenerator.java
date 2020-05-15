package com.kidder.Generator;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import java.util.logging.*; 

import org.hibernate.HibernateException;

import com.kidder.SpringBootConnection.SpringDbConnection;


public abstract class AbstractIdGenerator implements IdGenerator
{


	protected static final String ID_TABLE = "ml_next_object_id";
	protected static final Logger logger = Logger.getLogger( AbstractIdGenerator.class.getName() );

	// returns a id which will be the low value of a block of one or more so
	// applications should
	// call this and count UP inclusively from the returned number.
	public synchronized long generate( final String objectKey, final long required )
	{
		if ( required <= 0 )
		{
			throw new IllegalArgumentException( "Invalid required id size " + required );
		}
		return doGenerate( objectKey, required );

	}

	private Long doGenerate( String objectKey, long required )
	{
		String selectQuery = getSelectQuery( objectKey, required );
		String updateQuery = getUpdateQuery( objectKey, required );

		long result = 0;
		Long sequenceId = null;
		Connection conn = null;
		ResultSet rs = null;

		try
		{
			DataSource ds = SpringDbConnection.getAppContext().getBean( DataSource.class );
			conn = ds.getConnection();

			if ( null != conn )
			{
				conn.setAutoCommit( false );

				PreparedStatement ps = conn.prepareStatement( selectQuery );
				rs = ps.executeQuery();

				// if there's no existing row for this object name insert a new row now
				if ( !rs.next() )
				{
					ps = conn.prepareStatement( getInsertQuery( objectKey, required ) );
					ps.executeUpdate();
				}
				else
				{
					PreparedStatement pstmt = conn.prepareStatement( updateQuery );
					pstmt.executeUpdate();
				}
				ps = conn.prepareStatement( selectQuery );
				rs = ps.executeQuery();

				rs.next();
				sequenceId = rs.getLong( "noi_current_no" );

				result = sequenceId - required + 1;
				conn.commit();
			}
			else
			{
				logger.info( "Connection is null in AbstractIdGenerator.class" );
			}
		}
		catch ( Exception ex )
		{
			throw new HibernateException( ex );
		}
		finally
		{
			try
			{
				if ( conn != null )
				{
					conn.close();
				}
			}
			catch ( SQLException ex )
			{
				logger.info( "Unable to close connection"+ ex );
			}
		}
		return result;
	}

	protected abstract String getSelectQuery( String objectName, long required );

	protected abstract String getUpdateQuery( String objectName, long required );

	protected abstract String getInsertQuery( String objectName, long required );

}
