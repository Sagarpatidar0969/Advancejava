package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;
import in.co.rays.util.DataUtility;

@WebServlet("/UserCtl.do")
public class UserCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		if (id != null) {
			UserModel model = new UserModel();
			try {
				UserBean bean = model.findById(Integer.parseInt(id));
				req.setAttribute("bean", bean);
				System.out.println("----------------------");
			} catch (Exception e) {

				e.printStackTrace();
			}

		}
		RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		        String op = req.getParameter("operation");
		        UserModel model = new UserModel();
		        
		        if(op.equals("update")) {
		        	String id = req.getParameter("id");
					String fname = req.getParameter("firstName");
					String lname = req.getParameter("lastName");
					String login = req.getParameter("loginId");
					String pass = req.getParameter("password");
					String d    =  req.getParameter("dob");
					String address = req.getParameter("address");
					
					
					UserBean bean = new UserBean();
					bean.setId(Integer.parseInt(id));
					bean.setFirst_name(fname);
					bean.setLast_name(lname);
					bean.setLogin_id(login);
					bean.setPassword(pass);
					bean.setDob(DataUtility.stringToDate(d));
					bean.setAddress(address);
					
					 
					 try {
						model.update(bean);
						bean = model.findById(Integer.parseInt(id));
						req.setAttribute("bean", bean);
						req.setAttribute("msg", "data updated successfully");
						RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
						rd.forward(req, resp);
					} catch (Exception e) {
						
						e.printStackTrace();
					}	
					 
					 
				}
		        if(op.equals("save")) {
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
					
					 
					 try {
						model.add(bean);
						req.setAttribute("msg", "data added successfully");
						RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
						rd.forward(req, resp);
					} catch (Exception e) {
						
						e.printStackTrace();
					}	
					 
					 
				}
	}
}

