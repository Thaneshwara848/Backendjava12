package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleterecord
 */
public class deleterecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleterecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String uid= request.getParameter("uid");
	try {
		Class.forName("com.mysql.jdbc.Driver"); // JAR file 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/slbackend","root", "root");
		PreparedStatement stmt=con.prepareStatement("delete from employee where id= ? ");
	
		stmt.setString(1, uid);
		
		stmt.execute();
		stmt.close();con.close();
		System.out.println("Data Deleted Succsfully....!");
		

	} catch (Exception e) {
		System.out.println(e);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
