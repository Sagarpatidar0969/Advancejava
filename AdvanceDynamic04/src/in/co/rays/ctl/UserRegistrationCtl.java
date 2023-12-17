package in.co.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;
import in.co.rays.util.DataUtility;


@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("UserRegistrationView.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String fname = req.getParameter("firstName");
//		String lname = req.getParameter("lastName");
//		String login = req.getParameter("loginId");
//		String pass = req.getParameter("password");
//		String d    =  req.getParameter("dob");
//		String address = req.getParameter("address");
//		
//		System.out.println(fname);
//		System.out.println(lname);
//		System.out.println(login);
//		System.out.println(pass);
//		System.out.println(d);
//		System.out.println(address);
		
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		String login = req.getParameter("loginId");
		String pass = req.getParameter("password");
		String d    =  req.getParameter("dob");
		String address = req.getParameter("address");
		
		
		UserBean bean = new UserBean();
		bean.setFirst_name(fname);
		bean.setLast_name(lname);
		bean.setLogin_id(login);
		bean.setPassword(pass);
		bean.setDob(DataUtility.stringToDate(d));
		bean.setAddress(address);
		
		UserModel model = new UserModel();
		 try {
			model.add(bean);
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
		 
		 resp.sendRedirect("LoginView.jsp");
	}
	
	

}
