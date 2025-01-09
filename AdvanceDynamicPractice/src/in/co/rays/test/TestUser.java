package in.co.rays.test;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class TestUser  {
	public static void main(String[] args) throws Exception {
		//testAdd();
		//testUpdate();
		//testDelete();
		//testFindById();
		testSearch();
		//testAuthenticate();
		//testDynamicSearch();
		//testForgetPassword();
		
	}
	
	
private static void testForgetPassword() throws Exception {
	UserBean bean = new UserBean();
	
	
	UserModel model = new UserModel();
	 bean = model.forgetPassword("6789","himanshu@gmail.com");
	 
	System.out.println("data updated");
		
	}

	 

private static void testDynamicSearch() throws Exception {
	
	UserBean bean = new UserBean();
	bean.setAddress("jhalawar");
	bean.setId(15);
	
	UserModel model = new UserModel();
	List list = model.dynamicSerach(bean, 3,1);
	Iterator it = list.iterator();
	while(it.hasNext()) {
		bean = (UserBean) it.next();
		System.out.println(bean.getId());
		System.out.print(" \t " +bean.getFirst_name());
		System.out.print(" \t " +bean.getLast_name());
		System.out.print(" \t " +bean.getLogin_id());
	    System.out.print(" \t " +bean.getPassword());
		System.out.print(" \t " +bean.getDob());
		System.out.println(" \t " +bean.getAddress());
		
	}
}
	


private static void testAuthenticate() throws Exception {
		
	UserModel model = new UserModel();
	UserBean bean = model.authenticate("sumit@gmail.com", "1234");
	
	if(bean != null) {
		System.out.print(bean.getId());
		System.out.print(" \t " +bean.getFirst_name());
		System.out.print(" \t " +bean.getLast_name());
		System.out.print(" \t " +bean.getLogin_id());
	    System.out.print(" \t " +bean.getPassword());
		System.out.print(" \t " +bean.getDob());
		System.out.println(" \t " +bean.getAddress());
		
	}
	
	}


//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>



private static void testSearch() throws Exception {

		UserModel model = new UserModel();
	    List list =	model.search();
	    Iterator it = list.iterator();
	    
	    while(it.hasNext()) {
	    	UserBean bean = (UserBean) it.next();
	    	System.out.print(bean.getId());
	    	System.out.print(" \t " +bean.getFirst_name());
			System.out.print(" \t " +bean.getLast_name());
			System.out.print(" \t " +bean.getLogin_id());
		    System.out.print(" \t " +bean.getPassword());
			System.out.print(" \t " +bean.getDob());
			System.out.println(" \t " +bean.getAddress());
			
	    }
	
	}


//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	
	
	private static void testFindById() throws Exception {
		 
		
		UserModel model = new UserModel();
		UserBean  bean = model.findById(15);
		
		if(bean != null) {
			System.out.println(bean.getFirst_name());
			System.out.println(bean.getLast_name());
			System.out.println(bean.getLogin_id());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getAddress());
			
		}
		
	}


//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	private static void testDelete() throws Exception {
		UserModel model = new UserModel();
		model.delete(10);
		
	}
	
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	

	private static void testUpdate() throws Exception {
		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		bean.setId(15);
		bean.setFirst_name("shivani");
		bean.setDob(sdf.parse("2002-10-12"));
		
		UserModel model = new UserModel();
		model.update(bean);
	}
	
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	
	

	private static void testAdd() throws Exception {
		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		bean.setId(15);
		bean.setFirst_name("sumit");
		bean.setLast_name("patidar");
		bean.setLogin_id("sumit@gmail.com");
		bean.setDob(sdf.parse("2023-10-12"));
		bean.setPassword("1234");
		bean.setAddress("jhalawar");
		
		UserModel model = new UserModel();
		model.add(bean);
		
	}

}
