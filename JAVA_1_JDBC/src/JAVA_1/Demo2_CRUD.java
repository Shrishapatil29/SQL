package JAVA_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo2_CRUD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your id:");
		int id=sc.nextInt();
		System.out.println("Enter your name:");
		String name = sc.next();
		System.out.println("Enter your salary:");
		int salary = sc.nextInt();
		Connection con = null;

		try {
			// Load MySQL JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Connect to database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Shrisha", "root", "root");
			// Create a statement
			Statement st = con.createStatement();
			
//			insert by data by using user input
			int rows=st.executeUpdate("insert into emp values("+id+",'"+name+"','"+salary+"')");

//			Update data from table
			String query="UPDATE emp Set name='Shri' where id=101";
			st.executeUpdate(query);
			System.out.println("Update successfully");
//			
////			DELETE DATA FROM TABLE
//			String Query="Delete from emp where id=101";
//			st.executeUpdate(Query);
//			System.out.println("DELETE Sucessfully");
			// Insert a row into emp table manually
//			int rows = st.executeUpdate("INSERT INTO emp VALUES (101, 'Shrisha', 30000)");
			
			
			

			if (rows == 1) {
				System.out.println("Data inserted successfully");
			} else {
				System.out.println("Data not inserted");
			}
		} catch (ClassNotFoundException cnf) {
			System.out.println("MySQL JDBC Driver not found.");
			cnf.printStackTrace();
		} catch (SQLException sql) {
			System.out.println("SQL Error:");
			sql.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException sql) {
				sql.printStackTrace();
			}
		}
	}
}
