package in.co.rays.testbeanmodal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.marksheet.MarksheetBean;

public class MarkModel {
	
	public void add(MarkBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		int pk = nextPk();
		ps.setInt(1,pk);
		ps.setString(2, bean.getName());
		ps.setInt(3,bean.getRoll_no());
		ps.setInt(4, bean.getChe());
		ps.setInt(5,bean.getPhy());
		ps.setInt(6,bean.getMaths());
		
		int i = ps.executeUpdate();
		System.out.println("Data inserted =" + i);
	}
	public Integer nextPk() throws Exception {
		int pk = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			pk = rs.getInt(1);
		}return pk+1;
		
	}
	public void update(MarkBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps = conn.prepareStatement("update marksheet set id = ? where name = ?)");
		ps.setString(2,bean.getName());
		ps.setInt(1,bean.getId());
		int i = ps.executeUpdate();
		System.out.println("Data inserted =" + i);
		
	}
	public void delete(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id = ?");
		ps.setInt(1,id);
		int i = ps.executeUpdate();
		System.out.println("data deleted = " + i);	
	}
	public List search(MarkBean bean,int pageNo,int pageSize) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		StringBuffer sql = new StringBuffer("select * from marksheet where 1 = 1");
		
		if(bean != null) {
			if(bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '"+bean.getName()+"%'");
			}
			if(bean.getRoll_no() > 0) {
				sql.append(" and roll_no = "+bean.getRoll_no()+" ");
			}
		}
		
		if(pageSize>0) {
			pageNo = (pageNo-1) * pageSize;
			sql.append(" limit " + pageNo + ","+pageSize);
			
		}
		
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		
		System.out.println(sql);
		List list = new ArrayList();
		
		while(rs.next()) {
			bean = new MarkBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRoll_no(rs.getInt(3));
			bean.setChe(rs.getInt(4));
			bean.setPhy(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			list.add(bean);
			
		}return list;
	

	}

}
