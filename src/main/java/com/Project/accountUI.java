package com.Project;

import java.util.*;

public class accountUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User1();
		
	}
	public static void User1() {
		Scanner sc = new Scanner(System.in);
		User user1 = new User();
		System.out.println("First Name:");
		String str = sc.nextLine();
		user1.setFirstName(str);
		System.out.println("Last Name:");
		String last = sc.nextLine();
		user1.setLastName(last);
		System.out.println("Email");
		String email = sc.nextLine();
		user1.setEmail(email);
		System.out.println("Password");
		String password = sc.nextLine();
		user1.setPassword(password);
		System.out.println("Gender:");
		String gender = sc.nextLine();
		user1.setGender(gender);
		System.out.println("BirthDate:");
		System.out.println("Month:");
		int month = sc.nextInt();
		user1.setMonth(month);
		System.out.println("Day:");
		int day = sc.nextInt();
		user1.setDay(day);
		System.out.println("Year:");
		int year= sc.nextInt();
		user1.setYear(year);
		
		System.out.println("Name: "+user1.getFirstName()+" "+user1.getLastName());
		System.out.println("Email: "+user1.getEmail());
		System.out.println("Password: "+user1.getPassword());
		System.out.println("BirthDate:"+user1.getMonth()+"/"+user1.getDay()+"/"+user1.getYear());
		System.out.println("Gender:"+user1.getGender());
	}

}
