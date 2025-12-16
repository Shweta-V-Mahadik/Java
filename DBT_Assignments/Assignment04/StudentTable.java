package com.sunbeam.p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentTable {

	private static final String URL = "jdbc:mysql://localhost:3306/internship_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "manager";
	
	public  static Connection getConnection() throws SQLException{
		
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	
	static Scanner sc = new Scanner(System.in);
	
	
	//menu for menu driven
	public static int menu(Scanner sc) {
		System.out.println("\n------: Student Records :-----");
		System.out.println("1. View all students");
		System.out.println("2. Add student");
		System.out.println("3. Update students course");
		System.out.println("4. Delete student");
		System.out.println("5. Exit");
		System.out.print("Enter choice  : ");
		return sc.nextInt();
	}
	
	//select  -----DQL commands -> .executeQuery();
	public static void getAllStudents() {
		
		try {
			
		//String sql = "SELECT rollno, name, email, course FROM Students";
		String sql = "SELECT * FROM Students";
		Connection connection = getConnection();
		PreparedStatement selectStatement = connection.prepareStatement(sql);
		ResultSet rs = selectStatement.executeQuery();  //rs points to the table 
		
		//to iterate rows of table
		while(rs.next()) {     //iterate until there are rows in table
			
			int rollno = rs.getInt(1);
			String name = rs.getString(2);
			String email = rs.getString(3);
			//String course = rs.getString(4);
			String course = rs.getString(5);
			System.out.println(rollno + " - " + name + " - " + email + " - " + course);
		}
		
		connection.close();
		selectStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	
	//insert -----DML commands -> .executeUpdate();
	public static void addStudent() {
		
		
		String sql = "INSERT INTO Students(name, email, course) VALUES(?, ?, ?)";
		
		try {
			Connection connection = getConnection();
			PreparedStatement insertStatement = connection.prepareStatement(sql);
			
			System.out.print("Enter name of student : ");
			String name = sc.next();
			System.out.print("Enter email of student : ");
			String email = sc.next();
			System.out.print("Enter course of student : ");
			String course = sc.next();
			
			insertStatement.setString(1, name);
			insertStatement.setString(2, email);
			insertStatement.setString(3, course);
			insertStatement.executeUpdate();
			
			connection.close();
			insertStatement.close();
			System.out.println("Student inserted into the table");
		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}
	
		// update
		public static void updateStudent() {
			
			// To-Do
			
			String sql = "UPDATE Students SET course = ? WHERE email = ?";
			
			try {
				
				Connection connection = getConnection();
				PreparedStatement updateStatement = connection.prepareStatement(sql);
				
				System.out.print("Enter email of student whose course is to be changed : ");
				String email = sc.next();
				
				System.out.print("Enter the new course : ");
				String course = sc.next();
				
				
				updateStatement.setString(1,course);
				updateStatement.setString(2,email);
				updateStatement.executeUpdate();
				
				updateStatement.close();
				connection.close();
				
				System.out.println("Student details updated");
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}

		// delete
		public static void deleteStudent() {
			// To-Do
		
			String sql = " DELETE FROM Students WHERE email = ?";
			
			try {
				
				Connection connection = getConnection();
				PreparedStatement deleteStatement = connection.prepareStatement(sql);
				
				System.out.print("Enter email of student to be deleted : ");
				String email = sc.next();
				
				deleteStatement.setString(1, email);
				deleteStatement.executeUpdate();
				connection.close();
				deleteStatement.close();
				System.out.println("Student record deleted");
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice;
		while((choice = menu(sc)) != 5) {
			switch(choice) {
			case 1:
				getAllStudents();
			break;
			
			case 2:
				addStudent();
			break;
			
			case 3:
				updateStudent();
			break;
			
			case 4:
				deleteStudent();
			break;
			
			default:
				System.out.println("Invalid choice !!");
			break;
			}
		}
		

	}
	

}
