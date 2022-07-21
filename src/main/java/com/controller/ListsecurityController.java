package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SecurityBean;
import com.dao.SecurityDao;


public class ListsecurityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SecurityDao securityDao = new SecurityDao();
		ArrayList<SecurityBean> securitys = securityDao.listsecurity();
		request.setAttribute("security", securitys);
		request.getRequestDispatcher("listsecurity.jsp").forward(request, response);
	}



}
