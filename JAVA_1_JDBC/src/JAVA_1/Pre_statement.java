package JAVA_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.*;

public class Pre_statement {

	public static void main(String[] args) {
//		Scanner sc= new Scanner(System.in);
//		System.out.println("Enter your id:");
//		int id= sc.nextInt();
//		System.out.println("ENter your name:");
//		String name=sc.next();
//		System.out.println("Enter your salary:");
//		int salary=sc.nextInt();
		Connection con=null;
//		
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Shrisha","root","root");
//		Statement st=con.createStatement();
		//Insert data
		PreparedStatement ps =con.prepareStatement("insert into emp values (?,?,?)");
//		ps.setInt(1, id);
//		ps.setString(2, name);
//		ps.setInt(3, salary);
//		int rows=ps.executeUpdate();
		
//		DELETE DATA FROM TABLE
//		String Query="Delete from emp where id=101";
//		ps.executeUpdate(Query);
//		System.out.println("DELETE Sucessfully");
//		
		
//		Update data
		String query="Update emp set name='Abhi' where id=103";
		ps.executeUpdate(query);
		System.out.println("Updated successfully");
		
//		if(rows==1) {
//			System.out.println("Data inserted successfully");
//		}
//		else {
//			System.out.println("please enter data");
//		}
//		
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		}
		finally {
			try {
				con.close();
			
			}
			catch(SQLException sql) {
				sql.printStackTrace();
			}
		}
		

	}

}
