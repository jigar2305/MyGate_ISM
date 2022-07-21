package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.dao.UserDao;

public class SignupFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String contact_number = request.getParameter("contact_number");
		String gender = request.getParameter("gender");

		UserDao userDao = new UserDao();
		Boolean isError = false;

		if (firstname == null || firstname.trim().length() == 0) {
			isError = true;
			request.setAttribute("firstnameError", "please enter firstname");
		} else {
			request.setAttribute("firstnamevalue", firstname);
		}
		if (lastname == null || lastname.trim().length() == 0) {
			isError = true;
			request.setAttribute("lastnameError", "please enter lastname");
		} else {
			request.setAttribute("lastnamevalue", lastname);
		}
		if (password == null || password.trim().length() == 0) {
			isError = true;
			request.setAttribute("passwordError", "please enter password");
		} else {
			request.setAttribute("passwordvalue", password);
		}
		if (gender == null || gender.trim().length() == 0) {
			isError = true;
			request.setAttribute("genderError", "please select gender");
		} else {
			request.setAttribute("gendervalue", gender);
		}
		if (email == null || email.trim().length() == 0) {
			isError = true;
			request.setAttribute("emailError", "please enter email");
		} else if (userDao.duplicate(email)) {
			isError = true;
			request.setAttribute("emailError", "you have already account, please login");
		} else {
			request.setAttribute("emailvalue", email);
		}
		if (contact_number == null || contact_number.trim().length() == 0||contact_number.trim().length() <10 ||contact_number.trim().length() >10) {
			isError = true;
			request.setAttribute("numberError", "please enter contect number");
		} else {
			request.setAttribute("numbervalue", contact_number);
		}

		try {
			if (isError) {
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			} else {
				chain.doFilter(request, response);
			}
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
