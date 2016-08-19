package com.exam.service;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import com.exam.bean.QuestionBank;
import com.exam.service.impl.IQuestionBankService;
import com.exam.ui.ExamFrame;

public class QuestionBankService implements IQuestionBankService {
	public static int x=0;
	@Override
	public List<QuestionBank> initExamPaper(boolean isFirstExam) {
		if(isFirstExam){
			
		}

		return null;
	}
	//显示一道题目信息。
	public void showTitle(ArrayList<QuestionBank> examTitle, ExamFrame examFrame) {
		examFrame.label.setText("<html><body>"+(x+1)+examTitle.get(x).getQCON());
	
		examFrame.lblA.setText(examTitle.get(x).getFirOption());
		examFrame.lblB.setText(examTitle.get(x).getSecOption());
		examFrame.lblC.setText(examTitle.get(x).getThiOption());
		examFrame.lblD.setText(examTitle.get(x).getFouOption());
		ImageIcon image=new ImageIcon(examTitle.get(x).getIMGURL());
//		image.setImage(image);
		Dimension dimension=examFrame.label_1.getMaximumSize();
		image.setImage(image.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT));
		
//		image.;
		examFrame.label_1.setIcon(image);
//		x++;
		if(examTitle.get(x).getFlag()==0){
			ExamFrame.btnC.setVisible(false);
			ExamFrame.btnD.setVisible(false);
		}else{
			ExamFrame.btnC.setVisible(true);
			ExamFrame.btnD.setVisible(true);
		}
	}

}
