package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



public class HouseFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String house_number = request.getParameter("house_number");
		String block_name = request.getParameter("block_name");


		Boolean isError = false;

		if (house_number == null || house_number.trim().length() == 0) {
			isError = true;
			request.setAttribute("house_numberError", "please enter house_number");
		} else {
			request.setAttribute("house_numbervalue", house_number);
		}
		if (block_name == null || block_name.trim().length() == 0) {
			isError = true;
			request.setAttribute("block_nameError", "please enter block_name");
		} else {
			request.setAttribute("block_namevalue", block_name);
		}
		try {
			if (isError) {
				request.getRequestDispatcher("addhouse.jsp").forward(request, response);
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
