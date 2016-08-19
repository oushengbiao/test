package com.exam.ui;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.StandardBorderPainter;
import org.jvnet.substance.button.ClassicButtonShaper;
import org.jvnet.substance.painter.StandardGradientPainter;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;
import org.jvnet.substance.watermark.SubstanceBubblesWatermark;

import com.exam.dao.ExamDetailInfodao;
import com.exam.dao.ExamInfoDAO;
import com.exam.service.ExamnerService;
import com.exam.service.QuestionBankService;
import com.exam.utils.TestTime;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;

import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Timer;
import java.awt.event.ActionEvent;

public class ExamFrame extends JFrame {
	public JLabel label;
	public JLabel lblA;
	public JLabel lblB;
	public JLabel lblC;
	public JLabel lblD;
	public JButton button_1;// 下一题
	public JLabel label_1;
	public static String command;// 四个按钮哪个被按下
	JButton button_2;
	boolean flag = true;
	public static JButton btnNewButton ;
	public static int prefixX;//记录x的值
	public static JButton btnB;

	public static JButton btnC ;

	public static JButton btnD ;
	public JLabel label_3;//剩余时间
	int innitalx;
	static ResultFrame resultF;
	public static ArrayList<JButton> list100;//100个button的集合。。
	public ExamFrame(ResultFrame resultF){
		resultF=new ResultFrame();
	}
	// public static void main(String[] args) {
	// try {
	// UIManager.setLookAndFeel(new SubstanceLookAndFeel());
	// JFrame.setDefaultLookAndFeelDecorated(true);
	// JDialog.setDefaultLookAndFeelDecorated(true);
	// SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());
	//// SubstanceLookAndFeel.setSkin(new EmeraldDuskSkin());
	// SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());
	// SubstanceLookAndFeel.setCurrentWatermark(new
	// SubstanceBubblesWatermark());
	// SubstanceLookAndFeel.setCurrentBorderPainter(new
	// StandardBorderPainter());
	// SubstanceLookAndFeel.setCurrentGradientPainter(new
	// StandardGradientPainter());
	// //SubstanceLookAndFeel.setCurrentTitlePainter(new FlatTitePainter());
	// } catch (Exception e) {
	// System.err.println("Something went wrong!");
	// }
	// ExamFrame ef = new ExamFrame();
	//
	// }

