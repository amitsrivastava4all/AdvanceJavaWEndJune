package com.brainmentors.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JSONServlet
 */
//@WebServlet("/jsondemo.shop")
public class JSONServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customerCareNumber = getServletContext().getInitParameter("customercare");
		//String customerCareNumber = this.getServletConfig().getServletContext().getInitParameter("customercare");
		String toll = this.getServletConfig().getInitParameter("toll");
        PrintWriter out = response.getWriter();
      
        
		String tokenId = request.getParameter("token");
		System.out.println("Token Id "+tokenId+" toll "+toll);
		if(tokenId!=null && tokenId.trim().length()>0) {
			if(Integer.parseInt(tokenId)==1001) {
			
	        out.println("Toll Free Number is "+toll+" Customer Care Number "+customerCareNumber);
	       // out.println("{\"id\":1001,\"name\":\"Ram\",\"salary\":99999}");
			}
			else {
				out.println("Invalid Token Id ");
			}
		}
		else {
			out.println("Provide Token Id ");
		}
		
        out.close();

	}

}
