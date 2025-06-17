package JAVA_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {

	public static void main(String[] args) {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Shrisha","root","root");
			Statement st = con.createStatement();
			int rows = st.executeUpdate("Create table Excelr(eid int, ename varchar(20),email varchar(20))");
			System.out.println(rows);
			System.out.println("Table created successfuuly");
			
			int rows1 = st.executeUpdate("Create table Movie(name varchar(20),Time time, price int)");
			System.out.println(rows1);
			System.out.println("MOVIE Table created successfuuly");
			
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
