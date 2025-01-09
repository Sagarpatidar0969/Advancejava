package in.co.rays.projpractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.co.rays.util.JDBCDataSource;

public class CollegeModel {
	public void add(CollegeBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into college2 values(?,?,?,?,?,?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setString(3, bean.getAddress());
		ps.setString(4, bean.getState());
		ps.setString(5, bean.getCity());
		ps.setInt(6, bean.getPhoneNo());
		
		int i =ps.executeUpdate();
		
		System.out.println("data inserted =" +  i);
	}
	
	public void update(CollegeBean bean )throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("update college2 set name = ?,address = ?,state = ?,city = ?,phoneNo = ? where id = ?");
		ps.setString(1, bean.getName());
		ps.setString(2, bean.getAddress());
		ps.setString(3, bean.getState());
		ps.setString(4, bean.getCity());
		ps.setInt(5, bean.getPhoneNo());
		ps.setInt(6, bean.getId());
		
		int i = ps.executeUpdate();
		System.out.println("data updated = " + 1);
		
	}

}
