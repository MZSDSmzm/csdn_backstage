package com.mzsds.service;

import java.util.List;

import com.mzsds.dao.UserDao;
import com.mzsds.domain.ACLUserBO;

public class UserService {

	/**
	 * 获取所有的有效用户信息
	 * 
	 * @return
	 */
	public static List<ACLUserBO> getAllUserList() {
		List<ACLUserBO> aclUserBOList = UserDao.selectAllUser();
		return aclUserBOList;
	}

	/**
	 * 根据ID删除用户
	 * 
	 * @param userID  用户ID
	 * @return
	 */
	public static boolean removeUser(String userID) {
		return UserDao.deleteUserByID(Integer.parseInt(userID));
	}

	/**
	 * 用户信息ID查询
	 * 
	 * @param userID
	 * @return
	 */
	public static ACLUserBO checkUser(String userID) {
		ACLUserBO aclUserBO = UserDao.selectUserByID(Integer.parseInt(userID));
		return aclUserBO;
	}

	/**
	 * 添加用户
	 * 
	 * @param aclUserBO
	 * @return
	 */
	public static boolean addUser(ACLUserBO aclUserBO) {
		return UserDao.insertOrUpdateUser(aclUserBO);
	}
}
