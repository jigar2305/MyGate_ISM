package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.SecurityBean;
import com.dao.SecurityDao;

public class LoginsecurityController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String number = request.getParameter("number");
		String password = request.getParameter("password");

		SecurityDao securityDao = new SecurityDao();
		SecurityBean security = securityDao.loginsecurity(number, password);
		if (security == null) {
			request.setAttribute("msg", "in correct credentials");
			request.getRequestDispatcher("securitylogin.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("securityid", security.getSecurityid());
			session.setAttribute("firstname", security.getFirstname());
			response.sendRedirect("ListhousenoController");

		}
	}

}
