package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
class Emp
{
	static void insert()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver"); // JAR file 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/slbackend","root", "root");
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
	
	static void display()
	{	
		try {
			Class.forName("com.mysql.jdbc.Driver"); // JAR file 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/slbackend","root", "root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from Employee ");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" : "+rs.getString(2)+": "+rs.getInt(3)
				+" : "+rs.getInt(4)+" : "+rs.getString(5));
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	static void update()
	{	
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
	static void delete()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver"); // JAR file 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/slbackend","root", "root");
			PreparedStatement stmt=con.prepareStatement("delete from employee where id=? ");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter ID : ");
			int id=sc.nextInt();
			
			System.out.println("Hy Boss Do you really Want to Delete ? y / N ");
			String op=sc.next();
			if(op.equalsIgnoreCase("Yes") || op.equalsIgnoreCase("y"))
			{
			stmt.setInt(1,id);
			stmt.execute();
			}
			else {
				System.out.println("Recored Not Deleted....!");
			}
			stmt.close();con.close();
			
			System.out.println("Data Deleted Successfully...!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
public class Project {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			System.out.println("1 ) Create ");
			System.out.println("2 ) Display ");
			System.out.println("3 ) Update ");
			System.out.println("4 ) Delete ");
		
			System.out.println("CHoice ?  ");
			ch=sc.nextInt();
			if(ch==1)
			{
				Emp.insert();
			}
			if(ch==2)
			{
				Emp.display();
			}
			if(ch==3)
			{
				Emp.update();
			}
			if(ch==4)
			{
				Emp.delete();
			}
		}while(ch<=4);
	}
}







