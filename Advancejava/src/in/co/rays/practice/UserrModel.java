package in.co.rays.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.util.JDBCDataSource;

public class UserrModel {
	public void add(UserrBean bean) throws Exception {
		
		Connection conn  = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
		int pk = nextPk();
		ps.setInt(1, pk);
	      
		//ps.setInt(1, nextPk(0));
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
	public List search(UserrBean bean ) throws Exception{
		Connection conn = JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer("select * from user where 1=1");
		
		if(bean !=null) {
			if(bean.getDob() != null && bean.getDob().getTime()>0) {
				sql.append(" and dob like '"+new java.sql.Date(bean.getDob().getTime())+"%'");
				
			}
		}
		System.out.println(sql);
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();
		
		while(rs.next()) {
			bean = new UserrBean();
			bean.setId(rs.getInt(1));
			bean.setFirst_name(rs.getString(2));
			bean.setLast_name(rs.getString(3));
			list.add(bean);
			
		}return list;
		
	}
	
	public Integer nextPk() throws Exception {
		int pk = 0;
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select max(id) from user");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			pk = rs.getInt(1);
		}return pk+1;
		
		
		
	}
	
	
	public List DynamicSearch(UserrBean bean,int pageNo,int pageSize) throws Exception{
		Connection conn = JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer("select * from user where 1=1");
		if(bean != null) {
			if(bean.getDob() != null && bean.getDob().getTime()>0) {
				sql.append(" and dob like '"+ new java.sql.Date(bean.getDob().getTime())+"%'");
			}
			if(bean.getId() != 0) {
				
			}
		}
			if(pageSize>0) {
				pageNo = (pageNo-1) * pageSize;
			sql.append(" limit " + pageNo + " , " + pageSize);
				
		}
			
			
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			List list = new ArrayList();
			
			while(rs.next()) {
				bean = new UserrBean();
				bean.setFirst_name(rs.getString(2));
				bean.setDob(rs.getDate(6));
				list.add(bean);
			}
		return list;
		
		
	}
	
	
	
	
	
}
