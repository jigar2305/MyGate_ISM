package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.InstructionBean;
import com.dao.InstructionDao;


public class ListinstructionmemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession(false);
	int userid = (int) session.getAttribute("userid");
		InstructionDao instructionDao = new InstructionDao();
		ArrayList<InstructionBean> instruction = instructionDao.listinstbyuserid(userid);
		request.setAttribute("instruction", instruction);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}


}
