package in.co.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
 
public class Practice {
//			public static void main(String[] args) throws Exception {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
//			Statement stmt = conn.createStatement();
//		//	int i = stmt.executeUpdate("insert into marksheet values(8,'dilip',122,55,66,77)");
//			//System.out.println("Data inserted = " + i);
//			
//			int i = stmt.executeUpdate("delete from marksheet where id = 8 ");
//			System.out.println("Data deleted = " + i);
//			
//}
	
//	public static void main(String[] args) throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
//		Statement stmt = conn.createStatement();
//	    int i = stmt.executeUpdate("update marksheet set name =  'sonali' where id = 6");
//	    System.out.println("data updated =" + i);
//		
//	}
//	public static void main(String[] args) throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
//		Statement stmt = conn.createStatement();
//		int i = stmt.executeUpdate("create table result1 (id int , name varchar(20))");
//		int j = stmt.executeUpdate("insert into result1 values(1,'sagar')");
//		System.out.println("column added = " + i);
	//}
	
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04","root","root");
		Statement stmt = conn.createStatement();
		int i =	stmt.executeUpdate("update marksheet set name = 'sr' where id =1");
		System.out.println("data updated =" + i);
	}
}
