package com.brainmentors.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("pwd");
		if(userid.equals(password)){
			out.println("Welcome "+userid);
		}
		else{
			out.println("Invalid Userid or Password");
		}
		out.close();
		
	}

}
