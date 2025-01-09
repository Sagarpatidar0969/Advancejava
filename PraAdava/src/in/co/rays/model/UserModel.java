package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.util.JDBCDataSource;

public class UserModel {
	
	
	public void add(UserBean bean)throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
		ps.setInt(1,nextPk(0));
		ps.setString(2, bean.getFirst_name());
		ps.setString(3, bean.getLast_name());
		ps.setString(4, bean.getLogin_id());
		ps.setString(5, bean.getPassword());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(7, bean.getAddress());
		
		int i = ps.executeUpdate();
		System.out.println("data inserted =" + i);
		
	}
	
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	
	public void update(UserBean bean)throws Exception {
        Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("update user set first_name  = ?,last_name = ?,login_id = ?,password = ?,dob = ?,address = ? where id = ?");
		ps.setInt(7,bean.getId());
		ps.setString(1, bean.getFirst_name());
		ps.setString(2, bean.getLast_name());
		ps.setString(3, bean.getLogin_id());
		ps.setString(4, bean.getPassword());
		ps.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(6, bean.getAddress());
		
		int i = ps.executeUpdate();
		System.out.println("data updated =" + i);
		
	}
	
	
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	public void delete(int id)throws Exception {
        Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("delete from user where id = ?");
		ps.setInt(1,id);
		
		int i = ps.executeUpdate();
		System.out.println("data deleted =" + i);
      }
	
	
	
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	public UserBean findById(int id) throws Exception {
		 Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from user where id = ?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			UserBean bean = null;
			
			while(rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt(1));
				bean.setFirst_name(rs.getString(2));
				bean.setLast_name(rs.getString(3));
				bean.setLogin_id(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setAddress(rs.getString(7));
				
			}return bean;
	}
	
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	public List search(UserBean bean,int pageNo,int pageSize )throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer("select * from user where 1=1");
				
				if(bean != null) {
					if(bean.getFirst_name() != null && bean.getFirst_name().length()>0) {
						sql.append(" and first_name like '"+bean.getFirst_name()+"%'");
					}
					
					if(bean.getAddress() != null && bean.getAddress().length()>0) {
						sql.append(" and address like '"+ bean.getAddress()+"%'");
					}
					
					if(bean.getId() != 0) {
						sql.append(" and id = "+ bean.getId()+" ");
					}
				}
				
				if(pageSize > 0) {
					pageNo = (pageNo - 1) * pageSize;
					sql.append(" limit " + pageNo + " , " + pageSize );
					
				}
				System.out.println(sql);
				
				PreparedStatement ps = conn.prepareStatement(sql.toString());
				ResultSet rs = ps.executeQuery();
				ArrayList list = new ArrayList();
				
				while(rs.next()) {
					      bean = new UserBean();
					    bean.setId(rs.getInt(1));
					    bean.setFirst_name(rs.getString(2));
						bean.setLast_name(rs.getString(3));
						bean.setLogin_id(rs.getString(4));
						bean.setPassword(rs.getString(5));
						bean.setDob(rs.getDate(6));
						bean.setAddress(rs.getString(7));
						list.add(bean);
						
				}return list;


}

	
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	public Integer nextPk(int id) throws Exception {
		    int pk = 0;
		    Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select max(id) from user");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				pk = rs.getInt(1);
			}return pk + 1;
			
	}
	
	
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	
	
	
	public UserBean authenticate(String login_id,String password) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from user where login_id = ? and password = ? ");
		ps.setString(1,login_id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		UserBean bean = null;
		
		while(rs.next()) {
			
		    	bean = new UserBean();
			    bean.setId(rs.getInt(1));
			    bean.setFirst_name(rs.getString(2));
				bean.setLast_name(rs.getString(3));
				bean.setLogin_id(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setAddress(rs.getString(7));
			
			
		}return bean;
	}
	
	
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	
	
	public List dynamicSerach(UserBean bean,int pageSize,int pageNo) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer("select * from user where 1=1");
		
		if(bean != null) {
			if(bean.getAddress() != null && bean.getAddress().length()>0) {
				sql.append(" and address like '"+ bean.getAddress()+"%'");
			}
			
			if(bean.getId() != 0) {
				sql.append(" and id = "+ bean.getId()+" ");
			}
		}
		
		if(pageSize != 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + " , " + pageSize );
			
		}
		System.out.println(sql);
		
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();
		while(rs.next()) {
			 bean = new UserBean();
			    bean.setId(rs.getInt(1));
			    bean.setFirst_name(rs.getString(2));
				bean.setLast_name(rs.getString(3));
				bean.setLogin_id(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setAddress(rs.getString(7));
				list.add(bean);
			
		}return list;
	}
	
	
	
	public UserBean forgetPassword(String password,String loginId) throws Exception {
		
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("update user set password = ? where login_id = ?");
		ps.setString(1, password);
		ps.setString(2, loginId);
		UserBean bean = null;
		int i = ps.executeUpdate();
		
	return bean;
	}
}



