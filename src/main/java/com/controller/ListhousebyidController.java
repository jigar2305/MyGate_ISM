package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.HouseBean;

import com.dao.HouseDao;


/**
 * Servlet implementation class ListhousebyidController
 */
public class ListhousebyidController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 HouseDao houseDao = new HouseDao();
		HttpSession session = request.getSession(false);
		int userid = (int) session.getAttribute("userid");
		ArrayList<HouseBean> houses = houseDao.listhouse(userid);
		request.setAttribute("houses", houses);
		request.getRequestDispatcher("listhousebyid.jsp").forward(request, response);
	}



}
