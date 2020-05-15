package com.kidder.Generator;


public class IdGeneratorImpl extends AbstractIdGenerator {

	protected String getSelectQuery(String objectName, long required) {
		return "select noi_current_no from " + ID_TABLE + " where noi_object_name = '" + objectName + "'";
	}

	protected String getUpdateQuery(String objectName, long required) {
		return "update " + ID_TABLE + " set noi_current_no = noi_current_no + " + required
				+ " where noi_object_name = '" + objectName + "'";
	}

	protected String getInsertQuery(String objectName, long required) {
		return "insert into " + ID_TABLE + " ( noi_current_no, noi_object_name ) values ( " + required + ", '"
				+ objectName + "' )";
	}

}
