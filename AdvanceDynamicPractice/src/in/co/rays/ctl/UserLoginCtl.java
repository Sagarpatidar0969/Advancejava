package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserLoginCtl")
public class UserLoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");
		if(op != null) {
			HttpSession session = req.getSession();
			session.invalidate();
		}
		

		resp.sendRedirect("UserLogin.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("loginId");
		String pass = req.getParameter("password");

		UserModel model = new UserModel();

		try {
			UserBean bean = model.authenticate(login, pass);
			if (bean != null) {
				HttpSession session = req.getSession();
				session.setAttribute("user", bean);
				resp.sendRedirect("UserWelcomeCtl");

//				req.setAttribute("user", bean);
//				RequestDispatcher rd = req.getRequestDispatcher("UserWelcome.jsp");
//				rd.forward(req, resp);
			} else {
				req.setAttribute("msg", "invalid login id & password");
				RequestDispatcher rd = req.getRequestDispatcher("UserLogin.jsp");
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
