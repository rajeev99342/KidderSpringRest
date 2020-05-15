package com.kidder.SpringBootConnection;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.kidder.context.ApplicationContextProvider;


@EntityScan( "com.subex.common.database.hibernate.pojo" )
@ComponentScan(
{ "com.subex.common.database.springboot", "com.subex.rest.api.springboot" } )
@EnableAutoConfiguration
@EnableJpaRepositories( basePackages =
{ "com.subex.common.database.springboot", "com.subex.rest.api.springboot" } )
@EnableTransactionManagement
public class SpringDbConnection
{
	private static ApplicationContext ctx;

	//setter only for test case
	public static void setCtx( ApplicationContext ctx )
	{
		SpringDbConnection.ctx = ctx;
	}

	private static void initialize( String args[] )
	{
		SpringApplication.run( SpringDbConnection.class, args );
		ctx = ApplicationContextProvider.getApplicationContext();
	}

	/**	 @param: args[] is used to run application with specified
		 sources using default settings and user supplied arguments.
		 If not required pass an empty String array
		 @return ApplicationContext
	**/
	public static ApplicationContext getAppContext( String args[] )
	{

		if ( null == ctx )
		{
			synchronized (SpringDbConnection.class)
			{
				if ( ctx == null )
				{
					initialize( args );
				}
			}
		}
		return ctx;
	}

	/** Return a Spring application context 
	  * @return ApplicationContext **/
	public static ApplicationContext getAppContext()
	{

		if ( null == ctx )
		{
			synchronized (SpringDbConnection.class)
			{
				if ( ctx == null )
				{
					initialize( new String[0] );
				}
			}
		}
		return ctx;
	}
}