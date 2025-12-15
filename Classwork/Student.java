package com.sunbeam;

import java.util.Scanner;

public class Student {
	
	private String name;
	private float m1;
	private float m2;
	private float m3;
	private int rollNo;
	
	public Student() {
		
	}
	
	public Student(String name, float m1, float m2, float m3, int rollNo) {
		super();
		this.name = name;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getM1() {
		return m1;
	}
	
	public float getM2() {
		return m2;
	}
	
	public float getM3() {
		return m3;
	}
	
	public void setM1(float m1) {
		this.m1 = m1;
	}
	
	public void setM2(float m2) {
		this.m2 = m2;
	}
	
	public void setM3(float m3) {
		this.m3 = m3;
	}
	
	public int getRollNo() {
		return rollNo;
	}
	
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public void accept(Scanner sc) {
		
		System.out.print("Enter student name : ");
		setName(sc.next());
		System.out.print("Enter roll number  : ");
		setRollNo(sc.nextInt());
		System.out.print("Enter marks of subject 1 : ");
		setM1(sc.nextFloat());
		System.out.print("Enter marks of subject 2 : ");
		setM2(sc.nextFloat());
		System.out.print("Enter marks of subject 3 : ");
		setM3(sc.nextFloat());
		
		
	}
	
	
	public void display() {
		System.out.println("\n--- Student details --- ");
		System.out.println("Name : " + getName());
		System.out.println("Roll Number : " + getRollNo());
		System.out.println("Percentage :  "+ (((m1 + m2 + m3)/60.0) * 100));
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Student s = new Student();
		s.accept(sc);
		s.display();
	}

}
