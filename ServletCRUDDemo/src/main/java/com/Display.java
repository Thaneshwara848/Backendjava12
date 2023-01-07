package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Display() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // JAR file 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/crudapp","root", "root");
			Statement stmt= con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from employee");
			
		
			PrintWriter out= response.getWriter();
			while (rs.next()) {
out.print(rs.getInt(1)+": "+rs.getString(2)+": "+rs.getInt(3)+": "+rs.getInt(4)+": "+rs.getString(5));
		out.print("<br>");		
			}
			
			out.print("<h2> Successfully ...!</h2>");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
