package com.mzsds.dao;

import java.util.List;

import com.mzsds.domain.ACLUserBO;
import com.mzsds.util.DBUtil;

public class UserDao {

	/**
	 * 从数据库获取所有有效的用户信息
	 * 
	 * @return List<ACLUserBO> aclUserBOList
	 */
	@SuppressWarnings("unchecked")
	public static List<ACLUserBO> selectAllUser() {
		String sqlSelectUserName = "Select UserID,UserName,UserSex,UserPhoneNumber,Status,AddTime FROM acl_user WHERE status != 4 ";
		List<ACLUserBO> aclUserBOList = null;
		try {
			aclUserBOList = (List<ACLUserBO>) DBUtil.getInstance()
					.query(sqlSelectUserName).getDOList(ACLUserBO.class, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aclUserBOList;
	}

	/**
	 * 根据ID删除用户
	 * 
	 * @param userID
	 *            用户ID
	 * @return
	 */
	public static boolean deleteUserByID(int userID) {
		String sqlDeleteUser = "DELETE FROM acl_user WHERE UserID = " + userID;
		int n = 0;
		try {
			n = DBUtil.getInstance().execute(sqlDeleteUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	/**
	 * 用户信息ID查询
	 * 
	 * @param userID
	 * @return
	 */
	public static ACLUserBO selectUserByID(int userID) {
		String sqlSelectUserName = "Select * FROM acl_user WHERE UserID = "
				+ userID;
		ACLUserBO aclUserBO = null;
		try {
			aclUserBO = (ACLUserBO) DBUtil.getInstance()
					.query(sqlSelectUserName).getDO(0, ACLUserBO.class, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aclUserBO;
	}

	public static boolean insertOrUpdateUser(ACLUserBO aclUserBO) {
		ACLUserBO aclUserBO2 = selectUserByID(aclUserBO.getUserID());
		String sqlInsert = "";
		if (aclUserBO2 == null) {
			sqlInsert = "INSERT INTO acl_user(UserID,UserName,UserPassword,UserSex,UserPhoneNumber,LoginStatus,Status,AddTime) VALUES(null,'"
					+ aclUserBO.userName
					+ "', '"
					+ aclUserBO.userPassword
					+ "', "
					+ aclUserBO.userSex
					+ " ,'"
					+ aclUserBO.userPhoneNumber
					+ "',1,"
					+ aclUserBO.status
					+ ",'" + aclUserBO.addTime2 + "')";
			System.out.println(sqlInsert);
		} else {
			sqlInsert = "UPDATE acl_user SET UserName='" + aclUserBO.userName
					+ "',UserPassword='" + aclUserBO.userPassword
					+ "',UserSex=" + aclUserBO.userSex + ",UserPhoneNumber='"
					+ aclUserBO.userPhoneNumber + "',LoginStatus=1,Status="
					+ aclUserBO.status + ",AddTime='" + aclUserBO.addTime2
					+ "' WHERE UserID = " + aclUserBO.userID;
		}

		int n = 0;
		try {
			n = DBUtil.getInstance().execute(sqlInsert);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}
