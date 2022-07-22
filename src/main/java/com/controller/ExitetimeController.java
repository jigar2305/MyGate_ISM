package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.InstructionDao;


public class ExitetimeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int instructionid = Integer.parseInt(request.getParameter("instructionid"));
		InstructionDao instructionDao = new InstructionDao();
		int record = instructionDao.exitetime(instructionid);
		if(record==0) {
			response.sendRedirect("ListhousenoController");
		}else {
			response.sendRedirect("ListhousenoController");
		}
	}



}
