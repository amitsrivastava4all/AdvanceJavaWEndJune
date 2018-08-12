package com.brainmentors.app;

import static com.brainmentors.utils.CommonUtils.convertPrintStackTraceIntoString;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.brainmentors.app.dao.UserDAO;
import com.brainmentors.app.dto.UserDTO;
import com.brainmentors.utils.LangReader;

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
		String lang  = request.getParameter("lang");
		logger.debug("Inside LoginServlet Service Userid is "+userid);
		UserDAO userDAO = new UserDAO();
		try {
			UserDTO userDTO = userDAO.doLogin(userid, password);
			if(userDTO!=null){
				HttpSession session = request.getSession(true);
				session.setAttribute("currentlang", lang);
				LangReader.setLang(lang);
				
				System.out.println("Session Created  "+session.getId());
				System.out.println("Session Created Time "+session.getCreationTime());
				session.setAttribute("uid", userDTO.getUserName());
				session.setAttribute("userdata", userDTO);
				double balance = 90000;
				response.sendRedirect("dashboard.jsp?balance="+balance);
//				RequestDispatcher rd = request
//						.getRequestDispatcher("dashboard.jsp");
//				rd.forward(request, response);
				//response.sendRedirect(arg0);
			}
			else{
				out.println("Invalid Userid or Password....");
			}
			
			/*String message = userDAO.doLogin(userid, password);
			if(message.contains("Welcome")){
				response.sendRedirect("dashboard.html");
			}
			else
			out.println(message);
			*/
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
