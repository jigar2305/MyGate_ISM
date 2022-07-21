package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

/**
 * Servlet implementation class SignupController
 */
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String contact_number = request.getParameter("contact_number");
		String gender = request.getParameter("gender");
		
		UserBean userBean = new UserBean();
		userBean.setFirstname(firstname);
		userBean.setLastname(lastname);
		userBean.setEmail(email);
		userBean.setPassword(password);
		userBean.setGender(gender);
		userBean.setContact_number(contact_number);
		UserDao userDao = new UserDao();
		int record = userDao.adduser(userBean);
		
		if(record == 0) {
			request.setAttribute("msg", "something went wrong");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("waiting.jsp").forward(request, response);
		}
		

	}

}
