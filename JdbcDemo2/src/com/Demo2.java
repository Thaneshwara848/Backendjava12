package com;

import java.sql.*;
public class Demo2 {
	public static void main(String[] args) { 
		try {
			Class.forName("com.mysql.jdbc.Driver"); // JAR file 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/slbackend","root", "root");
			Statement stmt=con.createStatement();
			stmt.execute("insert into employee values(800,'Ramesh',35,35000,'Dev')");
			stmt.close();con.close();
			System.out.println("Data Inserted Succsfully....!");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

