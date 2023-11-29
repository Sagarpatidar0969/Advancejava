package in.co.rays.practice;

public class TestsMarksheet {
	public static void main(String[] args) throws Exception {
		//testAdd();
		
		//testUpdate();
		
		//testDelete();
		
		testUpdate2();
	}

	

	



	private static void testAdd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		
		bean.setId(11);
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
	
	
}
