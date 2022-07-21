package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;


public class ActiveUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int userid =  Integer.parseInt(request.getParameter("userid"));
	UserDao userDao = new UserDao();
	String active = request.getParameter("active");
	
	if(active.equals("active")) {
		String status  = "deactive";
		if(userDao.updateactive(userid,status)) {		
			response.sendRedirect("ListuserController");
		}else {
			request.setAttribute("msg", "something went wrong");
			request.getRequestDispatcher("ListuserController").forward(request, response);
		}
	}else {
		String status  = "active";
		if(userDao.updateactive(userid,status)) {		
			response.sendRedirect("ListuserController");
		}else {
			request.setAttribute("msg", "something went wrong");
			request.getRequestDispatcher("ListuserController").forward(request, response);
		}
	}
	
	
	}
}
