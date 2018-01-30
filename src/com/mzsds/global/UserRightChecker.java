package com.mzsds.global;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mzsds.util.HttpUtil;
import com.mzsds.util.LogUtil;

/**
 * 权限检查
 */
public class UserRightChecker implements Filter {

	/** 免登录页面列表 */
	private ArrayList<String> FreePageList = new ArrayList<String>();

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		FreePageList.add("/production/Login.jsp");
		FreePageList.add("/production/page_404.jsp");
		FreePageList.add("/production/page_403.jsp");
		FreePageList.add("/production/page_500.jsp");
		FreePageList.add("/production/images/img.jpg");
		FreePageList.add("/servlet/Main");
	}

	/**
	 * 检查用户是否具有页面访问权限。
	 */
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		// 1. 整理参数。得到 request、response、url 对象。
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String curURL = request.getServletPath().replace("//", "/");

		// 2. 若属于不用检测的链接，直接通过检测，继续访问。
		if (FreePageList.contains(curURL)) {
			chain.doFilter(request, response);
			return;
		}else{
			LogUtil.log("未登录，拒绝访问" + curURL);
			response.sendRedirect(HttpUtil.getRequestBaseURL(request)
					+ "/production/page_403.jsp");
			return;
		}
	}

	@Override
	public void destroy() {
	}

}
