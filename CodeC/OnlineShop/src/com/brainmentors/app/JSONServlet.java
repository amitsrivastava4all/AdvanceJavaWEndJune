package com.brainmentors.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JSONServlet
 */
@WebServlet("/jsondemo.shop")
public class JSONServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        PrintWriter out = response.getWriter();
		String tokenId = request.getParameter("tokenid");
		if(tokenId!=null && tokenId.trim().length()>0) {
			if(Integer.parseInt(tokenId)==1001) {
			
	        
	        out.println("{\"id\":1001,\"name\":\"Ram\",\"salary\":99999}");
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
