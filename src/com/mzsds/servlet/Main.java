package com.mzsds.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mzsds.service.LoginService;

@SuppressWarnings("serial")
@WebServlet("/servlet/Main")
public class Main extends BaseServlet {

	/**
	 * 登录URL，主要目的是URL
	 * 
	 * @param requset
	 * @param response
	 * @throws Exception
	 */
	public void MZSDS(HttpServletRequest requset, HttpServletResponse response)
			throws Exception {
		String username = requset.getParameter("username");
		String password = requset.getParameter("password");
		
		// 增加session
		LoginService.getSession(requset,response);
		
		requset.getRequestDispatcher(
				"/servlet/LoginServlet?method=login&username=" + username
						+ "&password=" + password).forward(requset, response);
	}
	
	/**
	 * 系统主页
	 * 
	 * @param requset
	 * @param response
	 * @throws Exception
	 */
	public void HOME(HttpServletRequest requset, HttpServletResponse response)
			throws Exception {

		requset.getRequestDispatcher(
				"/production/Home.jsp").forward(requset, response);
	}

}
