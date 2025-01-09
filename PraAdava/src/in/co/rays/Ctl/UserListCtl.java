package in.co.rays.Ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		int pageNo = 1;
		int pageSize = 5;

		try {
			List list = model.search(null, pageNo, pageSize);
			req.setAttribute("list", list);
			req.setAttribute("pageNo", pageNo);
			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		int pageNo =1;
	    int pageSize=5;
	    
	     String op=req.getParameter("operation");  
	     
	   
	     
	     pageNo= Integer.parseInt(req.getParameter("pageNo"));
		
		 if(op.equals("search")) {
			 pageNo = 1;
			 String fname=req.getParameter("firstName");
			 
			 bean.setFirst_name(fname);
		 }
		 
		  if(op.equals("next")) {
			  pageNo++;
		  }
		  if(op.equals("previous")) {
			  pageNo--;
		  }
		   try {
			List list=model.search(bean,pageNo,pageSize);
			req.setAttribute("list", list);
			req.setAttribute("pageNo", pageNo);
			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);
			
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
	}

}
