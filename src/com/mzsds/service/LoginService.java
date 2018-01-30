package com.mzsds.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mzsds.dao.LoginDao;
import com.mzsds.domain.ACLUserBO;
import com.mzsds.global.CookieUse;
import com.mzsds.global.SessionUse;

public class LoginService {

	/**
	 * 登录判断，先判断用户名是否存在，之后判断密码是否正确
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return returnMessage 0:用户名不存在;2:密码错误；3：登陆异常；1:登陆成功；4：失效；
	 */
	public static int login(String username, String password) {
		int returnMessage = 0;

		if (username == null || "".equals(username)) {
			return -1;
		}
		if (LoginDao.selectUserName(username) == 0) {
			returnMessage = 0;
		} else if (LoginDao.selectUserName(username) == 2) {
			returnMessage = 4;
		} else {
			if (!LoginDao.selectPasswordByUsernameAndPassword(username,
					password)) {
				returnMessage = 2;
			} else {
				if (LoginDao.updateLoginStatus(1, username)) {
					returnMessage = 1;
				} else {
					returnMessage = 3;
				}
			}
		}
		return returnMessage;
	}

	/**
	 * 登录时获取登录用户的信息并返回
	 * 
	 * @param username
	 *            用户名
	 * @return aclUserBO 用户信息
	 * @throws Exception
	 */
	public static ACLUserBO getUserIDAndName(String username) throws Exception {
		ACLUserBO aclUserBO = LoginDao.selectUserByName(username);
		return aclUserBO;
	}

	/**
	 * 修改用户登陆状态
	 * 
	 * @param loginStatus
	 *            登陆状态：0，未登录；1：登陆
	 * @param username
	 */
	public static boolean updateLoginStatus(int loginStatus, String username) {
		return LoginDao.updateLoginStatus(loginStatus, username);
	}

	/**
	 * 查询用户登陆状态
	 * 
	 * @param username
	 * @return 登陆状态：0，未登录；1：登陆
	 */
	public static int getLoginStatus(String username) {
		return LoginDao.selectLoginStatusByName(username);
	}

	/**
	 * 登录的时候建立一个临时的cookie. cookie的name定为：cookie,value定为sessionID
	 * 
	 * @param requset
	 * @return
	 */
	public static void addCookieOnLogin(HttpServletResponse response,String sessionID) {
		// 建立一个临时的cookie，用来判断用户是否登录
		CookieUse.addCookie(response, "cookie", sessionID);
	}

	/**
	 * 根据cookie判断，是否是在登录状态（cookie的name定为：xiaopaomo,value定为sessionId）
	 * 
	 * @param requset
	 * @return 是：true，否：false
	 */
	public static boolean isLoginByCookie(HttpServletRequest requset) {
		// 判断cookie是否存在
		if (CookieUse.getCookieByName(requset, "cookie") == null) {
			return false;
		} else {
			Cookie cookie = CookieUse.getCookieByName(requset, "cookie");
			String cookieValue = cookie.getValue();
			HttpSession session = requset.getSession();
			session.getAttribute("xiaopaomo");
			String sessionId = session.getId();
			if (cookieValue.equals(sessionId)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 删除name为xiaopaomo的cookie
	 * 
	 * @param requset
	 * @return
	 */
	public static void deleteCookie(HttpServletRequest requset,
			HttpServletResponse response) {
		// 判断cookie是否存在
		if (CookieUse.getCookieByName(requset, "cookie") != null) {
			CookieUse.addCookie(response, "cookie", "");
		}
	}

	/**
	 * 新建一个session，name：xiaopaomo；value：threepeople,并根据sessionID创建一个cookie
	 * 
	 * @param req
	 */
	public static void getSession(HttpServletRequest req,HttpServletResponse response ) {
		String sessionID = SessionUse.addSessionOnLogin(req,"xiaopaomo","threepeople");
		addCookieOnLogin(response, sessionID);
		
	}

	/**
	 * 判断是否存在name：xiaopaomo和value：threepeople一致的session
	 * 
	 * @param req
	 * @return 是，true
	 */
	public static boolean isSessionUseNameAndValue(HttpServletRequest req) {
		return SessionUse.isSessionUseNameAndValue(req, "xiaopaomo",
				"threepeople");
	}

	/**
	 * 删除session
	 * 
	 * @param req
	 */
	public static void removeSession(HttpServletRequest req) {
		SessionUse.initSession(req);
	}

}
