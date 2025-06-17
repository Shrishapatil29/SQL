package JAVA_1;
import java.sql.*;

public class CallStatement {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			
			CallableStatement cs=con.prepareCall("{call getEmployeeName(?,?}");
			cs.setInt(1,10);
			cs.registerOutParameter(2,Types.VARCHAR);
			cs.execute();
			
			String name=cs.getString(2);
			System.out.println("Employee name:"+name);
			con.close();
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
