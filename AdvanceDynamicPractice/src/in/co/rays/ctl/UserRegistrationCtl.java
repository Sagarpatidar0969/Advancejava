package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;
import in.co.rays.util.DataUtility;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		String login = req.getParameter("loginId");
		String pass = req.getParameter("password");
		String dob  = req.getParameter("dob");
		String addr = req.getParameter("address");
		
		UserBean bean  = new UserBean();
		bean.setFirst_name(fname);
		bean.setLast_name(lname);
		bean.setLogin_id(login);
		bean.setPassword(pass);
		bean.setDob(DataUtility.stringToDate(dob));
		bean.setAddress(addr);
		
		UserModel model = new UserModel();
		try {
			model.add(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("UserRegistrationCtl.jsp");
		
	}
	
}
