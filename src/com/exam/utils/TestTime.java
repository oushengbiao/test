package com.exam.utils;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import com.exam.ui.ExamFrame;
public class TestTime {
	public static Timer timer;
	boolean flag;
	int mun=1;
	int seco;
	/**
	 * ����ʱ��ת��������ֵ
	 * @return
	 */
	public int getSencond(){
		return mun*60+seco;
		
	}
	public TestTime(){}
	/**
	 * Launch the application.
	 */
	public TestTime(ExamFrame examFrame){
		final ExamFrame examF=examFrame;
		timer=new Timer();
		timer.scheduleAtFixedRate(new TimerTask() { // TimerTask���Ϊ��Ҫ����ִ�е�����,ִ�����������ʱ��ʱ������
			
			@Override
			public void run() {

//				if (!flag1) {
//					// int mus = getAllTime();
//					// System.out.println("ŷ�룿");
//					// System.out.println(mus);
//					if (mus < 60) {
//						mun = mus;
//						// System.out.println(mun);//���ǶԵġ���
//					} else {
//						mun = mus / 60 * 60;
//						seco = mus % 60;
//					}
//					initial();
//					flag1 = true;
//				} else {
					if (!flag) {
						if (mun >= 0) {
							if (mun > 0) {
								if (seco > 0 & seco < 60) {
									seco--;
								} else if (seco == 0) {
									seco = 59;
									--mun;
								}
							} else {
								if (seco == 0) {// ����ķ�����������һ��Ҫ�c�_�������ŕ������ܡ�����
									JOptionPane.showMessageDialog(null, "����ʱ�䵽");
									examF.dispose();
									// System.out.println("�ς�����������Ŷ");
									flag = true;

								} else {
									seco--;
								}
							}
						}

						examF.label_3.setText(mun + ":" + seco + "");
//						System.out.println(mun + ":" + seco + "");

					}
				
			}// ��Ϊ����һ��   ��ʱ���̣߳�����Զ����һ��ִ��һ��Ŷ����
		}, 0, 1000);
		
		
	}	
}

	