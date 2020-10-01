package com.Project;

import java.util.*;

public class accountUI {
	public static void main(String[] args) {
		UserDOASQL SQL = new UserDOASQL();
		boolean stay = true;		
		Scanner sc = new Scanner(System.in);
		while(stay) {
		System.out.println("Sign Up page");
		System.out.println("Enter 1 to Sign Up");
		System.out.println("Enter 2 to delete your account");
		System.out.println("Enter 3 to update your inforamtion");
		System.out.println("Enter 4 to see a list of users");
		System.out.println("To exit enter 5");
		int action = sc.nextInt();
		if(action==1) {
			User user = new User();
			addUser(user,SQL);
		}else if(action==2) {
			System.out.println("Enter your email:");
			String email = sc.next();
			SQL.delUser(email);
		}else if(action==3) {
			System.out.println("Enter your email:");
			String email = sc.next();
			SQL.updateUser(email);
		}else if(action==4) {
			SQL.printUsers();
		}else if(action==5) {
			System.out.println("Bye Bye");
			stay = false;
		}
		else {
			System.out.println("Please enter a valid number");
		}
		
	  }
	}
	public static void addUser(User user,UserDOASQL SQL) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the required information:");
		System.out.println("If at any point you want to quit type in e to exit");
		System.out.println("First Name:");
		while(user.getFirstName().equals("firstname")) {
		String str = sc.next();
		if(str.equals("e")) {
			return; 
		}else {
		user.setFirstName(str);
		}
	  }
		
		System.out.println("Last Name:");
		while(user.getLastName().equals("lastname")) {
		String last = sc.next();
		if(last.equals("e")) {
			return;
		}else {
		user.setLastName(last);
		}
	   }
		
		System.out.println("Email");
		while(user.getEmail().equals("email")) {
		String email = sc.next();
		if(email.equals("e")) {
			return;
		}else {
		user.setEmail(email);
		}
	   }
		
		System.out.println("Password");
		while(user.getPassword().equals("password")) {
		String password = sc.next();
		if(password.equals("e")) {
			return;
		}else {
			user.setPassword(password);
		}
	   }
		
		System.out.println("Gender:");
		while(user.getGender().equals("gender")) {
		String gender = sc.next();
		if(gender.equals("e")) {
			return;
		}else {
		user.setGender(gender);
		}
	   }
		
		System.out.println("BirthDate:");
		System.out.println("Type in 0 to exit");
		System.out.println("Month:");
		while(user.getMonth()==-1) {
		int month = sc.nextInt();
		if(month==0) {
			return;
		}else {
		user.setMonth(month);
		}
	   }
		
		System.out.println("Day:");
		while(user.getDay()==-1) {
		int day = sc.nextInt();
		if(day==0) {
			return;
		}else {
		user.setDay(day);
		}
	   }
		
		System.out.println("Year:");
		while(user.getYear()==-1) {
		int year= sc.nextInt();
		if(year==0) {
			return;
		}else {
		user.setYear(year);
		}
	   }
		
		System.out.println("Name: "+user.getFirstName()+" "+user.getLastName());
		System.out.println("Email: "+user.getEmail());
		System.out.println("Password: "+user.getPassword());
		System.out.println("BirthDate:"+ user.dateOfBirth());
		System.out.println("Gender:"+user.getGender());
		SQL.addUser(user);
	}
	
	
	

	/*public static void main(String[] args) {
		UserDOA list = new UserDOA();
		boolean stay = true;		
		Scanner sc = new Scanner(System.in);
		while(stay) {
		System.out.println("Sign Up page");
		System.out.println("Enter 1 to Sign Up");
		System.out.println("Enter 2 to delete your account");
		System.out.println("Enter 3 to update your inforamtion");
		System.out.println("Enter 4 to see a list of users");
		System.out.println("To exit enter 5");
		int action = sc.nextInt();
		if(action==1) {
			User user = new User();
			addUser(user,list);
		}else if(action==2) {
			System.out.println("Enter your email:");
			String email = sc.next();
			list.removeUser(email);
		}else if(action==3) {
			System.out.println("Enter your email:");
			String email = sc.next();
			list.updateUser(email);
		}else if(action==4) {
			list.printUsers();
		}else if(action==5) {
			System.out.println("Bye Bye");
			stay = false;
		}
		else {
			System.out.println("Please enter a valid number");
		}
		
	  }
	}
	public static void addUser(User user,UserDOA list) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the required information:");
		System.out.println("If at any point you want to quit type in e to exit");
		System.out.println("First Name:");
		while(user.getFirstName().equals("firstname")) {
		String str = sc.next();
		if(str.equals("e")) {
			return; 
		}else {
		user.setFirstName(str);
		}
	  }
		
		System.out.println("Last Name:");
		while(user.getLastName().equals("lastname")) {
		String last = sc.next();
		if(last.equals("e")) {
			return;
		}else {
		user.setLastName(last);
		}
	   }
		
		System.out.println("Email");
		while(user.getEmail().equals("email")) {
		String email = sc.next();
		if(email.equals("e")) {
			return;
		}else {
		user.setEmail(email);
		}
	   }
		
		System.out.println("Password");
		while(user.getPassword().equals("password")) {
		String password = sc.next();
		if(password.equals("e")) {
			return;
		}else {
			user.setPassword(password);
		}
	   }
		
		System.out.println("Gender:");
		while(user.getGender().equals("gender")) {
		String gender = sc.next();
		if(gender.equals("e")) {
			return;
		}else {
		user.setGender(gender);
		}
	   }
		
		System.out.println("BirthDate:");
		System.out.println("Type in 0 to exit");
		System.out.println("Month:");
		while(user.getMonth()==-1) {
		int month = sc.nextInt();
		if(month==0) {
			return;
		}else {
		user.setMonth(month);
		}
	   }
		
		System.out.println("Day:");
		while(user.getDay()==-1) {
		int day = sc.nextInt();
		if(day==0) {
			return;
		}else {
		user.setDay(day);
		}
	   }
		
		System.out.println("Year:");
		while(user.getYear()==-1) {
		int year= sc.nextInt();
		if(year==0) {
			return;
		}else {
		user.setYear(year);
		}
	   }
		
		System.out.println("Name: "+user.getFirstName()+" "+user.getLastName());
		System.out.println("Email: "+user.getEmail());
		System.out.println("Password: "+user.getPassword());
		System.out.println("BirthDate:"+ user.dateOfBirth());
		System.out.println("Gender:"+user.getGender());
		list.addUser(user);
	} */

}
