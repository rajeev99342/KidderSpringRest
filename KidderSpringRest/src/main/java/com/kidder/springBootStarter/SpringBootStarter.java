package com.kidder.springBootStarter;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.kidder.SpringBootConnection.SpringDbConnection;

@SpringBootApplication
@EntityScan( "com.kidder.springBootStarter.Pojo" )
@ComponentScan(
{ "com.kidder.springBootStarter", "com.kidder.springBootStarter" } )
@EnableAutoConfiguration
@EnableJpaRepositories( basePackages =
{ "com.kidder.SpringBootConnection","com.kidder.springBootStarter.Repo"} )
@EnableTransactionManagement

public class SpringBootStarter {
	private static ApplicationContext ctx;

	private static final String ZONE_ID_INDIA = "IST";
	public static void setCtx( ApplicationContext ctx )
	{
		SpringBootStarter.ctx = ctx;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			TimeZone.setDefault(TimeZone.getTimeZone(ZONE_ID_INDIA));
			SpringApplication.run(SpringBootStarter.class, args);
	}
	
	public static ApplicationContext getAppContext( String args[] )
	{

		if ( null == ctx )
		{
			synchronized (SpringDbConnection.class)
			{
				if ( ctx == null )
				{
					main( args );
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
					main( new String[0] );
				}
			}
		}
		return ctx;
	}

}
