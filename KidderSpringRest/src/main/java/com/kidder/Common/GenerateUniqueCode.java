package com.kidder.Common;

public class GenerateUniqueCode {
	public static String Generate(long id,String table)
	{
		return  table +"_" + id;
		
	}
}
