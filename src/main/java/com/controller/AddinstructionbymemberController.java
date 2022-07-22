package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.InstructionBean;
import com.dao.InstructionDao;


public class AddinstructionbymemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String description = request.getParameter("description");
		String exit_time = request.getParameter("exit_time");
		String block_number =  request.getParameter("block_number");
		String status =  request.getParameter("status");

		int house_number = Integer.parseInt(request.getParameter("house_number"));

		InstructionBean instructionBean = new InstructionBean();
		instructionBean.setName(name);
		instructionBean.setType(type);
		instructionBean.setDescription(description);
		instructionBean.setExit_time(exit_time);
		instructionBean.setHouseid(house_number);
		instructionBean.setBlock_name(block_number);
		instructionBean.setStatus(status);
		InstructionDao instructionDao = new InstructionDao();
		int record = instructionDao.addinstructionbymember(instructionBean);
		if (record == 0) {
			response.sendRedirect("addinstructionbymember.jsp");
		} else {

			response.sendRedirect("welcome.jsp");
		}
	}

}
