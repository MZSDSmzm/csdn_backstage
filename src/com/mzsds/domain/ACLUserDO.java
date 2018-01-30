package com.mzsds.domain;  

public class ACLUserDO {

	/** 用户编号UserID */ 
	public int userID;  

	/** 设置，用户编号UserID */ 
	public void setUserID(int oUserID) { userID = oUserID; } 

	/** 获取，用户编号UserID */ 
	public int getUserID() { return userID; } 
	


	/** 用于登陆系统后显示的用户名称 */ 
	public String userName;  

	/** 设置，用于登陆系统后显示的用户名称 */ 
	public void setUserName(String oUserName) { userName = oUserName; } 

	/** 获取，用于登陆系统后显示的用户名称 */ 
	public String getUserName() { return userName; } 
	


	/** 登陆系统密码 */ 
	public String userPassword;  

	/** 设置，登陆系统密码 */ 
	public void setUserPassword(String oUserPassword) { userPassword = oUserPassword; } 

	/** 获取，登陆系统密码 */ 
	public String getUserPassword() { return userPassword; } 
	


	/** 登陆状态 */ 
	public int loginStatus;  

	/** 设置，登陆状态 */ 
	public void setLoginStatus(int oLoginStatus) { loginStatus = oLoginStatus; } 

	/** 获取，登陆状态 */ 
	public int getLoginStatus() { return loginStatus; } 
	


	/** 用户状态： 1 正常；2 禁用；4 删除 */ 
	public int status;  

	/** 设置，用户状态： 1 正常；2 禁用；4 删除 */ 
	public void setStatus(int oStatus) { status = oStatus; } 

	/** 获取，用户状态： 1 正常；2 禁用；4 删除 */ 
	public int getStatus() { return status; } 
	


	/**  */ 
	public String userPhoneNumber;  

	/** 设置， */ 
	public void setUserPhoneNumber(String oUserPhoneNumber) { userPhoneNumber = oUserPhoneNumber; } 

	/** 获取， */ 
	public String getUserPhoneNumber() { return userPhoneNumber; } 
	


	/**  */ 
	public int userSex;  

	/** 设置， */ 
	public void setUserSex(int oUserSex) { userSex = oUserSex; } 

	/** 获取， */ 
	public int getUserSex() { return userSex; } 
	


	/**  */ 
	public java.util.Date addTime;  

	/** 设置， */ 
	public void setAddTime(java.util.Date oAddTime) { addTime = oAddTime; } 

	/** 获取， */ 
	public java.util.Date getAddTime() { return addTime; } 
	




}

