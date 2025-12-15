package com.sunbeam;

import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a message : ");
		String s = sc.nextLine();
		
		try {
			Line l = new Line();
			l.setS(s);
			System.out.println(l.getS());
		} catch(ExceptionLineTooLong e) {
			System.out.println(e.getMessage());
		}
		sc.close();

	}

}
