package com.mzsds.dao;

import java.util.List;

import com.mzsds.domain.JKTTBO;
import com.mzsds.util.DBUtil;

public class JkttDao {

	/**
	 * 从数据库获取所有模块的数据
	 * 
	 * @param type
	 *            模块名称
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<JKTTBO> selectAllModularList(String type) {
		String sqlSelectUserName = "SELECT * FROM " + type;
		List<JKTTBO> jkttBOList = null;
		try {
			jkttBOList = (List<JKTTBO>) DBUtil.getInstance()
					.query(sqlSelectUserName).getDOList(JKTTBO.class, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jkttBOList;
	}

	/**
	 * 获取某个时间点以后的数据
	 * 
	 * @param type
	 * @param time
	 *            某时间后的数据
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<JKTTBO> selectModularListAfterTime(String type,
			String time) {
		String sqlSelectUserName = "SELECT * FROM " + type
				+ " WHERE ReportTime > '" + time + "' ORDER BY ReportTime DESC";
		List<JKTTBO> jkttBOList = null;
		try {
			jkttBOList = (List<JKTTBO>) DBUtil.getInstance()
					.query(sqlSelectUserName).getDOList(JKTTBO.class, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jkttBOList;
	}
}
