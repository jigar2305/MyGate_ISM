package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.HouseBean;
import com.bean.InstructionBean;
import com.dao.HouseDao;
import com.dao.InstructionDao;


public class ListhousenobyidController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int userid = (int) session.getAttribute("userid");
		HouseDao houseDao = new HouseDao();
		ArrayList<HouseBean> houses = houseDao.listhousetoadminbyid(userid);
		request.setAttribute("houses", houses);

		request.getRequestDispatcher("addinstructionbymember.jsp").forward(request, response);
	}


	
}
