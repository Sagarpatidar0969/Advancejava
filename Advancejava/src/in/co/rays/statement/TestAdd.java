package in.co.rays.statement;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement; 

public class TestAdd {
			public static void main(String[] args) throws Exception {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");

				Statement stmt = conn.createStatement();

				int i = stmt.executeUpdate("insert into marksheet values(7 , 'lavish', 110, 11, 12, 13)");

				System.out.println("Data Inserted = " + i);
			}
}
