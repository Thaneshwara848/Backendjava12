package com;

import java.sql.*;
import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // JAR file 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/slbackend","root", "root");
//			Statement stmt=con.createStatement();
//			stmt.execute("insert into employee values(900,'prakash',35,35000,'Dev')");
			
			PreparedStatement stmt=con.prepareStatement("insert into employee values(?,?,?,?,?)");
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter ID     : ");
			int id=sc.nextInt();
			System.out.print("Enter NAME   : ");
			String name=sc.next();
			System.out.print("Enter AGE    : ");
			int age=sc.nextInt();
			System.out.print("Enter SALARY : ");
			int salary=sc.nextInt();
			System.out.print("Enter DESIG  : ");
			String desig=sc.next();
			stmt.setInt(1, id);
			stmt.setString(2,name);
			stmt.setInt(3, age);
			stmt.setInt(4, salary);
			stmt.setString(5, desig);
			
			stmt.execute();
			stmt.close();con.close();
			System.out.println("Data Inserted Succsfully....!");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

