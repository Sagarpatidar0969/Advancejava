package in.co.rays.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestUserr {
	public static void main(String[] args) throws Exception {
		//testAdd();
		testUpdate();
		
	}
	private static void testUpdate()throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserrBean bean = new UserrBean();
		bean.setId(5);
		bean.setFirst_name("amit");
		bean.setDob(sdf.parse("1991-02-30"));
		
		UserrModel model = new UserrModel();
		model.update(bean);
	}
	
	
	private static void testAdd() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserrBean bean = new UserrBean();
		bean.setId(8);
		bean.setFirst_name("ram");
		bean.setLast_name("sharma");
		bean.setLogin_id("ram@ihdsahGmail.com");
		bean.setPassword("787");
		bean.setDob(sdf.parse("1998-10-23"));
		
		UserrModel model = new UserrModel();
		model.add(bean);
	}
	}


