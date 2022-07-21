package com.controller;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.HouseBean;
import com.bean.InstructionBean;
import com.dao.HouseDao;
import com.dao.InstructionDao;

/**
 * Servlet implementation class ListhousenoController
 */
public class ListhousenoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HouseDao houseDao = new HouseDao();
		ArrayList<HouseBean> houses = houseDao.listhousetoadmin();
		InstructionDao instructionDao = new InstructionDao();
		ArrayList<InstructionBean> instruction = instructionDao.listinst(); 
		request.setAttribute("houses", houses);
		request.setAttribute("instruction", instruction);

		request.getRequestDispatcher("securitygate.jsp").forward(request, response);
	}



}
