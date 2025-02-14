package com.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.AdminDao;



public class AdminLogin extends HttpServlet
{
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String aid = req.getParameter("aid");
	String apass = req.getParameter("apass");
	System.out.println("Admin id = "+aid);
	System.out.println("Admin password = "+apass);
	boolean flag = AdminDao.adminLogin(aid, apass);
	if(flag)
	{
		RequestDispatcher rd = req.getRequestDispatcher("adminhome.jsp");
		rd.forward(req, resp);
	}
	else
	{
		RequestDispatcher rd = req.getRequestDispatcher("adminlogin.jsp");
		rd.forward(req, resp);
	}
}


	
}

