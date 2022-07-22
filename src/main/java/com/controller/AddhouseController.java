package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.HouseBean;
import com.dao.HouseDao;


public class AddhouseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String house_number = request.getParameter("house_number");
		String block_name = request.getParameter("block_name");
		
		HouseBean houseBean = new HouseBean();
		
		HttpSession session = request.getSession(false);
		int userid = (int) session.getAttribute("userid");
		houseBean.setUserid(userid);	
		houseBean.setblock_name(block_name);
		houseBean.setHouse_number(house_number);
		
		
		HouseDao houseDao = new HouseDao();
		if(houseDao.addhouse(houseBean)) {
			request.getRequestDispatcher("ListhousebyidController").forward(request, response);
		}else {
			request.setAttribute("msg", "something went wrong");
			request.getRequestDispatcher("addhouse.jsp").forward(request, response);

		}
	}

}
