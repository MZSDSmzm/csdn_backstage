package com.mzsds.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mzsds.service.LoginService;

@SuppressWarnings("serial")
public class BaseServlet extends HttpServlet {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = req.getParameter("method");

		if (method.equals("MZSDS")|| LoginService.isLoginByCookie(req)
				|| LoginService.isSessionUseNameAndValue(req)
				) {
			if(LoginService.isSessionUseNameAndValue(req)){
				LoginService.removeSession(req);
			}
			Class clazz = this.getClass();
			try {
				Method method2 = clazz.getMethod(method,
						HttpServletRequest.class, HttpServletResponse.class);
				method2.invoke(this, req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			resp.sendRedirect("/csdn");
		}
	}
}
