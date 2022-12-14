package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Demo3 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // JAR file 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/slbackend","root", "root");
			PreparedStatement stmt=con.prepareStatement("update employee set salary=? where id=?");
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter ID : ");
			int id=sc.nextInt();
			
			System.out.println("Enter Salary:");
			int salary=sc.nextInt();
			
			stmt.setInt(1,salary);
			stmt.setInt(2,id);
			
			stmt.execute();
			stmt.close();con.close();
			
			System.out.println("Data Updated  Successfully...!");
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}



