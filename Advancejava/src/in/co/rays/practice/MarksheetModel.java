package in.co.rays.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModel {
	
	public void add(MarksheetBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		int pk = nextPk();
		ps.setInt(1, pk);
		//ps.setInt(1, bean.getId());
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
	
	public List search() throws Exception {
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
			
			PreparedStatement ps =  conn.prepareStatement("select * from marksheet");
			
			ResultSet rs = ps.executeQuery();
			
			List list = new ArrayList();
			
			while(rs.next()) {
				MarksheetBean bean = new MarksheetBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setRoll_no(rs.getInt(3));
				bean.setChe(rs.getInt(4));
				bean.setMaths(rs.getInt(5));
				bean.setPhy(rs.getInt(6));
				
				list.add(bean);
				
				
			}return list;
			
			
			
			
	}
	
	public MarksheetBean findByPk(String name) throws Exception {
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
			
			PreparedStatement ps =  conn.prepareStatement("select * from marksheet where name = ?");
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
		MarksheetBean bean = null;
		
		while(rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRoll_no(rs.getInt(3));
			bean.setChe(rs.getInt(4));
			bean.setMaths(rs.getInt(5));
			bean.setPhy(rs.getInt(6));
			
			
			
		}return bean;	
	}
	
	
	
	
	public Integer nextPk() throws Exception {
		int pk = 0;
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
			
			PreparedStatement ps =  conn.prepareStatement("select max(id) from marksheet");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				pk = rs.getInt(1);
				
			}return pk+1;
		
		
	}
	
	
}
