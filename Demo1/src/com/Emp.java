package com;
import java.util.Scanner;

class A 
{
	int id;
	String name;
	int age;
	int salary;
	String desig;

	
	A()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter ID : ");
		 id=sc.nextInt();
		
		System.out.println("Enter Name : ");
		 name= sc.next();
		
		System.out.println("Enter Age : ");
		 age= sc.nextInt();
	
		System.out.println("Enter Salary ");
		 salary= sc.nextInt();
		
		System.out.println("Enter Desig: ");
		 desig= sc.next();
	}
	void display()
	{
		System.out.println("ID : "+id);
		System.out.println("Name : "+name);
		System.out.println("Age : "+age);
		System.out.println("Salary :"+salary);
		System.out.println("Designation : "+desig);	
	}
}
public class Emp {

	public static void main(String[] args) {
		A  a = new A();
		a.display();
	}
}