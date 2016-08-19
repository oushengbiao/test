package com.exam.bean;

/**
 * 考试详情信息
 * @author Administrator
 *
 */
public class ExamDetailInfo {
	String ID_CARD;
	Integer id_q;
	Integer istrue;
	Integer no;//参考考试总表
	public String getID_CARD() {
		return ID_CARD;
	}
	public void setID_CARD(String iD_CARD) {
		ID_CARD = iD_CARD;
	}
	public Integer getId_q() {
		return id_q;
	}
	public void setId_q(Integer id_q) {
		this.id_q = id_q;
	}
	public Integer getIstrue() {
		return istrue;
	}
	public void setIstrue(Integer istrue) {
		this.istrue = istrue;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	

}
