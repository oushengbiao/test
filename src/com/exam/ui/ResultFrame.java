package com.exam.ui;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import com.exam.dao.ExamDetailInfodao;
import com.exam.service.ExamnerService;
import com.exam.service.QuestionBankService;

import javax.swing.JButton;

public class ResultFrame extends JFrame{
	/**
	 * lblNewLabel：正确、label_2错误、label_4未答、label_6得分、label_8答题时间
	 */
	public JLabel lblNewLabel;
	public JLabel label_2;
	public JLabel label_4;//
	public JLabel label_6;
	public JLabel label_8;
	public ResultFrame() {
//		try {
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		setBounds(400, 100, 600, 600);
		
		JLabel label = new JLabel("\u6B63\u786E\u7B54\u9898\uFF1A");
		
		lblNewLabel = new JLabel("0");
		
		JLabel label_1 = new JLabel("\u9519\u8BEF\u7B54\u9898\uFF1A");
		
		label_2 = new JLabel("0");
		
		JLabel label_3 = new JLabel("\u672A\u7B54\u9898\uFF1A");
		
		label_4 = new JLabel("0");
		
		JButton button = new JButton("\u9000\u51FA");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		JButton button_1 = new JButton("\u518D\u6B21\u505A\u9898");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExamnerService.examTitle.clear();
				QuestionBankService.x=0;
				ExamDetailInfodao.x=0;
				ExamDetailInfodao.score=0;
				ExamnerService.main(new String[]{"a"});
				ExamFrame.resultF.dispose();
			}
		});
		
		JLabel label_5 = new JLabel("\u6700\u7EC8\u5F97\u5206\uFF1A");
		
		label_6 = new JLabel("0");
//		label_6.setText("50");
		
		JLabel  label_7 = new JLabel("\u7B54\u9898\u65F6\u95F4\uFF1A");
		
		label_8 = new JLabel("0");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(175)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_7)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(button_1)
								.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
								.addComponent(button)
								.addGap(182))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_5)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
											.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(281, GroupLayout.PREFERRED_SIZE)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(130)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(label_4))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(label_6))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_7)
						.addComponent(label_8))
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(288, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
