package com.mzsds.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mzsds.domain.ACLUserBO;
import com.mzsds.service.UserService;

@SuppressWarnings("serial")
@WebServlet("/servlet/UserServlet")
public class UserServlet extends BaseServlet {

	/**
	 * 获取全部用户信息
	 * 
	 * @param requset
	 * @param response
	 * @throws Exception
	 */
	public void getUserList(HttpServletRequest requset,
			HttpServletResponse response) throws Exception {
		List<ACLUserBO> aclUserBOList = UserService.getAllUserList();
		requset.setAttribute("aclUserBOList", aclUserBOList);
		requset.getRequestDispatcher("/production/UserList.jsp").forward(
				requset, response);
	}

	/**
	 * 用户信息ID查询编辑
	 * 
	 * @param requset
	 * @param response
	 * @throws Exception
	 */
	public void editUser(HttpServletRequest requset,
			HttpServletResponse response) throws Exception {
		String userID = requset.getParameter("userID");
		ACLUserBO aclUserBO = UserService.checkUser(userID);
		requset.setAttribute("aclUserBO", aclUserBO);
		requset.getRequestDispatcher("/production/UserSpec.jsp").forward(
				requset, response);
	}

	/**
	 * 用户信息ID查询
	 * 
	 * @param requset
	 * @param response
	 * @throws Exception
	 */
	public void checkUser(HttpServletRequest requset,
			HttpServletResponse response) throws Exception {
		String userID = requset.getParameter("userID");
		ACLUserBO aclUserBO = UserService.checkUser(userID);
		requset.setAttribute("aclUserBO", aclUserBO);
		requset.getRequestDispatcher("/production/UserSpec.jsp").forward(
				requset, response);
	}

	/**
	 * 根据ID删除用户
	 * 
	 * @param requset
	 * @param response
	 * @throws Exception
	 */
	public void removeUser(HttpServletRequest requset,
			HttpServletResponse response) throws Exception {
		String userID = requset.getParameter("userID");
		UserService.removeUser(userID);
		getUserList(requset, response);
	}

	/**
	 * 增加用户
	 * 
	 * @param requset
	 * @param response
	 * @param aclUserBO
	 * @throws Exception
	 */
	public void addUser(HttpServletRequest requset, HttpServletResponse response)
			throws Exception {
		ACLUserBO aclUserBO = new ACLUserBO();
		if (requset.getParameter("userID") != null
				&& !"".equals(requset.getParameter("userID"))) {
			aclUserBO
					.setUserID(Integer.parseInt(requset.getParameter("userID")));
		} else {
			aclUserBO.setUserID(0);
		}
		aclUserBO.setUserName(requset.getParameter("userName"));
		aclUserBO.setUserPassword(requset.getParameter("userPassword"));
		aclUserBO.setUserSex(Integer.parseInt(requset.getParameter("userSex")));
		aclUserBO.setUserPhoneNumber(requset.getParameter("userPhoneNumber"));
		aclUserBO.setStatus(Integer.parseInt(requset.getParameter("status")));

		System.out.println(requset.getParameter("addTime"));
		aclUserBO.setAddTime2(requset.getParameter("addTime"));
		UserService.addUser(aclUserBO);
		getUserList(requset, response);
	}

	public void addPage(HttpServletRequest requset, HttpServletResponse response)
			throws Exception {
		requset.getRequestDispatcher("/production/UserSpec.jsp").forward(
				requset, response);
	}
}
