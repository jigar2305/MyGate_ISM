package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;

/**
 * Servlet implementation class LoginControlle
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao userDao = new UserDao();
		UserBean user = userDao.login(email,password);
		if(user == null) {
			request.setAttribute("msg", "in correct credentials");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			if(user.getActive().equals("active")) {
				HttpSession session = request.getSession();
				session.setAttribute("userid", user.getUserid());
				session.setAttribute("firstname", user.getFirstname());
				session.setAttribute("email", user.getEmail());
				if (user.getRole().equals("chairman")) {
					response.sendRedirect("ListhousetoadminController");
					
				}else {
					request.setAttribute("user", user);
					request.getRequestDispatcher("welcome.jsp").forward(request, response);
				}
				
			}else {
				request.setAttribute("activate", "your account is not approved, please contect admin.");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			
			}
		}
		

		
	}

}
