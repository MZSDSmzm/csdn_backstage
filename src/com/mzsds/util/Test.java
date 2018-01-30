package com.mzsds.util;

public class Test {

	public static void main(String[] args) throws Exception {
		//更新SDVR的WAP和BO项目的代码
		UpdateBOAndWAPDomain();
	}

	
	public static void UpdateBOAndWAPDomain() throws Exception{
		//mac版
		//String bo = CodeGenerator.createMySQLDBCode("mshare_baseinfomation", "com.mzsds.domain", "/Users/MAC/Desktop/javaworkspace/sdsebo/src/com/mzsds/domain", true);		
		//window版
		String bo = CodeGenerator.createMySQLDBCode("acl_user", "com. mzsds.domain", "D:\\myworkspace\\csdn\\src\\com\\mzsds\\domain", true);
		System.out.println(bo);
	}
	
}



