package in.co.rays.testbeanmodal;

import java.util.Iterator;
import java.util.List;

public class TestMark {
	public static void main(String[] args) throws Exception {
		//testAdd();
		//testUpdate();
		//testDelete();
		testSearch();
	}

	

	private static void testAdd() throws Exception {
		MarkBean bean = new MarkBean();
		bean.setId(20);
		bean.setName("khushi");
		bean.setRoll_no(108);
		bean.setChe(99);
		bean.setPhy(34);
		bean.setMaths(88);
		
		MarkModel model = new MarkModel();
		model.add(bean);
		
	}
	private static void testUpdate() throws Exception {
		MarkBean bean = new MarkBean();
		bean.setId(10);
		bean.setName("khushi");
		
		
		MarkModel model = new MarkModel();
		model.update(bean);
		
	}
	private static void testDelete() throws Exception {
		MarkModel model = new MarkModel();
		model.delete(16);
	}

	private static void testSearch() throws Exception {
		MarkBean bean = new MarkBean();
		bean.setName("dilip");
		bean.setRoll_no(104);
		
		
		MarkModel model = new MarkModel();
		List list = model.search(bean,1,5);
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			bean = (MarkBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getRoll_no());
			System.out.print("\t" + bean.getChe());
			System.out.print("\t" + bean.getPhy());
			System.out.println("\t" + bean.getMaths());
			
		}
   		
	}
}
