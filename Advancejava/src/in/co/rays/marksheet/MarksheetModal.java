package in.co.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModal  {
	
	public void add(MarksheetBean bean) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		int pk = nextPk();
		ps.setInt(1,pk);
		//ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName() );
		ps.setInt(3, bean.getRoll_no());
		ps.setInt(4, bean.getPhy());
		ps.setInt(5, bean.getChe());
		ps.setInt(6, bean.getMaths());
		
		
		
		int i = ps.executeUpdate();
		
		System.out.println("data inserted =" + i);
		
		
		
			}
	public void delete(int id) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id = ?");
		
		ps.setInt(1, id);
		
		int i = ps.executeUpdate();
		System.out.println("data deleted = " + i);
	
	}
	public void update(MarksheetBean bean) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps = conn.prepareStatement("update marksheet set id = ?, name = ? where id = ? ");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		
		int i = ps.executeUpdate();
		System.out.println("data updated =" + i);
		
	}
	
	public List search(MarksheetBean bean,int pageNo,int pageSize) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		StringBuffer sql = new StringBuffer("select * from marksheet where 1 = 1");
		
		//PreparedStatement ps = conn.prepareStatement(sql.toString());
		
		
		if(bean != null) {
			if(bean.getName() != null && bean.getName().length() >0) {
				sql.append(" and name like '"+ bean.getName() +"%' ");
						
			}
			if(bean.getRoll_no() > 0) {
				sql.append(" and roll_no = "+ bean.getRoll_no()+" ");
			}
			
		}
		
		if(pageSize>0) {
			
			pageNo = (pageNo-1)*pageSize;
			
			sql.append(" limit " + pageNo + "," +pageSize );
			
			
		}
		System.out.println(sql);
		
		
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		
		
		
		
		
		ResultSet rs = ps.executeQuery();
		
		List list = new ArrayList();
		
		while(rs.next()) {
			
			 bean = new MarksheetBean();
			
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRoll_no(rs.getInt(3));
			bean.setChe(rs.getInt(4));
			bean.setPhy(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			
			list.add(bean);
	
			
		}
		
		return list;
		
	}
	
	public MarksheetBean findByPk(int id) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from marksheet where id =   ?");
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		MarksheetBean bean = null;
		
		while(rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRoll_no(rs.getInt(3));
			bean.setChe(rs.getInt(4));
			bean.setPhy(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		}
		return bean;
		
		
	}
	
	public Integer nextPk() throws Exception {
		int pk = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			pk = rs.getInt(1);
			
		}
		return pk + 1;
	}
	
	
	}
