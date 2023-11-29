package in.co.rays.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModal2 {
	
	public void add( MarksheetBean2 bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		
		int pk = nextPk();
		ps.setInt(1, pk);
		//ps.setInt(1, bean.getId());
		ps.setInt(2, bean.getRoll_no());
		ps.setString(3, bean.getName());
		ps.setInt(4, bean.getPhy());
		ps.setInt(5, bean.getChe());
		ps.setInt(6, bean.getMaths());
		

		
		int i = ps.executeUpdate();
		
		System.out.println("data added =" + i);
	}
	
	public MarksheetBean2 findByPk(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from marksheet where id = ?");
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		MarksheetBean2 bean = null;
		while(rs.next()) {
			bean = new MarksheetBean2();
			
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRoll_no(rs.getInt(3));
			bean.setChe(rs.getInt(4));
			bean.setPhy(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			
			
		}
		return bean;
		
	}
	
	public List search() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from marksheet");
		
		ResultSet rs = ps.executeQuery();
		
		List list = new ArrayList();
		
		while(rs.next()) {
			MarksheetBean2 bean = new MarksheetBean2();
			//bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRoll_no(rs.getInt(3));
			bean.setChe(rs.getInt(4));
			bean.setPhy(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			
			list.add(bean);
			
		}return list;
		
	}
	
	public Integer nextPk() throws Exception {
		int pk = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
		 pk = 	rs.getInt(1);
		}return pk + 1;
	}

}
