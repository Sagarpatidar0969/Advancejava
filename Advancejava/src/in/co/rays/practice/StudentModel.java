package in.co.rays.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class StudentModel {

	public void add(StudentBean bean) throws Exception{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
	PreparedStatement ps = conn.prepareStatement("insert into newstudent values(?,?,?)");
	ps.setInt(1, bean.getId());
	ps.setString(2,bean.getName());
	ps.setInt(3, bean.getRoll_no());
	
	int i  = ps.executeUpdate();
	
	System.out.println("data inserted =" + i);
}
	
}



