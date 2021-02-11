package TermProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	public class studentRegistration {
	
      //Change the database information before running the program
	  static String url = "jdbc:mysql://localhost:3306/testDB?autoReconnect=true&useSSL=false";
      static String user = "root";
      static String password = "1";
      
	public static void main(String args[]) throws SQLException{

	}
	
	//to insert a new Student data
	 public static void insertStudent(String id,String firstName,String lastName,String email,String phoneNumber) throws SQLException{
 		
 
 		  String query = "INSERT INTO users(student_id, first_name, last_name, e_mail, phone_number)"+
 		  "VALUES('"+id+"','"+firstName+"','"+lastName+"','"+email+"','"+phoneNumber+"');";

    	  Connection con = DriverManager.getConnection(url, user, password);
 		  PreparedStatement preparedStmt = con.prepareStatement(query);
 	      preparedStmt.execute();
 	      
 	      System.out.println("You have inserted this student to the Student Book:");
 	      System.out.println("ID: "+id+"\nFirst name: "+firstName+"\nLast name: "+lastName+"\nEmail: "+email+"\nPhone Number: "+phoneNumber);


 	} 
	 //to get Student information
	 public static void getStudent(String student_id) throws SQLException{
	    	
		 	Connection con = DriverManager.getConnection(url, user, password);
	        Statement stmt = con.createStatement() ;

	        String query = "SELECT * FROM USERS WHERE student_id ='"+student_id+"';";
	        ResultSet rs = stmt.executeQuery(query);
	        while(rs.next()){
	            String first = rs.getString("first_name");
	            String last = rs.getString("last_name");
	            String email = rs.getString("e_mail");
	            String phone = rs.getString("phone_number");
	            
	            System.out.println("ID: "+student_id+" First Name: "+first+" Last Name: "+last+" E-Mail: "+email+" Phone Number: "+phone);

	        }
	        }
	        
	 //to fill the text area with the student information
	  public static String getStudentToTextArea(String student_id) throws SQLException{
			Connection con = DriverManager.getConnection(url, user, password);
	        Statement stmt = con.createStatement() ;
	        	        
	        String query = "SELECT * FROM USERS WHERE student_id ='"+student_id+"';";
	        ResultSet rs = stmt.executeQuery(query);
	        
	        String st = null;
	        
	        while(rs.next()){
	            String first = rs.getString("first_name");
	            String last = rs.getString("last_name");
	            String email = rs.getString("e_mail");
	            String phone = rs.getString("phone_number");
	            
	            st = "ID: "+student_id+"\nFirst Name: "+first+"\nLast Name: "+last+"\nE-Mail: "+email+"\nPhone Number: "+phone;
	  }
	        System.out.println(st);
	        return st;
	       
	      
	 }
	  //to fill the text area with the student grades
	  public static String getResultToTextArea(String student_id) throws SQLException{
			Connection con = DriverManager.getConnection(url, user, password);
	        Statement stmt = con.createStatement() ;
	        	        
	        String query = "SELECT student_id, midtermResult, finalResult, labResult FROM users WHERE student_id ='"+student_id+"';";
	        ResultSet rs = stmt.executeQuery(query);
	        
	        String str = null;
	        
	    
	        while(rs.next()){
	            String id = rs.getString("student_id");
	            String midtermR = rs.getString("midtermResult");
	            String finalR = rs.getString("finalResult");
	            String labR = rs.getString("labResult");
	            
	            
	            
	            double labPerc = Integer.valueOf(labR)*0.2;
	            double finalPerc = Integer.valueOf(finalR)*0.5;
	            double midtermPerc = Integer.valueOf(midtermR)*0.3;
	            
	            double sum = labPerc + finalPerc + midtermPerc;
	            String grade = null;
	            if(sum>=90)
	            	grade="AA";
	            else if(sum>=80 && sum <90)
	            	grade="BA";
	            else if(sum>=70 && sum <80)
	            	grade="BB";
	            else if(sum>=60 && sum <70)
	            	grade="CB";
	            else if(sum>=50 && sum <60)
	            	grade="CC";
	            else if(sum>=40 && sum <50)
	            	grade="DC";
	            else if(sum>=30 && sum <20)
	            	grade="DD";
	            else
	            	grade ="FF";
	            
	            
	            str = "Midterm Exam: "+midtermR+"\nLab: "+labR+"\nFinal Exam: "+finalR+"\n\nLetter Grade: "+grade;
  
	  }
	        System.out.println(str);
	        return str;
	   
	 }
	  
	 //to insert grade information to an existing student
	 public static void insertGrades(String id,String midtermGrade,String labGrade,String finalGrade) throws SQLException{
	 		
		
	      String query = "UPDATE users SET midtermResult = "+midtermGrade+", labResult = "+labGrade+", finalResult = "+finalGrade+" "
	      		+ "where student_id = "+id;

   	  Connection con = DriverManager.getConnection(url, user, password);
		  PreparedStatement preparedStmt = con.prepareStatement(query);
	      preparedStmt.execute();
	      
	      System.out.println("You have inserted grades:");
	      System.out.println("ID: "+id+"\nMidterm Grade: "+midtermGrade+"\nLab Works: "+labGrade+"\nFinal Grade: "+finalGrade);


	} 
	
	}
	       

