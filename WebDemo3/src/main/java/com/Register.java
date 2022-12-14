package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String uid=request.getParameter("uid");
	String name = request.getParameter("uname");
	String age = request.getParameter("uage");
	String salary = request.getParameter("usalary");
	String desig= request.getParameter("udesig");
	
	try {
		Class.forName("com.mysql.jdbc.Driver"); // JAR file 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/slbackend","root", "root");
		PreparedStatement stmt=con.prepareStatement("insert into employee values(?,?,?,?,?)");
		
		stmt.setString(1, uid);
		stmt.setString(2,name);
		stmt.setString(3, age);
		stmt.setString(4, salary);
		stmt.setString(5, desig);
		
		stmt.execute();
		stmt.close();con.close();
		System.out.println("Data Inserted Succsfully....!");
		
	} catch (Exception e) {
		System.out.println(e);
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
