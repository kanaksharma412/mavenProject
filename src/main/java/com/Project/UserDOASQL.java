package com.Project;
import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;



public class UserDOASQL {
	private static final String Conn_String = "jdbc:mysql://localhost:3306/users";
	private static final String UserName = "kanak";
	private static final String Password = "1234";
	public void addUser(User user) {
		try {
		      //Class.forName("com.mysql.jdbc.Driver");
		      Connection myConn = DriverManager.getConnection(Conn_String,UserName,Password);
		      Statement myStmt = myConn.createStatement();
		      String FirstName = user.getFirstName();
		      String LastName = user.getLastName();
		      String Email = user.getEmail();
		      String Password = user.getPassword();
		      String BirthDate = user.dateOfBirth();
		      String Gender = user.getGender();
		      String sql = "insert into users"+"(FirstName, LastName, Email, Password, BirthDate, Gender)"+"values ('"+FirstName+"', '"+LastName+"', '"+Email+"', '"+Password+"', '"+BirthDate+"', '"+Gender+"')";
		      myStmt.executeUpdate(sql);
		      System.out.println("Insert complete.");
		}catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	public  void delUser(String myEmail) {
		
		try {
		      //Class.forName("com.mysql.jdbc.Driver");
		      Connection myConn = DriverManager.getConnection(Conn_String,UserName,Password);
		      Statement myStmt = myConn.createStatement();
		      String sql = "delete from users where Email='"+myEmail+"'";
		      int rs = myStmt.executeUpdate(sql);
		     
		      if(rs>0) { 
		    	  System.out.println("Deletion complete.");
		      }else {
		    	 System.out.println("Your not in the system!");
		    	 }
		      }
		      catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	public void updateUser(String myEmail) {
		Scanner sc = new Scanner(System.in);
		try {
			//Class.forName("com.mysql.jdbc.Driver");
		      Connection myConn = DriverManager.getConnection(Conn_String,UserName,Password);
		      Statement myStmt = myConn.createStatement();
		      
		      String SQL = "SELECT *FROM users WHERE Email = '"+myEmail+"'";
		      ResultSet rs = myStmt.executeQuery(SQL);
		      
		      if(rs.next()) {
		      System.out.println("What do you want to update:");
			  System.out.println("Enter 1 to update Last Name");
			  System.out.println("Enter 2 to update email");
			  System.out.println("Enter 3 to update password");
		      int update = sc.nextInt();
		      if(update==1) {
		    	 System.out.println("Enter new Last Name:");
		    	 String LastName = sc.next();
		    	 int n = LastName.length();
		 		 String str = LastName.replaceAll("[^a-zA-Z]","");
		 		 int n1 = str.length();
		 		 if(n==n1 && n>2) {
		    	 String sql = "update users set LastName = '"+LastName+"' where Email = '"+myEmail+"'";
		    	 myStmt.executeUpdate(sql);
		    	 System.out.println("Updated LastName");
		    	 }else {
		    		 System.out.println("Invalid Last name");
		    	 }
		      }else if(update==2) {
		    	  System.out.println("Enter new Email:");
		    	  String Email = sc.next();
		    	  String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		  	            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		  		  Pattern pat = Pattern.compile(emailRegex);
		  		  if(pat.matcher(Email).matches() && Email.length()!=0 ) {
		    	  String sql = "update users set Email = '"+Email+"' where Email = '"+myEmail+"'";
		    	  myStmt.executeUpdate(sql);
		    	  System.out.println("Updated Email");
		    	 }else {
		    		 System.out.println("Enter a valid Email");
		    		 return;
		    	 }
		      }else if(update==3) {
		    	  System.out.println("Enter new Password:");
		    	  String Password = sc.next();
		    	  if(Password.length()>=8) {
		  			int NumCount = 0;
		  			int SpecialCount = 0;
		  			for(int i=0;i<Password.length();i++) {
		  				if(Character.isDigit(Password.charAt(i))) {
		  					NumCount++;
		  				}
		  				if(!Character.isLetter(Password.charAt(i)) && !Character.isDigit(Password.charAt(i))) {
		  					SpecialCount++;
		  				}
		  			}
		  			if(Character.isUpperCase(Password.charAt(0)) && NumCount > 0 && SpecialCount > 0) {
		    	  String sql = "update users set Password = '"+Password+"' where Email = '"+myEmail+"'";
		    	  myStmt.executeUpdate(sql);
		    	  System.out.println("Updated Password");
		    	  }
		    	}else {
		    		 System.out.println("The password must be 8 characters or longer with atleast 1 number, 1 special character and the first character must be uppercase");
		    		 return;
		    	  }
		    	  
		      }else {
		    	  System.out.println("Enter a valid number");
		      }
		      }else {
		    	  System.out.println("Your not in the list!");
		      }
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	public void printUsers() {
		try {
		      //Class.forName("com.mysql.jdbc.Driver");
		      Connection myConn = DriverManager.getConnection(Conn_String,UserName,Password);
		      Statement myStmt = myConn.createStatement();
		      String sql = "Select * from users";
		      ResultSet rs = myStmt.executeQuery(sql);
		     
		      while(rs.next()) { 
		    	  String FirstName = rs.getString("FirstName");
		    	  String LastName = rs.getString("LastName");
		    	  String Email = rs.getString("Email");
		    	  String Password = rs.getString("Password");
		    	  String BirthDate = rs.getString("BirthDate");
		    	  String Gender = rs.getString("Gender");
		    	  
		    	  System.out.format("%s, %s, %s, %s, %s, %s\n", FirstName, LastName, Email, Password, BirthDate, Gender);
		      }
		      }
		      catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
