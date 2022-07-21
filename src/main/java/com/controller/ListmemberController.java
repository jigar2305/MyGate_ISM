package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.MemberBean;
import com.dao.MemberDao;

/**
 * Servlet implementation class ListmemberController
 */
public class ListmemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao memberDao = new MemberDao();

		HttpSession session = request.getSession(false);
		int userid = (int) session.getAttribute("userid");
		ArrayList<MemberBean> members = memberDao.listmember(userid);
		request.setAttribute("members", members);
		request.getRequestDispatcher("listmember.jsp").forward(request, response);
	}

	

}
