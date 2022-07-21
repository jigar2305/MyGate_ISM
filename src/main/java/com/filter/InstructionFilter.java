package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InstructionFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String description = request.getParameter("description");
		String exit_time = request.getParameter("exit_time");
		int block_number =Integer.parseInt( request.getParameter("block_number"));
		int house_number =Integer.parseInt(  request.getParameter("house_number"));
		Boolean isError = false;

		if (name == null || name.trim().length() == 0) {
			isError = true;
			request.setAttribute("nameError", "please enter name");
		} else {
			request.setAttribute("namevalue", name);
		}
		if (type == null || type.trim().length() == 0) {
			isError = true;
			request.setAttribute("typeError", "please enter your type");
		} else {
			request.setAttribute("typevalue", type);
		}
		if (description == null || description.trim().length() == 0) {
			isError = true;
			request.setAttribute("descriptionError", "please enter description");
		} else {
			request.setAttribute("descriptionvalue", description);
		}
		if (exit_time == null || exit_time.trim().length() == 0) {
			isError = true;
			request.setAttribute("exit_timeError", "please enter exit_time");
		} else {
			request.setAttribute("exit_timevalue", exit_time);
		}
		if(block_number != house_number) {
			isError = true;
			request.setAttribute("FlateError", "flate does not exist");
		}

		try {
			if (isError) {
				request.getRequestDispatcher("ListhousenoController").forward(request, response);
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
