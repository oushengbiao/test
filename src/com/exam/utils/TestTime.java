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
	 * 把总时间转化成秒数值
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
		timer.scheduleAtFixedRate(new TimerTask() { // TimerTask理解为需要反复执行的任务,执行这条代码的时候定时器启动
			
			@Override
			public void run() {

//				if (!flag1) {
//					// int mus = getAllTime();
//					// System.out.println("欧码？");
//					// System.out.println(mus);
//					if (mus < 60) {
//						mun = mus;
//						// System.out.println(mun);//这是对的。。
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
								if (seco == 0) {// 下面的方法会阻塞，一定要點確定后程序才會往下跑。。。
									JOptionPane.showMessageDialog(null, "考试时间到");
									examF.dispose();
									// System.out.println("上個方法會阻塞哦");
									flag = true;

								} else {
									seco--;
								}
							}
						}

						examF.label_3.setText(mun + ":" + seco + "");
//						System.out.println(mun + ":" + seco + "");

					}
				
			}// 因为这是一个   定时器线程，他永远都是一秒执行一次哦。。
		}, 0, 1000);
		
		
	}	
}

	