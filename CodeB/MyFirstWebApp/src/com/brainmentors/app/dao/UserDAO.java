package com.brainmentors.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class B{
	static{
		System.out.println("B Static Block call");
	}
}
class A{
	A(){
		System.out.println("A Cons Call");
	}
	static{
		System.out.println("A Static Block call");
	}
}
public class UserDAO {
 public static void main(String[] args) throws ClassNotFoundException, SQLException {
	//java.util.Scanner s = new java.util.Scanner("");
	 // Step -1 
	 // Load a Driver
	// A1 obj = new A1(); //eager
	 Scanner s = new Scanner(System.in);
//	 System.out.println("Enter the Class Name to Load...");
//	 String className=s.next();
//	 String fullClassName = "com.brainmentors.app.dao."+className;
//	 Class.forName(fullClassName); //lazy
	// A obj = new A();
	 //A obj2 = new A();
	 System.out.println("Enter the Userid");
	 String userid = s.next();
	 System.out.println("Enter the Password");
	 String pwd = s.next();
	 
	 Class.forName("org.postgresql.Driver");
	 
	 // Step - 2 Create a Connection
	 // http://
	 // jdbc:postgresql://localhost:5432/onlineshop
	 Connection connection = DriverManager
			 .getConnection("jdbc:postgresql://localhost:5432/onlineshop"
					 ,"amit","amit123");
	 if(connection!=null){
		 System.out.println("Connection Created....");
	 }
	 // Step-3 Do Query
	 Statement stmt = connection.createStatement();
	 ResultSet rs = stmt.executeQuery("SELECT userid, password "
	 		+ "FROM user_details where userid='"
			 +userid+"' AND password='"+pwd+"'");
	 if(rs.next()){
		 System.out.println("Welcome "+rs.getString("userid"));
	 }
	 else{
		 System.out.println("Invalid Userid or Password");
	 }
	 rs.close();
	 stmt.close();
	 connection.close();
	 
	 
}

}
