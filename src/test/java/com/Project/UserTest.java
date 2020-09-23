package com.Project;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void testsetEmail() {
		String email= "kanaksharma412@gwu.edu";
		User user1 = new User();
		user1.setEmail("kanaksharma412@gwu.edu");
		assertEquals(email,user1.getEmail());
		System.out.println("Test for valid email passed");
	}
	@Test
	public void testsetPassword() {
		String password = "Kkaannaakk123!";
		User user1 = new User();
		user1.setPassword("Kkaannaakk123!");
		assertEquals(password,user1.getPassword());
		System.out.println("Test for valid password passed");
	}
	@Test
	public void testName() {
		String Name = "Kanak Sharma";
		User user1 = new User();
		user1.setFirstName("Kanak");
		user1.setLastName("Sharma");
		assertEquals(Name,user1.getFirstName()+" "+user1.getLastName());
		System.out.println("Test for valid name passed");
		
	}
	@Test
	public void testBirstDate() {
		int month = 12;
		int day = 4;
		int year = 1995;
		User user1 = new User();
		user1.setMonth(12);
		user1.setDay(4);
		user1.setYear(1995);
		assertEquals(month+"/"+day+"/"+year,user1.getMonth()+"/"+user1.getDay()+"/"+user1.getYear());
		System.out.println("Test for valid date of birth passed");
	}
	@Test
	public void testGender() {
		String gender = "male";
		User user1 = new User();
		user1.setGender("Male");
		assertEquals(gender,user1.getGender());
		System.out.println("Test for valid gender passed");
	}	
}
