package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecurityFilter  implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String firstname = request.getParameter("firstname");
		String lastname = (request.getParameter("lastname"));
		String contact_number = request.getParameter("contact_number");
		String password = request.getParameter("password");
		
		Boolean isError = false;

		if (firstname == null || firstname.trim().length() == 0) {
			isError = true;
			request.setAttribute("firstnameError", "please enter firstname");
		} else {
			request.setAttribute("firstnamevalue", firstname);
		}
		if (lastname == null || lastname.trim().length() == 0) {
			isError = true;
			request.setAttribute("lastnameError", "please enter your lastname");
		} else {
			request.setAttribute("lastnamevalue", lastname);
		}
		if (password == null || password.trim().length() == 0) {
			isError = true;
			request.setAttribute("passwordError", "please enter your password");
		}
		if (contact_number == null || contact_number.trim().length() == 0||contact_number.trim().length() <10 ||contact_number.trim().length() >10 ) {
			isError = true;
			request.setAttribute("numberError", "please enter contect number");
		} else {
			request.setAttribute("numbervalue", contact_number);
		}

		try {
			if (isError) {
				request.getRequestDispatcher("addsecurity.jsp").forward(request, response);
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
