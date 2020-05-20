package com.kidder.Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class CheckTable {

	public static Boolean isTableExist(String tableName) throws SQLException
	{
	Connection con = DriverManager.getConnection("jdbc:mysql://kiddertestdb.c8bvgfi9mdv2.ap-south-1.rds.amazonaws.com:3306/kidder", "kiddertestuser", "kiddertestpassword");
	
		Boolean flag ;
	
		DatabaseMetaData dbm = (DatabaseMetaData) con.getMetaData();
		// check if "employee" table is there
		ResultSet tables = dbm.getTables(null, null, tableName, null);
		if (tables.next()) {
			// Table exists
			System.out.println("Table exists");
			flag = true;
		} else {
			// Table does not exist
			flag = false;
			System.out.println("Table does not exist");
		}
		
		return flag;
	}
	
}
