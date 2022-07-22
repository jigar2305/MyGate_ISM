package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.MemberBean;
import com.dao.MemberDao;

public class AddmemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		int age = Integer.parseInt(request.getParameter("age"));
		int houseid = Integer.parseInt(request.getParameter("houseid"));
		System.out.println(houseid + "hello");
		String contact_number = request.getParameter("contact_number");
		String gender = request.getParameter("gender");
		HttpSession session = request.getSession(false);
		int userid = (int) session.getAttribute("userid");
		MemberBean memberBean = new MemberBean();
		memberBean.setAge(age);
		memberBean.setUserid(userid);
		memberBean.setContact_number(contact_number);
		memberBean.setFirstname(firstname);
		memberBean.setGender(gender);
		memberBean.setHouseid(houseid);
		MemberDao memberDao = new MemberDao();
		int record = memberDao.addmember(memberBean);
		if (record == 0) {
			request.setAttribute("msg", "something went wrong");
			request.getRequestDispatcher("addmember.jsp").forward(request, response);
		} else {
			response.sendRedirect("ListmemberController");
		}
	}

}
