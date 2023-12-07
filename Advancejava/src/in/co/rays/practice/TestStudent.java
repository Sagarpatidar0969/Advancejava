package in.co.rays.practice;

public class TestStudent {
	public static void main(String[] args) throws Exception {
		testAdd();
		
	}

	private static void testAdd() throws Exception {
		StudentBean bean = new StudentBean();
		bean.setId(2);
		bean.setName("ram");
		bean.setRoll_no(102);
		
		StudentModel model = new StudentModel();
		model.add(bean);
	}

}
