package com.mzsds.dao;

import com.mzsds.domain.ACLUserBO;
import com.mzsds.util.DBUtil;
import com.mzsds.util.DataTable;

public class LoginDao {

	/**
	 * 用户名查询，正常：1；失效：2；不存在：0
	 * 
	 * @param username
	 * @return
	 */
	public static int selectUserName(String username) {
		String sqlSelectUserName = "Select Status FROM acl_user WHERE UserName = '"
				+ username + "' AND status != 4 ";
		int returnMessage = 0;
		try {
			DataTable dt = DBUtil.getInstance().query(sqlSelectUserName);
			if (dt.isNull()) {
				returnMessage = 0;
			} else if ((int) dt.getCell(0, 0) == 2) {
				returnMessage = 2;
			} else {
				returnMessage = 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnMessage;
	}

	/**
	 * 用户名密码匹配，匹配：true；不匹配：false
	 * 
	 * @param username
	 * @return returnMessage
	 */
	public static boolean selectPasswordByUsernameAndPassword(String username,
			String password) {
		String sqlSelectPassword = "Select UserID FROM acl_user WHERE UserName = '"
				+ username
				+ "' AND UserPassword = '"
				+ password
				+ "' AND status = 1 ";
		boolean returnMessage = false;
		try {
			DataTable dt = DBUtil.getInstance().query(sqlSelectPassword);
			if (dt.isNull()) {
				returnMessage = false;
			} else {
				returnMessage = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnMessage;
	}

	/**
	 * 查询登陆状态。0：未登录；1：登陆
	 * 
	 * @param username
	 * @return returnNumber
	 */
	public static int selectLoginStatusByName(String username) {
		int returnNumber = 0;
		String sqlSelectPassword = "SELECT LoginStatus FROM acl_user WHERE UserName = '"
				+ username + "' AND status = 1 ";
		try {
			String string = DBUtil.getInstance().queryReturnSingleString(
					sqlSelectPassword);
			returnNumber = Integer.parseInt(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnNumber;
	}

	/**
	 * 修改登陆状态。
	 * 
	 * @param loginStatus 登陆状态：0，未登录；1：登陆
	 * @return returnNumber
	 */
	public static boolean updateLoginStatus(int loginStatus, String username) {
		int n = 0;
		String sqlSelectPassword = "UPDATE acl_user SET LoginStatus = "
				+ loginStatus + " WHERE UserName = '" + username + "' ";
		try {
			n = DBUtil.getInstance().execute(sqlSelectPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	/**
	 * 根据用户名查询用户信息，存放在aclUserBO中
	 * 
	 * @param username
	 * @return aclUserBO
	 * @throws Exception
	 */
	public static ACLUserBO selectUserByName(String username) throws Exception {
		String sqlSelect = "SELECT UserID,UserName FROM acl_user WHERE UserName = '"
				+ username + "' AND status != 4 ";
		ACLUserBO aclUserBO = (ACLUserBO) DBUtil.getInstance().query(sqlSelect)
				.getDO(0, ACLUserBO.class, true);
		return aclUserBO;
	}
}
