package in.co.rays.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import in.co.rays.user.UserModel;

public class TestUserr {
	public static void main(String[] args) throws Exception {
		//testAdd();
		//testUpdate();
		//testSearch();
		testDynamicSearch();
	}
	private static void testDynamicSearch() throws Exception {
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserrBean bean = new UserrBean();
		bean.setDob(sdf.parse("2003-10-12"));
		
		UserrModel model = new UserrModel();
		List list = model.DynamicSearch(bean, 1, 1);
		Iterator it = list.iterator();
		while(it.hasNext()) {
			bean = (UserrBean) it.next();
			System.out.println(bean.getFirst_name());
			System.out.println(bean);
			
		}
 		
		
	}
	private static void testSearch() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserrBean bean = new UserrBean();
		bean.setDob(sdf.parse("1998-10-23"));
		
		UserrModel model = new UserrModel();
		List list = model.search(bean);
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			bean = (UserrBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirst_name());
			System.out.println(bean.getLast_name());
		}
		
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
		//bean.setId(8);
		bean.setFirst_name("ram");
		bean.setLast_name("sharma");
		bean.setLogin_id("ram@ihdsahGmail.com");
		bean.setPassword("787");
		bean.setDob(sdf.parse("1998-10-23"));
		bean.setAddress("jhalawar");
		
		UserrModel model = new UserrModel();
		model.add(bean);
	}
	 
	
	
	}


