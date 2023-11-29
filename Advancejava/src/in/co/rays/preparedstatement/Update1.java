package in.co.rays.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update1 {
	public static void main(String[] args) throws  Exception{
		 
		Class.forName("com.mysql.cj.jdbc.Driver");
			
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("update marksheet set name = 'sagar' where id  =1");
		
		int i = ps.executeUpdate();
		
		System.out.println("Data updated = " + i);
			
	}

}
