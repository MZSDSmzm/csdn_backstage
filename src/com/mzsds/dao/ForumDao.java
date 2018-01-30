package com.mzsds.dao;

import java.util.List;

import com.mzsds.domain.FORUMBO;
import com.mzsds.util.DBUtil;

public class ForumDao {

	/**
	 * 从数据库获取所有模块的数据
	 * 
	 * @param type
	 *            模块名称
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<FORUMBO> selectAllModularList(String type) {
		String sqlSelectUserName = "Select * FROM " + type;
		List<FORUMBO> forumBOList = null;
		try {
			forumBOList = (List<FORUMBO>) DBUtil.getInstance()
					.query(sqlSelectUserName).getDOList(FORUMBO.class, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return forumBOList;
	}
	
	/**
	 * 获取某个时间点以后的数据
	 * 
	 * @param type
	 * @param time 某时间后的数据
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<FORUMBO> selectModularListAfterTime(String type,String time) {
		String sqlSelectUserName = "Select * FROM " + type + " WHERE AskTime > '"+ time +"' ORDER BY AskTime DESC";
		List<FORUMBO> forumBOList = null;
		try {
			forumBOList = (List<FORUMBO>) DBUtil.getInstance()
					.query(sqlSelectUserName).getDOList(FORUMBO.class, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return forumBOList;
	}
}
