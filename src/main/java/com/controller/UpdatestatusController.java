package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.InstructionDao;

public class UpdatestatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			int instructionid = Integer.parseInt(request.getParameter("instructionid")); 
			System.out.println(instructionid);
			InstructionDao instructionDao = new InstructionDao();
			int record = instructionDao.updatestatus(instructionid);
			if(record==1) {
				request.getRequestDispatcher("ListinstructionmemberController").forward(request, response);
			}else {
				request.setAttribute("msg", "something went wrong");
				request.getRequestDispatcher("ListinstructionmemberController").forward(request, response);

			}
	}

}
