package in.co.rays.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MarksheetModel {
	
	public void add(MarksheetBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getRoll_no());
		ps.setInt(4, bean.getPhy());
		ps.setInt(5, bean.getChe());
		ps.setInt(6, bean.getMaths());
		
		int i = ps.executeUpdate(); 
		
		System.out.println("data inserted = " + i);
		
	}
	public void update(MarksheetBean bean) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("update marksheet set id = ?, name = ?, roll_no = ? where id = ?");
		
		ps.setInt(1,bean.getId() );
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getRoll_no());
		
		int i = ps.executeUpdate();
		
		System.out.println("Data updated = " + i);
		
	}
	
	
	public void delete(int id) throws Exception {
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
			
			PreparedStatement ps =  conn.prepareStatement("delete from marksheet where id = ?");
			
			
	    	ps.setInt(1, id);
	    	
	    	int i = ps.executeUpdate();
	    	
	    	System.out.println("Data deleted =" + i);
			
		
	}
	
	public void update2(MarksheetBean bean) throws Exception {
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
			
			PreparedStatement ps =  conn.prepareStatement("update marksheet set che=? where id=?");
		     ps.setInt(2, bean.getId());
		     ps.setInt(1, bean.getChe());
			
			int i = ps.executeUpdate();
			
			System.out.println("data alter =" + i );
			
	}
}
