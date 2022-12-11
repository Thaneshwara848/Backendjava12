package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) {
	
		try {
			Class.forName("com.mysql.jdbc.Driver"); // JAR file 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/slbackend","root", "root");
			PreparedStatement stmt=con.prepareStatement("delete from employee where id=? ");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter ID : ");
			int id=sc.nextInt();
			
			stmt.setInt(1,id);
			stmt.execute();
			stmt.close();con.close();
			
			System.out.println("Data Deleted Successfully...!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

// insert
// delete 
// update 

