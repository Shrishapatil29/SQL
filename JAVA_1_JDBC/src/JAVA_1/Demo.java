package JAVA_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
//		step 1: Translator  com.mysql.cj.jdbc.driver
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
//		Step 2: Connection between java and 

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Shrisha","root","root");
		
		
//		step 3: Statement
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * from Emp");
		rs.next();
		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getInt(3));
			 
			 
			 
		 
		
		
//		Connection close
		con.close();
	}
//
}
//
//
//
//
//
//
//
//
//
//
////import java.sql.Connection;
////import java.sql.DriverManager;
////import java.sql.ResultSet;
////import java.sql.SQLException;
////import java.sql.Statement;
////
////class Demo{
////	public static void main(String[]args) throws ClassNotFoundException, SQLException {
////		
////		Class.forName("com.mysql.cj.jdbc.Driver");
////		
////		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Shrisha","root","root");
////		
////		Statement st =con.createStatement();
////		ResultSet rs = st.executeQuery("Select * from Emp");
////		rs.next();
////		System.out.print(rs.getInt(1));
////		System.out.print(rs.getString(2));
////		System.out.print(rs.getInt(3));
////		con.close();
////		
////		
////	}
////}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
