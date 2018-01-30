package com.mzsds.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mzsds.domain.ACLUserBO;
import com.mzsds.service.LoginService;

@SuppressWarnings("serial")
@WebServlet("/servlet/LoginServlet")
public class LoginServlet extends BaseServlet {

	/**
	 * 用户登录判断，登录失败时返回失败信息。0:用户名不存在;2:密码错误；3：登陆异常；
	 * 
	 * @param requset
	 * @param response
	 * @throws Exception
	 */
	public void login(HttpServletRequest requset, HttpServletResponse response)
			throws Exception {

		String username = requset.getParameter("username");
		String password = requset.getParameter("password");
		int status = LoginService.login(username, password);
		if (status == 1) {
			ACLUserBO aclUserBO = LoginService.getUserIDAndName(username);
			requset.setAttribute("aclUserBO", aclUserBO);
			requset.getRequestDispatcher("/production/FrameIndex.jsp").forward(
					requset, response);
		} else {
			requset.setAttribute("status", status);
			requset.getRequestDispatcher("/production/Login.jsp").forward(
					requset, response);
		}
	}

	/**
	 * 用户退出登录
	 * 
	 * @param requset
	 * @param response
	 * @throws Exception
	 */
	public void loginOut(HttpServletRequest requset,
			HttpServletResponse response) throws Exception {

		//删除cookie
		LoginService.deleteCookie(requset, response);
		
		//删除session
		LoginService.removeSession(requset);
		requset.getRequestDispatcher("/production/Login.jsp").forward(requset,
				response);
	}
}
