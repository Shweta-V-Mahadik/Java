package com.sunbeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static int menu(Scanner sc) {
		System.out.println("\n--- Menu ---");
		System.out.println("1. Add the student");
		System.out.println("2. Display all the students");
		System.out.println("3. Search the student on roll number");
		System.out.println("4. Sort students on roll number");
		System.out.println("5. Sort students on name");
		System.out.println("6. Sort students on marks");
		System.out.println("0. Exit");
		System.out.print("Enter choice : ");
		return sc.nextInt();
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int choice;
		
		List <Student> list = new ArrayList<Student>();
		
		class StudentNameComparator implements Comparator<Student> {
			@Override
			public int compare(Student obj1, Student obj2) {
				return obj1.name.compareTo(obj2.name);
			}
		}
		StudentNameComparator stuNameComparator = new StudentNameComparator();
		
		class StudentMarksComparator implements Comparator<Student> {
			@Override
			public int compare(Student obj1, Student obj2) {
				return Double.compare(obj1.marks, obj2.marks);
			}
		}
		StudentMarksComparator stuMarksComparator = new StudentMarksComparator();
		
		while((choice = menu(sc) )!= 0) {
			switch(choice) {
			
				case 1:
					Student s = new Student();
					s.accept(sc);
					list.add(s);
				break;
			
			
				case 2:
					
					for(Student stu : list) {
						String s1 = stu.toString();
						System.out.println(s1);
					}
				break;
				
				case 3:
				    System.out.print("Enter roll number of student to be searched : ");
				    int rno = sc.nextInt();
				    
				    Student searchKey = new Student();
				    searchKey.setRollNo(rno);
				    
				    if(list.contains(searchKey)) {
				        System.out.println("Student " + rno + " found !");
				        
				        
				    } else {
				        System.out.println("Student not found !!");
				    }
				    break;
				
				
				case 4:
					Collections.sort(list);
					System.out.println(list);
				break;
				
				
				case 5:
					list.sort(stuNameComparator);
					System.out.println(list);
				break;
				
				
				case 6:
					list.sort(stuMarksComparator);
					System.out.println(list);
				break;
				
				
				case 0:
					return;
			}
		
		}

	}
}
