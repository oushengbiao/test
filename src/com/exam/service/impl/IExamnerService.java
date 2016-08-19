package com.exam.service.impl;

import com.exam.bean.ExamInfo;

public interface IExamnerService {

	/**
	 * 根据身份证号查询对应考生的真实姓名
	 */
	public String queryRealName(String cardID);
	
	/**
	 * 登陆
	 */
	public boolean login(String cardID, String realName);
	
	
	/**
	 * 显示某个考生的成绩 
	 */
	public Integer showScore(String cardID);
}