	public ExamFrame() {
		try {
			UIManager.setLookAndFeel(new SubstanceLookAndFeel());
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());
			// SubstanceLookAndFeel.setSkin(new EmeraldDuskSkin());
			SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());
			SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBubblesWatermark());
			SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());
			SubstanceLookAndFeel.setCurrentGradientPainter(new StandardGradientPainter());
			// SubstanceLookAndFeel.setCurrentTitlePainter(new
			// FlatTitePainter());
		} catch (Exception e) {
			System.err.println("Something went wrong!");
		}
		
		setBounds(400, 100, 600, 600);
		setTitle("\u9A7E\u9A76\u5458\u79D1\u76EE\u4E00\u8003\u8BD5");
		getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel pane2 = new JPanel();
		pane2.setBorder(new TitledBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u7B54\u9898\u4FE1\u606F",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
				"\u7B54\u9898\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(pane2, BorderLayout.SOUTH);
		pane2.setLayout(new GridLayout(5, 20, 0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);

		label = new JLabel("\u9898\u76EE\u4FE1\u606F");
		label.setVerticalAlignment(SwingConstants.TOP);
//		label.setm

		lblA = new JLabel("A\u9009\u9879");

		lblB = new JLabel("B\u9009\u9879");

		lblC = new JLabel("C\u9009\u9879");

		lblD = new JLabel("D\u9009\u9879");

		label_1 = new JLabel("");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblA, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblB, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblC, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblD, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(192, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(416, Short.MAX_VALUE)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 608, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblA, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
					.addGap(2)
					.addComponent(lblB, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(lblC, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblD, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);

		// btnNewButton.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// }
		// });
		 btnNewButton = new JButton("A");

		 btnB = new JButton("B");

		 btnC = new JButton("C");

		 btnD = new JButton("D");
		ActionLis actionLis = new ActionLis();

		btnNewButton.addActionListener(actionLis);
		btnB.addActionListener(actionLis);
		btnC.addActionListener(actionLis);
		btnD.addActionListener(actionLis);

		JLabel lblNewLabel = new JLabel("\u9009\u62E9\uFF1A");

		JButton button = new JButton("\u4E0A\u4E00\u9898");
		button.addActionListener(new LastButtonLis());
		button_1 = new JButton("\u4E0B\u4E00\u9898");

		button_1.addActionListener(new ActionListener() {
//			int initialX=ExamFrame.prefixX;
			public void actionPerformed(ActionEvent e) {
				if (flag) {
					QuestionBankService.x++;
					if (QuestionBankService.x < ExamnerService.examTitle.size()) {
						
						ExamnerService.questionBankService.showTitle(ExamnerService.examTitle,
								ExamnerService.examFrame);
//						prefixX=QuestionBankService.x;
						if(QuestionBankService.x>=innitalx){
//							System.out.println(QuestionBankService.x);
////							System.out.println(ExamFrame.prefixX+1);
//							System.out.println(prefixX);
							prefixX=QuestionBankService.x;
							innitalx=prefixX;
//							System.out.println(prefixX);
							ExamFrame.btnNewButton.setEnabled(true);
							ExamFrame.btnB.setEnabled(true);
							ExamFrame.btnC.setEnabled(true) ;
							ExamFrame.btnD.setEnabled(true);
						}
						if (command != null) {
							ExamDetailInfodao.insertDetailTable(command);
							prefixX=QuestionBankService.x;
//							System.out.println(prefixX);
							command=null;
						}
					} else if (QuestionBankService.x == ExamnerService.examTitle.size()) {
						if (command != null) {
							ExamDetailInfodao.insertDetailTable(command);
							prefixX=QuestionBankService.x;
//							System.out.println(prefixX);
//							ExamDetailInfodao.insertDetailTable(command);
							flag=false;

						}
						QuestionBankService.x=ExamnerService.examTitle.size()-1;
						// QuestionBankService.x++;
						// button_1.setEnabled(false);//设置按钮成灰色。。。
						// button_2.setEnabled(true);

					} else {
					}
				}
			}

		});

		// button_1.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// if(QuestionBankService.x<ExamnerService.examTitle.size()){
		// ExamnerService.questionBankService.showTitle(ExamnerService.examTitle,ExamnerService.examFrame);
		// }
		// }
		// });

		JLabel label_2 = new JLabel("\u5269\u4F59\uFF1A");

		label_3 = new JLabel("45\uFF1A00");

		JCheckBox checkBox = new JCheckBox("\u7B54\u9898\u540E\u4E0B\u4E00\u9898");

		button_2 = new JButton("\u4EA4\u5377");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExamnerService.examFrame.dispose();
				TestTime.timer.cancel();
				resultF=new ResultFrame();
				resultF.setVisible(true);
				ExamInfoDAO examInfoDAO=new ExamInfoDAO();
				examInfoDAO.insertTestTotal();
				ExamInfoDAO.y++;
				examInfoDAO.showGetResult(resultF);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(
						gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_panel_1.createSequentialGroup().addGap(25).addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(gl_panel_1.createSequentialGroup()
																.addComponent(lblNewLabel)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnNewButton)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnB)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnC).addGap(6).addComponent(btnD)
																.addPreferredGap(ComponentPlacement.RELATED, 181,
																		Short.MAX_VALUE)
																.addComponent(label_2)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(label_3).addGap(86))
														.addGroup(gl_panel_1.createSequentialGroup()
																.addComponent(button)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 69,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED, 170,
																		Short.MAX_VALUE)
																.addComponent(checkBox).addGap(18)
																.addComponent(button_2).addGap(31)))));
		gl_panel_1
				.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(btnC)
										.addComponent(btnB).addComponent(btnNewButton).addComponent(btnD)
										.addComponent(lblNewLabel).addComponent(label_2).addComponent(label_3))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(button)
										.addComponent(button_1).addComponent(checkBox).addComponent(button_2))
								.addContainerGap(214, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);
		list100=new ArrayList<JButton>();
		for (int x = 1; x <= 100; x++) {
			final JButton button_x = new JButton(x + "");//100个变量分别指向一百个对象。。。
			list100.add(button_x);
			button_x.addActionListener(new ActionListener() {
				String test=button_x.getText();
				int value=Integer.parseInt(test);
				@Override
				public void actionPerformed(ActionEvent e) {
					QuestionBankService.x=value-1;
					ExamnerService.questionBankService.showTitle(ExamnerService.examTitle,
							ExamnerService.examFrame);
					if(!String.valueOf(value).equals(button_x.getText())){
						btnNewButton.setEnabled(false);
						btnB.setEnabled(false);
						btnC.setEnabled(false);
						btnD.setEnabled(false);
					}else{
						btnNewButton.setEnabled(true);
						btnB.setEnabled(true);
						btnC.setEnabled(true);
						btnD.setEnabled(true);
						
					}
				}
			});
			button_x.setMargin(new Insets(0, 0, 0, 0));// 可以设置文本与按钮周边的距离。
			// button_x.setText(x+"");
			pane2.add(button_x);
		}
		// setVisible(true);
	}
//	static{

	public void closeWindow(ExamFrame examFrame) {
		examFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				TestTime.timer.cancel();
			}
		});
		
	}
		
//	}
}


class ActionLis implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		ExamFrame.command = e.getActionCommand();

	}

}
class LastButtonLis implements ActionListener{
	boolean currFlag=true;
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println(QuestionBankService.x);
		QuestionBankService.x--;
//		System.out.println(QuestionBankService.x);
		if(QuestionBankService.x>=0)
		ExamnerService.questionBankService.showTitle(ExamnerService.examTitle,
				ExamnerService.examFrame);
		else{
			QuestionBankService.x=0;
		}
//		System.out.println(QuestionBankService.x);
		if(QuestionBankService.x<=ExamFrame.prefixX){
//			System.out.println(ExamFrame.prefixX);
			ExamFrame.btnNewButton.setEnabled(false);
			ExamFrame.btnB.setEnabled(false);
			ExamFrame.btnC.setEnabled(false) ;
			ExamFrame.btnD.setEnabled(false);
			
		}
			
			
		
	}
	
}
