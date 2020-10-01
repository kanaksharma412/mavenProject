package com.Project;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class User {
	private String Email;
	private String Password;
	private String FirstName;
	private String LastName;
	private int Month;
	private int Day;
	private int Year;
	private String Gender;
	
	public User() {
		this.Email = "email";
		this.Password = "password";
		this.FirstName = "firstname";
		this.LastName = "lastname";
		this.Day = -1;
		this.Month = -1;
		this.Year = -1;
		this.Gender = "gender";
		
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pat = Pattern.compile(emailRegex);
		if(pat.matcher(email).matches() && email.length()!=0 ) {
		Email = email;
		}else {
			System.out.println("Please Enter a valid email address");
		}
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		if(password.length()>=8) {
			int NumCount = 0;
			int SpecialCount = 0;
			for(int i=0;i<password.length();i++) {
				if(Character.isDigit(password.charAt(i))) {
					NumCount++;
				}
				if(!Character.isLetter(password.charAt(i)) && !Character.isDigit(password.charAt(i))) {
					SpecialCount++;
				}
			}
			if(Character.isUpperCase(password.charAt(0)) && NumCount > 0 && SpecialCount > 0) {
				Password = password;
			}
		}else {
			System.out.println("The password must be 8 characters or longer with atleast 1 number, 1 special character and the first character must be uppercase");
		}
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		int n = firstName.length();
		String str = firstName.replaceAll("[^a-zA-Z]","");
		int n1 = str.length();
		if(n==n1 && n>=2) {
		FirstName = firstName;
		}else {
			System.out.println("Enter a valid name Ex John,Kanak,Joey");
		}
		
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		int n = lastName.length();
		String str = lastName.replaceAll("[^a-zA-Z]","");
		int n1 = str.length();
		if(n==n1 && n>2) {
		LastName = lastName;
		}else {
			System.out.println("Enter a valid name Ex Sharma,Khan,Singh,Clooney");
		}
	}

	public int getMonth() {
		return Month;
	}

	public void setMonth(int month) {
		if(month >=1 && month <=12) {
		Month = month;
		}else {
			System.out.println("Please Enter a valid month number between 1-12");
		}
	}

	public int getDay() {
		return Day;
	}

	public void setDay(int day) {
		if(day>=1 && day<=31) {
		Day = day;
		} else {
			System.out.println("Please Enter a valid day number between 1-31");
		}
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		if(year>=1903 && year<=2020) {
		Year = year;
		}else {
			System.out.println("Please Enter a valid year number between 1903-2020");
		}
	}
	public String dateOfBirth() {
		 String ans = Month + "/"+ Day + "/" + Year;
		 return ans;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		gender = gender.toLowerCase();
		ArrayList<String> gen = new ArrayList<>();
		gen.add("male");
		gen.add("female");
		gen.add("other");
		if(gen.contains(gender)) {
			Gender = gender;
		}else {
			System.out.println("Enter valid gender male/female/other");
		}
	}
	
	
	
	
	
}
