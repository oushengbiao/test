package com.exam.service.impl;

import java.util.List;
import com.exam.bean.QuestionBank;

public interface IQuestionBankService {

	/**
	 * ��ʼ���Ծ�,������������ȡ100����Ŀ�����Ծ�(����ǲ����Ļ�, ���ɵ��Ծ�Ӧ�ð����ϴδ�����Ŀ)
	 */
	public List<QuestionBank> initExamPaper(boolean isFirstExam);
	
}
