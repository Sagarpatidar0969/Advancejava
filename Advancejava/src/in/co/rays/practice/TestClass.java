package in.co.rays.practice;

public class TestClass {
	public static void main(String[] args) throws Exception {
		
		for (int i =0 ; i < 50; i++) {
			System.out.println("Connection =" + i);
			testFindByPk();
		}
		
	}


	private static void testFindByPk() throws Exception {
		TestModel model = new TestModel();
		TestBean bean = model.findByPk(5);
		
		if(bean != null) {
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getRoll_no());
			System.out.print("\t" + bean.getChe());
			System.out.print("\t" + bean.getPhy());
			System.out.println("\t" + bean.getMaths());
			
		}
		else{
			System.out.println("id does not matched");
		}
		
	}
	}

