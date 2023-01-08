package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Valid extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Valid() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String uname=request.getParameter("uname");
			String upass=request.getParameter("upass");
			
			PrintWriter out= response.getWriter();
			if(uname.equalsIgnoreCase("Thanesh") && upass.equalsIgnoreCase("ABC123")) {
//				out.print("<body>");
//				out.print("<b>Hi Welcome to Mr "+uname+"<b>");
//				out.print("</body>");
				RequestDispatcher rd=request.getRequestDispatcher("Home.html");
				rd.forward(request, response);
				
			}
			else {
//				out.print("<body>");
//				out.print("<b>Invalid User name or Password <b>");
//				out.print("</body>");
				out.print("<p style='color:red'>Invalid User name or Password ...!</p>");
				RequestDispatcher rd=request.getRequestDispatcher("Index.html");
				rd.include(request, response);
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
