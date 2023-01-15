package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidatePage
 */
public class ValidatePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidatePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String  uname=request.getParameter("uname");
		String  upass=request.getParameter("upass");
		try {
			Class.forName("com.mysql.jdbc.Driver"); // JAR file 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/slbackend","root", "root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from employee");
			PrintWriter out=response.getWriter();
			while(rs.next()) {
				if(uname.equalsIgnoreCase(rs.getString(2))&& upass.equalsIgnoreCase(rs.getString(6))) {
					RequestDispatcher rd=request.getRequestDispatcher("index.html");
					rd.forward(request, response);
				}
				else {
					out.print("<p style='color:red'>Invalid Credentials Please try once again <p>");
					RequestDispatcher rd=request.getRequestDispatcher("login.html");
					rd.include(request, response);
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
