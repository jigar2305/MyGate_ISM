package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SecurityBean;

import com.dao.SecurityDao;


public class AddsecurityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String contact_number = request.getParameter("contact_number");
		String password = request.getParameter("password");


		SecurityBean securityBean = new SecurityBean();
		
		securityBean.setFirstname(firstname);
		securityBean.setLastname(lastname);
		securityBean.setContact_number(contact_number);
		securityBean.setPassword(password);
		SecurityDao securityDao = new SecurityDao(); 
		int record = securityDao.addsecurity(securityBean);
			if(record == 0) {
				request.setAttribute("msg", "something went wrong");
				request.getRequestDispatcher("addsecurity.jsp").forward(request, response);
			}else{
				response.sendRedirect("ListsecurityController");
			}
	
	
	
	}

}
