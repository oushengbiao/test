package com.exam.service;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.exam.bean.ExamDetailInfo;
import com.exam.bean.QuestionBank;
import com.exam.dao.ExamDetailInfodao;
import com.exam.dao.ExamnerDAO;
import com.exam.dao.Questiondao;
import com.exam.ui.EntryFrame;
import com.exam.ui.ExamFrame;
import com.exam.utils.DBUtil;
import com.exam.utils.TestTime;

public class ExamnerService {
	static EntryFrame entry;
	ExamnerDAO examnerDAO;
	static Questiondao questiondao;
	public static ExamFrame examFrame;
	public static QuestionBankService questionBankService;
	public static String userid;
	public static ArrayList<QuestionBank> examTitle;

	public ExamnerService() {
		entry = new EntryFrame();
		examnerDAO = new ExamnerDAO();
		questiondao = new Questiondao();
		examFrame=new ExamFrame();
		questionBankService=new QuestionBankService();
	}

	public static void main(String[] args) {
//		System.out.println("索引："+QuestionBankService.x);
		final ExamnerService examner = new ExamnerService();
		examFrame.closeWindow(examFrame);
		// EventQueue.invokeLater(new Runnable() {
		// public void run() {
		entry.setVisible(true);
		entry.button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userid = examner.entry.textField_1.getText();// 用户输入的身份证号
				// System.out.println(userid);//ok
				boolean islog = examner.examnerDAO.login(userid);
				if (islog) {
					entry.dispose();
					//所有的题目集合
					examTitle=Questiondao.innitialPapar();
					new ExamDetailInfodao().getNoMax();
					questionBankService.showTitle(examTitle,examFrame);
//					QuestionBankService.x++;
					examFrame.setVisible(true);
					new TestTime(examFrame);
					
					

				} else {
					JOptionPane.showMessageDialog(entry, "信息不对");
				}
			}
		});
		entry.button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				examner.entry.textField_1.setText(null);
				
			}
		});

		// }
		// });
	}

}
