package com.sunbeam;

import java.util.Objects;
import java.util.Scanner;

class Student implements Comparable<Student>{

	String name;
	int rollNo;
	double marks;
	
	public Student() {
		
	}
	
	public Student(String name, int rollNo, int marks ) {
		this.name = name;
		this.rollNo = rollNo;
		this.marks = marks;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public void setMarks(double marks) {
		this.marks = marks;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getRollNo() {
		return this.rollNo;
	}
	
	public double getMarks() {
		return this.marks;
	}
	
	public void accept(Scanner sc) {
		System.out.print("Enter name of student : ");
		setName(sc.next());
		System.out.print("Enter roll number : ");
		setRollNo(sc.nextInt());
		System.out.print("Enter marks : ");
		setMarks(sc.nextDouble());
	}

	@Override
	public int hashCode() {
		return Objects.hash(rollNo);
	}

	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(obj instanceof Student) {
			Student s = (Student) obj;
			if(this.rollNo == s.rollNo)
				return true;
		}
		return false;
		
	}
	

	@Override
	public String toString() {
		return "Student [ Name : " + name + ", Roll Number = " + rollNo + ", Marks : " + marks + " ] \n";
	}

	@Override
	public int compareTo(Student o) {
		return this.rollNo - o.rollNo;
		
	}

	
}
