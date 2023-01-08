package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextDemo3
 */
public class ContextDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextDemo3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			//ServletConfig config=getServletConfig();
			
			ServletContext context=getServletContext();
			String mydriver=context.getInitParameter("mydriver");
			
			System.out.println(mydriver);
			
			Class.forName(mydriver); // JAR file 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/slbackend","root", "root");
			PreparedStatement stmt=con.prepareStatement("insert into employee values(?,?,?,?,?)");
		
			stmt.setString(1,"333");
			stmt.setString(2,"CCC");
			stmt.setString(3, "43");
			stmt.setString(4, "232432");
			stmt.setString(5, "DDDD");
			
			stmt.execute();
			stmt.close();con.close();
			PrintWriter out= response.getWriter();
			out.println("Data Inserted Succsfully....!<br>");
			out.print("<a href='index.html'>Home page </a>");
			
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
