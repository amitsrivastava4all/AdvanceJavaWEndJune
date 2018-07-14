package com.brainmentors.app.dao;

import static com.brainmentors.utils.CommonDAO.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.brainmentors.utils.QueryConstants;

//class B{
//	static{
//		System.out.println("B Static Block call");
//	}
//}
//class A{
//	A(){
//		System.out.println("A Cons Call");
//	}
//	static{
//		System.out.println("A Static Block call");
//	}
//}
public class UserDAO {
	Logger logger = Logger.getLogger(UserDAO.class);
	
	public String doRegister(String userid , String password) throws ClassNotFoundException, SQLException{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{ 
		connection = getConnection();
		logger.debug("Inside UserDAO After Creating Connection..."+userid);
		  pstmt = connection.prepareStatement(QueryConstants.REGISTER_SQL);
		  pstmt.setString(1, userid);
		  pstmt.setString(2, password);
		  int noOfRecordsUpdated = pstmt.executeUpdate();
		
		 if(noOfRecordsUpdated>0){
			 logger.debug("Record Added....");
			 return "Register SuccessFully";
		 }
		 else{
			 logger.debug("No Record Found....");
			 return "Error in Register...";
		 }
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(connection!=null){
				connection.close();
			}
			 logger.debug("Resources Close....");
		}
	}
	
	public String doLogin(String userid , String password) throws SQLException, ClassNotFoundException{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{ 
		connection = getConnection();
		logger.debug("Inside UserDAO After Creating Connection..."+userid);
		  pstmt = connection.prepareStatement(QueryConstants.LOGIN_SQL);
		  pstmt.setString(1, userid);
		  pstmt.setString(2, password);
		  rs = pstmt.executeQuery();
		
		 if(rs.next()){
			 logger.debug("Record Found....");
			 return "Welcome "+rs.getString("userid");
		 }
		 else{
			 logger.debug("No Record Found....");
			 return "Invalid Userid or Password";
		 }
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(connection!=null){
				connection.close();
			}
			 logger.debug("Resources Close....");
		}
		}
	
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
	 UserDAO userDAO = new UserDAO();
	String message =  userDAO.doRegister(userid, pwd);
	System.out.println(message);
	 
//	 Class.forName("org.postgresql.Driver");
//	 
//	 // Step - 2 Create a Connection
//	 // http://
//	 // jdbc:postgresql://localhost:5432/onlineshop
//	 Connection connection = DriverManager
//			 .getConnection("jdbc:postgresql://localhost:5432/onlineshop"
//					 ,"amit","amit123");
//	 if(connection!=null){
//		 System.out.println("Connection Created....");
//	 }
//	 // Step-3 Do Query
//	 Statement stmt = connection.createStatement();
//	 ResultSet rs = stmt.executeQuery("SELECT userid, password "
//	 		+ "FROM user_details where userid='"
//			 +userid+"' AND password='"+pwd+"'");
//	 if(rs.next()){
//		 System.out.println("Welcome "+rs.getString("userid"));
//	 }
//	 else{
//		 System.out.println("Invalid Userid or Password");
//	 }
//	 rs.close();
//	 stmt.close();
//	 connection.close();
	 
	 
}

}
