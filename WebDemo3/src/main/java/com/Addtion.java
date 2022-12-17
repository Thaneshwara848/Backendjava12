package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addtion
 */
public class Addtion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Addtion() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int a =Integer.parseInt(request.getParameter("aval"));
		int b= Integer.parseInt(request.getParameter("bval"));
		int res = a+ b ;
		PrintWriter out= response.getWriter();
		out.print("The SUm of A+ B is : "+ res );
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
