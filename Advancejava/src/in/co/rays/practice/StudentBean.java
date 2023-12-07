package in.co.rays.practice;

public class StudentBean {
	int id;
	String name;
	int roll_no;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	@Override
	public String toString() {
		return "StudentBean [id=" + id + ", name=" + name + ", roll_no=" + roll_no + "]";
	}
	

}
