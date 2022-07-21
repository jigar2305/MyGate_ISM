package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HouseDao;

public class AllowhouseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int houseid =Integer.parseInt(request.getParameter("houseid"));
		String status1 = request.getParameter("status");
		System.out.println(status1+"___________");
		
		if(status1.equals("allow")) {
			String status  = "n";
			if(HouseDao.updatehousestatus(houseid,status)) {		
				response.sendRedirect("ListhousetoadminController");
			}else {
				request.setAttribute("msg", "something went wrong");
				request.getRequestDispatcher("ListhousetoadminController").forward(request, response);
			}
		}else {
			String status  = "y";
			if(HouseDao.updatehousestatus(houseid,status)) {		
				response.sendRedirect("ListhousetoadminController");
			}else {
				request.setAttribute("msg", "something went wrong");
				request.getRequestDispatcher("ListhousetoadminController").forward(request, response);
			}
		}
	}


}
