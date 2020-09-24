package com.Project;
import java.util.*;
public class UserDOA {
	private ArrayList<User> list = new ArrayList<User>();
	
	public void addUser(User user) {
		list.add(user);
	}
	
	public void removeUser(String email) {
		boolean present = false;
		if(email.length()==0) throw new IllegalArgumentException("email cannot be null");
		if(list.size()==0) throw new IllegalArgumentException("You need to make an accout first the list is empty");
		User remUser = null;
		for(User user : list) {
			if(user.getEmail().equals(email)) {
				remUser = user;
				present = true;
			}
		}
		if(present==false) throw new IllegalArgumentException("Your Not in the list!"); 
		System.out.println(remUser.getFirstName()+" "+remUser.getLastName()+ " has been removed");
		list.remove(remUser);
	}
	public void updateUser(String email) {
		boolean present = false;
		if(email.length()==0) throw new IllegalArgumentException("email cannot be null");
		if(list.size()==0) throw new IllegalArgumentException("You need to make an accout first the list is empty");
		User updateUser = null;
		for(User user : list) {
			if(user.getEmail().equals(email)) {
				updateUser = user;
				present = true;
			}
		}
		if(present==false) throw new IllegalArgumentException("Your not in the list!");
		Scanner sc = new Scanner(System.in);
		System.out.println("What do you want to update:");
		System.out.println("Enter 1 to update Last Name");
		System.out.println("Enter 2 to update email");
		System.out.println("Enter 3 to update password");
		int change = sc.nextInt();
		if(change == 1) {
			System.out.println("Enter new Last Name:");
			String newLN = sc.next();
			updateUser.setLastName(newLN);
		}else if(change == 2) {
			System.out.println("Enter new email:");
			String newEmail = sc.next();
			updateUser.setEmail(newEmail);
		}else if(change == 3) {
			System.out.println("Enter new password:");
			String password = sc.next();
			updateUser.setPassword(password);
		}else {
			System.out.println("Enter a valid number to update user!");
		}
	}
	public void printUsers() {
		int i = 1;
		if(list.size()==0) {
		System.out.println("No users at the moment!");
		}else {
			System.out.println("Users:");
			for(User user : list) {
				System.out.println(i+")"+user.getFirstName()+" "+user.getLastName());
				i++;
			}
		}
	}
		
	
}
