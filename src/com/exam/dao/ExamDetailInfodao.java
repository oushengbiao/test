package com.exam.dao;


import java.util.ArrayList;

import javax.swing.JButton;

import com.exam.bean.ExamDetailInfo;
import com.exam.bean.QuestionBank;
import com.exam.service.ExamnerService;
import com.exam.service.QuestionBankService;
import com.exam.ui.ExamFrame;
import com.exam.utils.DBUtil;

public class ExamDetailInfodao {
	public static int x=0;
	static int y=0;
	public static int score;
	static int wrongCount;
	/**
	 * ��ȡ������е����noֵ
	 */
	public void getNoMax(){
		String sql="select nvl(max(NO),0) max from CAR_EXAM_DETAIL where 1=?";
		Object maxno=DBUtil.queryColumn("max", DBUtil.getConn(), sql, 1);
		y=Integer.parseInt(String.valueOf(maxno));
	}
	
/**
 * ���   ��һ��  ������ϸ���в���һ������
 * @param command
 */
	/*
	 * 1��ͨ����̬����examTitle�õ�������Ŀ�ļ������õ���׼�𰸺���Ŀ��š�
	 * 1:����ѡ��İ�ťֵ�Ƚϱ�׼�𰸣������ȷ���Ͱ�ExamDetailInfo���е�istrue��Ϊ1������0��
	 * 2���õ����֤�š�
	 * 4���������ݡ���
	 */
	public static void insertDetailTable(String command) {
		ExamDetailInfo Detail=new ExamDetailInfo();
		ArrayList<QuestionBank> examTitle=ExamnerService.examTitle;
		String answer=examTitle.get(x).getANSWER();
		Integer quetionno=examTitle.get(x).getID_Q();
		if(command.equals(answer)){
			Detail.setIstrue(1);
			JButton button=ExamFrame.list100.get(QuestionBankService.x-1);
//			System.out.println(button);
			button.setText(button.getText()+"��");
			score++;
		}else{
			Detail.setIstrue(0);
			JButton button=ExamFrame.list100.get(QuestionBankService.x-1);
			button.setText(button.getText()+"x");
			wrongCount++;
		}
		Detail.setID_CARD(ExamnerService.userid);//�������֤
		Integer istrue=Detail.getIstrue();
		Detail.setId_q(quetionno);
		String card=Detail.getID_CARD();
		String sql="insert into CAR_EXAM_DETAIL values(?,?,?,?)";
		DBUtil.update(DBUtil.getConn(), sql,(y+1),istrue,quetionno,Detail.getID_CARD());
		x++;
		y++;
	}

}
