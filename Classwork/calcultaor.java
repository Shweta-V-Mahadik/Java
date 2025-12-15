package com.sunbeam;

import java.util.Scanner;

public class calcultaor {
	
	public static int menu(Scanner sc) {
		System.out.println("\n1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
		System.out.println("0. Exit");
		System.out.print("Enter choice : ");
		return sc.nextInt();
	}

	public static int add(int a, int b) {
		return a + b;
	}
	
	public static int sub(int a, int b) {
		return a - b;
	}
	
	public static int mul(int a, int b) {
		return a * b;
	}
	
	public static int div(int a, int b) {
		return a / b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int choice;
		
		while((choice = menu(sc)) != 0) {
			System.out.println("Enter two numbers : ");
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			
			switch(choice) {
			
			case 1:
				System.out.println(a + " + " + b + " = " + add(a, b));
			break;
			
			case 2:
				System.out.println(a + " - " + b + " = " + sub(a, b));
			break;
			
			case 3:
				System.out.println(a + " * " + b + " = " + mul(a, b));
			break;
			
			case 4:
				System.out.println(a + " / " + b + " = " + div(a, b));
			break;
			
			default:
				System.out.println("Invalid choice !");
				
				
			}
		}
		
		
		
	}

}
