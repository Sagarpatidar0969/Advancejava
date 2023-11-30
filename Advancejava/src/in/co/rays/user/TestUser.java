package in.co.rays.user;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.marksheet.MarksheetModal;

public class TestUser {
	public static void main(String[] args) throws Exception {
		testadd();
		//testUpdate();
		//testSearch();
		//testAuthenticate();
		
	}

	private static void testAuthenticate()throws Exception {
	
		UserModel model  = new UserModel();
	    UserBean bean = model.authenticate("lavish@gmail.com","1234");
		
		if(bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getFirst_name());
			System.out.println(bean.getLast_name());
			System.out.println(bean.getLogin_id());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getAddress());

		}
	}

	private static void testSearch() throws Exception {
		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		bean.setDob(sdf.parse("2003-10-12"));
		
		UserModel model =new UserModel();
	    List list = model.search(bean);
	    
	    Iterator it = list.iterator();
	    
	    while(it.hasNext()) {
	    	bean = (UserBean) it.next();
	    	 
				System.out.println(bean.getId());
				System.out.println(bean.getFirst_name());
				System.out.println(bean.getLast_name());
				System.out.println(bean.getLogin_id());
				System.out.println(bean.getPassword());
				System.out.println(bean.getDob());
				System.out.println(bean.getAddress());
				
	    }
	}

	private static void testUpdate() throws Exception {
		UserBean bean = new UserBean();
		bean.setId(2);
		bean.setFirst_name("dilip");
		bean.setLogin_id("dilip@gmail.com");
		
		UserModel model = new UserModel();
		model.update(bean);
	}

	private static void testadd() throws Exception {
		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		        //bean.setId(3);
				bean.setFirst_name("rahul");
				bean.setLast_name("kirar");
				bean.setLogin_id("rahul@gmail.com");
				bean.setPassword("1234");
				bean.setDob((sdf.parse("2000-22-12")));
				bean.setAddress("indore");
				
				
				UserModel model = new UserModel();
				model.add(bean);
	}
		
}
