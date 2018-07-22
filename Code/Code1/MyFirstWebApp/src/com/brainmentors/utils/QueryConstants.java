package com.brainmentors.utils;

public interface QueryConstants {
	// public static final String LOGIN_SQL= "";
	//String LOGIN_SQL = "SELECT userid, password "
	 	//	+ "FROM user_details where userid=? and password=?";
	
	String LOGIN_SQL = "SELECT USER_MST.USERNAME AS USERID, "
			+ "ROLE_MST.NAME AS ROLE,RIGHT_MST.NAME AS RIGHT, RIGHT_MST.SCREEN FROM "
			+ "USER_MST, ROLE_MST,RIGHT_MST "
			+ ",USER_ROLE_MAPPING,ROLE_RIGHT_MAPPING WHERE "
			+ "USER_MST.UID=USER_ROLE_MAPPING.USERID "
			+ "AND ROLE_MST.ROLEID=USER_ROLE_MAPPING.ROLEID AND "
			+ "ROLE_MST.ROLEID=ROLE_RIGHT_MAPPING.ROLEID "
			+ "AND RIGHT_MST.RIGHTID=ROLE_RIGHT_MAPPING.RIGHTID "
			+ "AND USER_MST.USERNAME=? AND USER_MST.PASSWORD=?";
	
	String REGISTER_SQL = "INSERT INTO user_details (userid, password) VALUES(?,?)";

}
