package com.brainmentors.utils;

public interface QueryConstants {
	// public static final String LOGIN_SQL= "";
	String LOGIN_SQL = "SELECT userid, password "
	 		+ "FROM user_details where userid=? and password=?";
	
	String REGISTER_SQL = "INSERT INTO user_details (userid, password) VALUES(?,?)";

}
