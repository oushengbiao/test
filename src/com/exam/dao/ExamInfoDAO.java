package com.exam.dao;

import javax.swing.JOptionPane;

import com.exam.service.ExamnerService;
import com.exam.ui.ResultFrame;
import com.exam.utils.DBUtil;
import com.exam.utils.TestTime;

public class ExamInfoDAO {
//	static int no=1;
	public static int y;
	public void getNoMax(){
		String sql="select nvl(max(NO),0) max from CAR_TOTAL_EXAM where 1=?";
		Object maxno=DBUtil.queryColumn("max", DBUtil.getConn(), sql, 1);
		y=Integer.parseInt(String.valueOf(maxno));
	}
/**
 * 交卷按钮往考试总表一条数据
 */
	public void insertTestTotal() {
		getNoMax();
		String idCard=ExamnerService.userid;
		int getScore=ExamDetailInfodao.score;//答对一题就加一//要
		int resumeTime=testInfor1();
		
//		System.out.println(resumeTime);
		String sql="insert into CAR_TOTAL_EXAM values(?,?,?,?,?,?,?)";
//		System.out.println(y);
//		System.out.println(idCard);
//		System.out.println(getScore);
//		System.out.println(resumeTime);
//		System.out.println(getScore);
//		System.out.println(idCard);
//		System.out.println(idCard);
		
		DBUtil.update(DBUtil.getConn(), sql, new Object[]{(y+1),idCard,getScore,resumeTime,getScore,null,null});
	
	}
	/**
	 * 获取所花时间
	 * @return
	 */
	private int testInfor1() {
		String timeStr=ExamnerService.examFrame.label_3.getText();
		String[] arr=timeStr.split(":");
		int currentTime=Integer.parseInt(arr[0])*60+Integer.parseInt(arr[1]);
//		System.out.println(currentTime);
		int resumeTime=new TestTime().getSencond()-currentTime;
		return resumeTime;
	
}
	/**
	 * 从总表中获取考试结果和成绩
	 */
public void showGetResult(ResultFrame resultF) {
	int getScore=ExamDetailInfodao.score;
	int resumeTime=testInfor1() ;
	int wrongCount=ExamDetailInfodao.wrongCount;
	resultF.lblNewLabel.setText(getScore+"");
	resultF.label_2.setText(wrongCount+"");
	int notDo=ExamnerService.examTitle.size()-getScore-wrongCount;
	resultF.label_4.setText(notDo+"");
	String munsec=senValFormat(resumeTime);
	int finalScore=getScore*20;
	String str=String.valueOf(finalScore);
	resultF.label_6.setText(str+"分");
//	System.out.println(str);
	senValFormat(resumeTime);
	resultF.label_8.setText(munsec);
	testISPassTip(finalScore);
}
	private void testISPassTip(int finalScore) {
		if(finalScore<90){
			JOptionPane.showMessageDialog(null,"本次考试不及格");
		}else{
			JOptionPane.showMessageDialog(null,"本次考试通过，恭喜！");
		}
		
	}
	private String senValFormat(int resumeTime) {
		int min=0;
		int sec=0;
		if(resumeTime>60){
			min=resumeTime/60;
			sec=resumeTime%60;
			return min+"分"+":"+sec+"秒";
		}else{
			sec=resumeTime;
			return  min+"分"+":"+sec+"秒";
		}
		
	}

}
