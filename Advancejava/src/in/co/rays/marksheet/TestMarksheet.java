package in.co.rays.marksheet;

import java.util.Iterator;
import java.util.List;

public class TestMarksheet {
	public static void main(String[] args) throws Exception {
		testAdd();
		//testDelete();
		//testUpdate();
		//testSearch();
		//testFindByPk();
		
	}

	

	private static void testFindByPk() throws Exception {
		MarksheetModal modal = new MarksheetModal();
		
		MarksheetBean bean = modal.findByPk(5);
		
		if(bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getRoll_no());
			System.out.println(bean.getChe());
			System.out.println(bean.getPhy());
			System.out.println(bean.getMaths());
		}
		else {
			System.out.println(" id does not found");
		}
		
	}



	private static void testSearch() throws Exception {
		
		MarksheetModal modal = new MarksheetModal();
		
		List list = modal.search();
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			
			MarksheetBean bean = (MarksheetBean) it.next();
			
			System.out.print( bean.getId());
			System.out.print("\t" +bean.getName());
			System.out.print("\t" +bean.getRoll_no());
			System.out.print("\t" +bean.getChe());
			System.out.print("\t" +bean.getPhy());
			System.out.println("\t" +bean.getMaths());
			
		}
		
		
		
		
		
		
		
	}



	private static void testAdd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		
		
		
		
		bean.setName("ramuuuuuu");
		bean.setRoll_no(55);
		bean.setPhy(99);
		bean.setChe(66);
		bean.setMaths(99);
		
		
		MarksheetModal modal = new MarksheetModal();
		
		modal.add(bean);
		
	}
			

private static void testDelete() throws Exception {
	MarksheetModal Modal = new MarksheetModal();
	Modal.delete(12);
}
private static void testUpdate() throws Exception {
	 MarksheetBean bean = new MarksheetBean();
	 bean.setId(7);
	 bean.setName("sagar");
	 
	 MarksheetModal modal = new MarksheetModal();
	 modal.update(bean);
	 
	
}
}
