package com.brainmentors.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.brainmentors.app.dto.CommonGenericDTO;

public interface CommonDAO {
	
	public static ArrayList<CommonGenericDTO> getCommonGenericParameters(String key) throws ClassNotFoundException, SQLException{
		Connection con  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CommonGenericDTO> commonList = new ArrayList<>();
		try{
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(QueryConstants.COMMON_GENERIC_SQL);
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while(rs.next()){
				CommonGenericDTO commonGenericDTO = 
						new CommonGenericDTO(rs.getString("name")
								,rs.getString("descr"));
				commonList.add(commonGenericDTO);
			}
			return commonList;
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Connection con = null;
		
		Context context;
		try {
			InitialContext initialContext = new InitialContext();
			context = (Context) initialContext.lookup("java:comp/env");
			DataSource ds = (DataSource) context.lookup("jdbc/onlineshop");
			con = ds.getConnection();
			con.setAutoCommit(false);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SQLException("Naming Exception "+e);
		}
		
		//		Connection connection = null;
//		ResourceBundle rb = ResourceBundle.getBundle("config");
//		Class.forName(rb.getString("drivername"));
//		
//		  connection = DriverManager
//				 .getConnection(rb.getString("dburl")
//						 ,rb.getString("userid"),rb.getString("password"));
//		
		 return con;
	}

}
