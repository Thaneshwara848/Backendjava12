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

/**
 * Servlet implementation class UpdateRecord
 */
public class UpdateRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		int usalary = Integer.parseInt(request.getParameter("usalary"));
		try {
			Class.forName("com.mysql.jdbc.Driver"); // JAR file 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/crudapp","root", "root");
			PreparedStatement pstmt=con.prepareStatement("update employee set salary= ?  where id = ? ");
			pstmt.setInt(1, usalary);
			pstmt.setInt(2,uid);
			
			pstmt.execute();
			pstmt.close();
			
			PrintWriter out= response.getWriter();
			out.print("<h2>Hi Data Updated Successfully ...!</h2>");
		}
		catch (Exception e) {
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
