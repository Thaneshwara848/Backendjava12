package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public InsertRecord() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int uid = Integer.parseInt(request.getParameter("uid"));
		String uname= request.getParameter("uname");
		int uage = Integer.parseInt(request.getParameter("uage"));
		int usalary = Integer.parseInt(request.getParameter("usalary"));
		String udesig= request.getParameter("udesig");
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // JAR file 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/crudapp","root", "root");
			PreparedStatement pstmt=con.prepareStatement(" insert into employee values(?,?,?,?,?)");
			pstmt.setInt(1, uid);
			pstmt.setString(2, uname);
			pstmt.setInt(3, uage);
			pstmt.setInt(4, usalary);
			pstmt.setString(5, udesig);
			
			pstmt.execute();
			pstmt.close();
			
			PrintWriter out= response.getWriter();
			out.print("<h2>Hi Data InsertedSuccesssfully...!</h2>");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
