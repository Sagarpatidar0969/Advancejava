package in.co.rays.ctl;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;
import in.co.rays.util.DataUtility;

@WebServlet("/UserListCtl.do")
public class UserListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		int pageNo = 1;
		int pageSize = 5;

		try {
			List list = model.search(null, pageNo, pageSize);
			List nextlist = model.search(null, pageNo + 1, pageSize);

			req.setAttribute("list", list);
			req.setAttribute("nextlist", nextlist);
			req.setAttribute("pageNo", pageNo);

			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserBean bean = null;

		UserModel model = new UserModel();

		int pageNo = 1;
		int pageSize = 5;

		pageNo = Integer.parseInt(req.getParameter("pageNo"));
		
		

		String op = req.getParameter("operation");

		

		if (op.equals("search")) {
			pageNo = 1;
			String fname = req.getParameter("firstName");
			String dob = req.getParameter("dob");

			bean = new UserBean();

			bean.setFirst_name(fname);
			bean.setDob(DataUtility.stringToDate(dob));

		}

		if (op.equals("next")) {

			pageNo++;

		}

		if (op.equals("previous")) {

			pageNo--;

		}

		if (op.equals("delete")) {

			pageNo = 1;

			String[] ids = req.getParameterValues("ids");

			for (String id : ids) {

				try {
					model.delete(Integer.parseInt(id));

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

		try {
			List list = model.search(bean, pageNo, pageSize);
			List nextlist = model.search(bean, pageNo + 1, pageSize);

			req.setAttribute("list", list);
			req.setAttribute("nextlist", nextlist);
			req.setAttribute("pageNo", pageNo);

			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}