package com.mzsds.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.mzsds.dao.JkttDao;
import com.mzsds.domain.JKTTBO;
import com.mzsds.util.LogUtil;

public class JkttService {

	/**
	 * 获取模块所有信息
	 * 
	 * @param type
	 *            模块名称
	 * @return
	 */
	public static List<JKTTBO> getAllModularList(String type) {
		List<JKTTBO> jkttBOList = JkttDao.selectAllModularList(type);
		return jkttBOList;
	}

	/**
	 * 获取模块时间内的数据
	 * 
	 * @param type
	 *            模块名称
	 * @return
	 */
	public static List<JKTTBO> getModularListAfterTime(String type) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.MONTH, -1);
		Date m = c.getTime();
		String mon = format.format(m);
		LogUtil.log("时间： " + mon + " 前");

		List<JKTTBO> jkttBOList = JkttDao
				.selectModularListAfterTime(type, mon);
		return jkttBOList;
	}

}
