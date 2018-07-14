package com.brainmentors.app;

import static com.brainmentors.utils.CommonUtils.convertPrintStackTraceIntoString;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.brainmentors.app.dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	Logger logger = Logger.getLogger(LoginServlet.class);
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		logger.debug("Inside LoginServlet Service");
		PrintWriter out = response.getWriter();
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("pwd");
		logger.debug("Inside LoginServlet Service Userid is "+userid);
		UserDAO userDAO = new UserDAO();
		try {
			String message = userDAO.doLogin(userid, password);
			out.println(message);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(convertPrintStackTraceIntoString(e));
			//e.print
			//e.printStackTrace();
			response.sendRedirect("error.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(convertPrintStackTraceIntoString(e));
			response.sendRedirect("error.html");
		}
		catch(Exception e){
			logger.error(convertPrintStackTraceIntoString(e));
			response.sendRedirect("error.html");
		}
//		if(userid.equals(password)){
//			out.println("Welcome "+userid);
//		}
//		else{
//			out.println("Invalid Userid or Password");
//		}
		out.close();
		
	}

}
