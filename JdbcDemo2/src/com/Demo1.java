package com;

import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ID : ");
		int id=sc.nextInt();
		
		System.out.print("NAME  : ");
		String name=sc.next();
		
		System.out.print("AGE : ");
		int age= sc.nextInt();
		
		System.out.print("SALARY : ");
		int salary= sc.nextInt();
		
		System.out.print("DESIG: ");
		String desig= sc.next();
		
		System.out.println("ID :"+id);
		System.out.println("NAME :"+name);
		System.out.println("Age : "+age );
		System.out.println("Salary :"+salary);
		System.out.println("Desig :"+desig);
		
	}
}


