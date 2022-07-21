package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.InstructionBean;
import com.dao.InstructionDao;


public class ListinstructiontoadminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InstructionDao instructionDao = new InstructionDao();
		ArrayList<InstructionBean> instruction = instructionDao.listinsttoadmin(); 
		request.setAttribute("instruction", instruction);
		request.getRequestDispatcher("instructionadmin.jsp").forward(request, response);
	}

}
