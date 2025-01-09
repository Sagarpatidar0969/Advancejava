package in.co.rays.practice;

import java.util.Iterator;
import java.util.List;

public class TestMarksheet2 {
		public static void main(String[] args) throws Exception {
			//testAdd();
			//testFindByPk();
			testSearch();
		}

		
		

		




		private static void testAdd() throws Exception {
			MarksheetBean2 bean = new MarksheetBean2();
			//bean.setId(8);
			
			bean.setName("chetan");
			bean.setRoll_no(109);
			bean.setPhy(88);
			bean.setChe(99);
			bean.setMaths(55);
			
			
			MarksheetModal2 model = new MarksheetModal2();
			
			model.add(bean);
			
			
		}
		private static void testFindByPk() throws Exception {
			
			MarksheetModal2 modal = new MarksheetModal2();
			MarksheetBean2 bean = modal.findByPk(4);
			
			if(bean != null) {
				System.out.println(bean.getId());
				System.out.println(bean.getName());
				System.out.println(bean.getRoll_no());
				System.out.println(bean.getChe());
				System.out.println(bean.getPhy());
				System.out.println(bean.getMaths());
				
			}
			else {
				System.out.println("id does not found");
			}
			
	
		}
		private static void testSearch() throws Exception {
			
			MarksheetModal2 model = new MarksheetModal2();
			 List list  =model.search();
			 Iterator it = list.iterator();
			 
			 while(it.hasNext()) {
				 MarksheetBean2 bean = (MarksheetBean2) it.next();
				    System.out.println(bean.getId());
					System.out.println(bean.getName());
					System.out.println(bean.getRoll_no());
					System.out.println(bean.getChe());
					System.out.println(bean.getPhy());
					System.out.println(bean.getMaths());
					
			 }
		}
}
