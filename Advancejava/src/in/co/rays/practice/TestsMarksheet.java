package in.co.rays.practice;

import java.util.Iterator;
import java.util.List;

public class TestsMarksheet {
	public static void main(String[] args) throws Exception {
		testAdd();
		
		//testUpdate();
		
		//testDelete();
		
		//testUpdate2();
		
		//testsearch();
		
		// testFindByPk();
		
		
	}


	private static void testAdd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		
		//bean.setId(11);
		bean.setName("sp");
		bean.setRoll_no(107);
		bean.setPhy(88);
		bean.setChe(99);
		bean.setMaths(77);
		
		MarksheetModel model = new MarksheetModel();
		
		model.add(bean);
		
	}
	
	
	private static void testUpdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		
		bean.setId(7);
		bean.setName("vijay");
		bean.setRoll_no(107);
		
		MarksheetModel model = new MarksheetModel();
		model.update(bean);
		
				
		
	}
	
	
	
	
	private static void testDelete() throws Exception {
		
		MarksheetModel model = new MarksheetModel();
		
		model.delete(9);
			
	}
	
	
	
	
	private static void testUpdate2() throws Exception {
		
		MarksheetBean bean = new MarksheetBean();
		bean.setId(6);
		bean.setChe(12);
		
		
		MarksheetModel model = new MarksheetModel();
		model.update2(bean);
		
	}
	
	
	
	
	
	
	private static void testsearch() throws Exception {
		MarksheetModel model = new MarksheetModel();
		List list = model.search();
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			MarksheetBean bean = (MarksheetBean) it.next();
			
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getRoll_no());
			System.out.print("\t" + bean.getChe());
			System.out.print("\t" + bean.getPhy());
			System.out.println("\t" + bean.getMaths());
			
		}
		
	}
	
	
	
	private static void testFindByPk() throws Exception {
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = model.findByPk("ram");
		
		if(bean != null) {
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getRoll_no());
			System.out.print("\t" + bean.getChe());
			System.out.print("\t" + bean.getPhy());
			System.out.println("\t" + bean.getMaths());
			
		}
		else{
			System.out.println("name does not matched");
		}
		
	}

	
	
}
