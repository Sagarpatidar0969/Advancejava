package in.co.rays.statement;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class TestQuery {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");

		Statement stmt = conn.createStatement();
		
//		ResultSet rs=stmt.executeQuery("select*from marksheet");
		ResultSet rs=stmt.executeQuery("select*from marksheet");
		
		while(rs.next()) {
			System.out.print("\t" + rs.getInt(1));
			
			System.out.print("\t" + rs.getString(2));
			
			System.out.print("\t" + rs.getInt(3));
			
			System.out.print("\t" + rs.getInt(4));
			
			System.out.print("\t" + rs.getInt(5));
			
			System.out.println("\t" + rs.getInt(6));
			
			
		}
		

	}
	}


