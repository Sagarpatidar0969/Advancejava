package in.co.rays.transactionheandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RollBack {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
				
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		    conn.setAutoCommit(false);
		    Statement stmt = conn.createStatement();
		    int i = stmt.executeUpdate("insert into emp values(7,'abc',1000)");
		        i = stmt.executeUpdate("insert into emp values(7,'abc',1000)");
		        i = stmt.executeUpdate("insert into emp values(9,'abc',1000)");
		    
		        conn.commit();
		        System.out.println("data inserted =" + 1);
		} catch (Exception e) {
			conn.rollback();
			
			System.out.println("done");
		}
	}

}
