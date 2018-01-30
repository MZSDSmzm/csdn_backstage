package com.mzsds.global;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mzsds.util.LogUtil;

public class SessionUse {

	/**
	 * 新建一个session，name：xiaopaomo；value：threepeople
	 * 
	 * @param request
	 * @return
	 */
	public static String addSessionOnLogin(HttpServletRequest request,String name,String value) {
		String sessionId = "";
		if (isSessionUseNameAndValue(request,name,value)) {
			HttpSession session = request.getSession();
			session.getAttribute(name);
			sessionId = session.getId();
			LogUtil.log("服务器中已经包含此session，session的id是：" + sessionId);
		}else{
			// 使用request对象的getSession()获取session，如果session不存在则创建一个
			HttpSession session = request.getSession();
			// 将数据存储到session中
			session.setAttribute(name, value);
			// 获取session的Id
			sessionId = session.getId();
			// 判断session是不是新创建的
			if (isSessionUseNameAndValue(request,name,value)) {
				LogUtil.log("session创建成功，session的id是：" + sessionId);
			} else {
				LogUtil.log("session创建失败");
			}
		}
		
		return sessionId;
	}

	/**
	 * session.removeAttribute("sessionname")是清除SESSION里的某个属性.
	 * session.invalidate()是让SESSION失效.
	 * 用getAttributeNames来得到所有属性名,然后再removeAttribute
	 * 
	 * @param request
	 */
	public static void initSession(HttpServletRequest request) {
		@SuppressWarnings("rawtypes")
		Enumeration em = request.getSession().getAttributeNames();
		while (em.hasMoreElements()) {
			request.getSession().removeAttribute(em.nextElement().toString());
		}
	}

	/**
	 * 判断是否存在name和value一致的session
	 * 
	 * @param request
	 * @param name
	 * @param value
	 * @return 是，true
	 */
	public static boolean isSessionUseNameAndValue(HttpServletRequest request,
			String name, String value) {
		HttpSession session = request.getSession();
		String sessionValue = (String) session.getAttribute(name);
		if(sessionValue == null || "".equals(sessionValue)){
			return false;
		}
		if (sessionValue.equals(value)) {
			return true;
		} else {
			return false;
		}
	}
}
