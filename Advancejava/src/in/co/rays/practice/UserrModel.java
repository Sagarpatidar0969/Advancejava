package in.co.rays.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.rays.util.JDBCDataSource;

public class UserrModel {
	public void add(UserrBean bean) throws Exception {
		Connection conn  = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getFirst_name());
		ps.setString(3,bean.getLast_name());
		ps.setString(4, bean.getLogin_id());
		ps.setString(5, bean.getPassword());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(7, bean.getAddress());
		
		int i = ps.executeUpdate();
		System.out.println(" data inserted= " + i);
		
	}
	
	public void update(UserrBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("update user set first_name= ?, dob = ? where id = ?");
		
		ps.setString(1, bean.getFirst_name());
		
		ps.setDate(2, new java.sql.Date(bean.getDob().getTime()));
		
		ps.setInt(3, bean.getId());
		
		int i = ps.executeUpdate();
		System.out.println(" data inserted= " + i);
		
		
	}
	public void search(UserrBean bean ) throws Exception{
		Connection conn = JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer("select * from user where 1=1");
		
		if(bean !=null) {
			if(bean.getDob() != null && bean.getDob().getTime()>0) {
				sql.append(" and dob like '"+new java.sql.Date(bean.getDob().getTime())+"%'");
				
			}
		}
		System.out.println(sql);
		PreparedStatement ps = conn.prepareStatement(toString());
		ResultSet rs = ps.executeQuery();
		
		
	}
}
