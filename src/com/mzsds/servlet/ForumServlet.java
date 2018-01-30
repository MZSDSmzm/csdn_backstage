package com.mzsds.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mzsds.domain.FORUMBO;
import com.mzsds.service.ForumService;

@SuppressWarnings("serial")
@WebServlet("/servlet/ForumServlet")
public class ForumServlet extends BaseServlet {
	
	private static String[] module = {"forum_Mobile", "forum_CloudComputing", "forum_Java", 
		"forum_DotNET", "forum_WebDevelop", "forum_Embedded", "forum_Linux", "forum_Enterprise", "forum_Windows"};;
	private static String[] moduleName = { "移动开发", "云计算", "Java", ".NET技术", "Web开发",
		"硬件/嵌入开发", "Linux", "企业IT", "Windows专区" };
		
	/**
	 * 获取模块信息
	 * 
	 * @param requset
	 * @param response
	 * @throws Exception
	 */
	public void getModularList(HttpServletRequest requset,
			HttpServletResponse response) throws Exception {
		String type = requset.getParameter("type");
		List<FORUMBO> forumBOList = ForumService.getModularListAfterTime(type);
		
		String typeModuleName = "";
		for(int i = 0;i < module.length;i++){
			if(type.toLowerCase().equals(module[i].toLowerCase())){
				typeModuleName = moduleName[i];
				break;
			}
		}
		requset.setAttribute("typeModuleName", typeModuleName);
		requset.setAttribute("forumBOList", forumBOList);
		requset.getRequestDispatcher("/production/ForumList.jsp").forward(
				requset, response);
	}
}
