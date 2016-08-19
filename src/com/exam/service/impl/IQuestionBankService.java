package com.exam.service.impl;

import java.util.List;
import com.exam.bean.QuestionBank;

public interface IQuestionBankService {

	/**
	 * 初始化试卷,从题库中随机抽取100道题目生成试卷(如果是补考的话, 生成的试卷应该包含上次答错的题目)
	 */
	public List<QuestionBank> initExamPaper(boolean isFirstExam);
	
}
