package com.kidder.context;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextProvider implements ApplicationContextAware
{
	private static ApplicationContext context;

	/** Return Spring connection Object ApplicationContext
	 * @return ApplicationContext **/
	public static ApplicationContext getApplicationContext()
	{

		return context;
	}

	/** SpringBoot Application will use this method to set ApplicationContext **/
	public void setApplicationContext( ApplicationContext applicationContext )
	{
		context = applicationContext;
	}
}
