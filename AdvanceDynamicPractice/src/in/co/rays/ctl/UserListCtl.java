package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.model.UserModel;

@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserModel model = new UserModel();
		try {
			List list = model.search();
			req.setAttribute("list", list);
			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}
