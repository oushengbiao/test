package com.exam.service.impl;

import com.exam.bean.ExamInfo;

public interface IExamnerService {

	/**
	 * �������֤�Ų�ѯ��Ӧ��������ʵ����
	 */
	public String queryRealName(String cardID);
	
	/**
	 * ��½
	 */
	public boolean login(String cardID, String realName);
	
	
	/**
	 * ��ʾĳ�������ĳɼ� 
	 */
	public Integer showScore(String cardID);
}
