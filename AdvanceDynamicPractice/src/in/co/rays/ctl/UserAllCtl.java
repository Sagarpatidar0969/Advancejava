package in.co.rays.ctl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;
import in.co.rays.util.DataUtility;

@WebServlet("/UserAllCtl")
public class UserAllCtl extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String obj = req.getParameter("r1");
		
		if(obj.equals("Update")) {
		int id = Integer.parseInt(req.getParameter("id"));
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String login = req.getParameter("loginId");
		String pass = req.getParameter("password");
		String dob = req.getParameter("dob");
		String addr = req.getParameter("address");
		
		UserBean bean = new UserBean();
		bean.setId(id);
		bean.setFirst_name(fname);
		bean.setLast_name(lname);
		bean.setLogin_id(login);
		bean.setPassword(pass);
		bean.setDob(DataUtility.stringToDate(dob));
		bean.setAddress(addr);
		
		UserModel model = new UserModel();
		
		try {
			model.update(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		else if(obj.equals("Search")) {
			
			
			UserModel model = new UserModel();
			
			try {
				List list = model.search();
				Iterator it = list.iterator();
				while(it.hasNext()) {
					
					UserBean bean = (UserBean) it.next();
					System.out.print(bean.getId());
					System.out.print("\t"+bean.getFirst_name());
					System.out.print("\t"+bean.getLast_name());
					System.out.print("\t"+bean.getLogin_id());
					System.out.print("\t"+bean.getPassword());
					System.out.print("\t"+bean.getDob());
					System.out.println("\t"+bean.getAddress());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		else if(obj.equals("Delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			
			UserModel model = new UserModel();
			
			try {
				model.delete(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		else if(obj.equals("FindById")) {
			int id = Integer.parseInt(req.getParameter("id"));
			UserModel model = new UserModel();
			
			try {
				model.findById(id);
				UserBean bean = model.findById(id);
				if(bean != null) {
					System.out.print(bean.getId());
					System.out.print("\t"+bean.getFirst_name());
					System.out.print("\t"+bean.getLast_name());
					System.out.print("\t"+bean.getLogin_id());
					System.out.print("\t"+bean.getPassword());
					System.out.print("\t"+bean.getDob());
					System.out.println("\t"+bean.getAddress());
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	

}
