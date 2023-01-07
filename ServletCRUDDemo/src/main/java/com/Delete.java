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

public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Delete() {
        super();   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		try {
			Class.forName("com.mysql.jdbc.Driver"); // JAR file 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/crudapp","root", "root");
			PreparedStatement pstmt=con.prepareStatement("delete from employee where id = ? ");
			pstmt.setInt(1,uid);
			
			pstmt.execute();
			pstmt.close();
			
			PrintWriter out= response.getWriter();
			out.print("<h2>Hi Data Deleted  Successfully ...!</h2>");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
