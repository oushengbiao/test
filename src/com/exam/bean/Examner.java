package com.exam.bean;

/**
 * 考生身份证号，姓名，电话，性别，所报驾校名称。。
 * @author Administrator
 *
 */
public class Examner {
	String id_CARD;
	String exam_NAME;
	long tel;
	String sex;
	String shoolNAME;
	public String getId_CARD() {
		return id_CARD;
	}
	public void setId_CARD(String id_CARD) {
		this.id_CARD = id_CARD;
	}
	public String getEXAM_NAME() {
		return exam_NAME;
	}
	public void setEXAM_NAME(String eXAM_NAME) {
		exam_NAME = eXAM_NAME;
	}
	public long getTel() {
		return tel;
	}
	public void setTel(long tel) {
		this.tel = tel;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getShoolNAME() {
		return shoolNAME;
	}
	public void setShoolNAME(String shoolNAME) {
		this.shoolNAME = shoolNAME;
	}
	
	
 
}
