package in.co.rays.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.co.rays.marksheet.MarksheetBean;
import in.co.rays.user.UserBean;
import in.co.rays.util.JDBCDataSource;

public class TestModel {
	
public TestBean findByPk(int id) throws Exception{
	
	    Connection conn = JDBCDataSource.getConnection();
	 	
	    PreparedStatement ps = conn.prepareStatement("select * from marksheet where id = ?");
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		TestBean bean = null;
		
		while(rs.next()) {
			bean = new TestBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRoll_no(rs.getInt(3));
			bean.setChe(rs.getInt(4));
			bean.setPhy(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		}
		return bean;
		
}
		
}
	
	
	

