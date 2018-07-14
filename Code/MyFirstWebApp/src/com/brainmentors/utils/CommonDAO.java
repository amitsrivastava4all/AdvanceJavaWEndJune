package com.brainmentors.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public interface CommonDAO {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Connection connection = null;
		ResourceBundle rb = ResourceBundle.getBundle("config");
		Class.forName(rb.getString("drivername"));
		
		  connection = DriverManager
				 .getConnection(rb.getString("dburl")
						 ,rb.getString("userid"),rb.getString("password"));
		
		 return connection;
	}

}
