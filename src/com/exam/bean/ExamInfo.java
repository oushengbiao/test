package com.exam.bean;

import java.util.Date;

/**
 * 考试概要信息
 * @author Administrator
 *
 */
public class ExamInfo {
	//考生的基本信息，身份证号、姓名、手机号、最后一次考试分数
	Integer no;
	String ID_CARD;
	String realName;
	String mobile;
	Integer RESUME_TIME;
	Integer RIGHTCOUNT;
	Date time;
	String LOCATION;
	Integer FINAL_SCORE;
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getID_CARD() {
		return ID_CARD;
	}
	public void setID_CARD(String iD_CARD) {
		ID_CARD = iD_CARD;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getRESUME_TIME() {
		return RESUME_TIME;
	}
	public void setRESUME_TIME(Integer rESUME_TIME) {
		RESUME_TIME = rESUME_TIME;
	}
	public Integer getRIGHTCOUNT() {
		return RIGHTCOUNT;
	}
	public void setRIGHTCOUNT(Integer rIGHTCOUNT) {
		RIGHTCOUNT = rIGHTCOUNT;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getLOCATION() {
		return LOCATION;
	}
	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}
	public Integer getFINAL_SCORE() {
		return FINAL_SCORE;
	}
	public void setFINAL_SCORE(Integer fINAL_SCORE) {
		FINAL_SCORE = fINAL_SCORE;
	}
	
	
	
	

	
	
}
