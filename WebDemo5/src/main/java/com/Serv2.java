package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Serv2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Serv2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
try {
			
			
			
			ServletConfig config=getServletConfig();
			
			String mydriver=config.getInitParameter("driver");
			String myurl=config.getInitParameter("url");
			String uname=config.getInitParameter("username");
			String upass=config.getInitParameter("password");
			
			
			System.out.println(mydriver);
			System.out.println(myurl);
			System.out.println(uname);
			System.out.println(upass);
			
			Class.forName(mydriver); // JAR file 
			Connection con = DriverManager.getConnection(myurl,uname, upass);
			PreparedStatement stmt=con.prepareStatement("insert into employee values(?,?,?,?,?)");
		
			stmt.setString(1,"333");
			stmt.setString(2,"AAA");
			stmt.setString(3, "99");
			stmt.setString(4, "444444");
			stmt.setString(5, "TTTTT");
			
			stmt.execute();
			stmt.close();con.close();
			PrintWriter out= response.getWriter();
			out.println("Data Inserted Succsfully....!<br>");
			out.print("<a href='index.html'>Home page </a>");
			
		} catch (Exception e) {
			System.out.println(e);
		}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
