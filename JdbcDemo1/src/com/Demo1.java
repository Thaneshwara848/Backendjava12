package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo1 {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3307/backend","root","root");
			Statement stmt=con.createStatement();
			stmt.execute("insert into employee values(500,'prathap',25,50000,'CLERK')");
			stmt.close();con.close();
			System.out.println("Data Inserted Successfully...!");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
