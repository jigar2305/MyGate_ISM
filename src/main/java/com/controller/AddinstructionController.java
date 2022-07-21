package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.InstructionBean;
import com.dao.InstructionDao;

public class AddinstructionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String description = request.getParameter("description");
		String exit_time = request.getParameter("exit_time");
		String block_number =  request.getParameter("block_number");
		int house_number = Integer.parseInt(request.getParameter("house_number"));

		InstructionBean instructionBean = new InstructionBean();
		instructionBean.setName(name);
		instructionBean.setType(type);
		instructionBean.setDescription(description);
		instructionBean.setExit_time(exit_time);
		instructionBean.setHouseid(house_number);
		instructionBean.setBlock_name(block_number);
		InstructionDao instructionDao = new InstructionDao();
		int record = instructionDao.addinstruction(instructionBean);
		if (record == 0) {
			response.sendRedirect("ListhousenoController");
		} else {

			response.sendRedirect("ListhousenoController");
		}

	}

}
