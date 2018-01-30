package com.mzsds.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mzsds.domain.JKTTBO;
import com.mzsds.service.JkttService;

@SuppressWarnings("serial")
@WebServlet("/servlet/JkttServlet")
public class JkttServlet extends BaseServlet {

	private static String[] module = { "jktt_news", "jktt_cloud", "jktt_bigdata", "jktt_AI", "jktt_iot",
			"jktt_language", "jktt_database", "jktt_frontend", "jktt_mobile", "jktt_os", "jktt_game",
			"jktt_tools", "jktt_se", "jktt_career", "jktt_osproject" };
	private static String[] moduleName = { "业界", "云计算", "大数据 ", "人工智能", "物联网 ",
			"语言", "数据库", "前端", "移动开发", "系统网络安全", "游戏与图像", "研发工具", "软件工程",
			"程序人生", "开源项目" };

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
		List<JKTTBO> jkttBOList = JkttService.getModularListAfterTime(type);
		
		String typeModuleName = "";
		for(int i = 0;i < module.length;i++){
			if(type.toLowerCase().equals(module[i].toLowerCase())){
				typeModuleName = moduleName[i];
			}
		}
		requset.setAttribute("typeModuleName", typeModuleName);
		requset.setAttribute("jkttBOList", jkttBOList);
		requset.getRequestDispatcher("/production/JkttList.jsp").forward(
				requset, response);
	}
}
