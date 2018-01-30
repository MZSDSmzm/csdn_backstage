package com.mzsds.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.mzsds.dao.ForumDao;
import com.mzsds.domain.FORUMBO;
import com.mzsds.util.LogUtil;

public class ForumService {

	/**
	 * 获取模块所有信息
	 * 
	 * @param type
	 *            模块名称
	 * @return
	 */
	public static List<FORUMBO> getAllModularList(String type) {
		List<FORUMBO> forumBOList = ForumDao.selectAllModularList(type);
		return forumBOList;
	}

	/**
	 * 获取模块时间内的数据
	 * 
	 * @param type
	 *            模块名称
	 * @return
	 */
	public static List<FORUMBO> getModularListAfterTime(String type) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_WEEK, -14);
		Date m = c.getTime();
		String mon = format.format(m);
		LogUtil.log("时间： " + mon + " 前");

		List<FORUMBO> forumBOList = ForumDao.selectModularListAfterTime(type,
				mon);
		return forumBOList;
	}
	
}
