package com.exam.bean;

public class QuestionBank {
	//题库:题目编号，题目信息，题目类型，选项。。
	Integer ID_Q;
	String QCON;
	Integer flag;
	String firOption;
	String secOption;
	String thiOption;
	String fouOption;
	String IMGURL;
	String ANSWER;
	public String getANSWER() {
		return ANSWER;
	}
	public void setANSWER(String aNSWER) {
		ANSWER = aNSWER;
	}
	public Integer getID_Q() {
		return ID_Q;
	}
	public void setID_Q(Integer iD_Q) {
		ID_Q = iD_Q;
	}
	public String getQCON() {
		return QCON;
	}
	public void setQCON(String qCON) {
		QCON = qCON;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getFirOption() {
		return firOption;
	}
	public void setFirOption(String firOption) {
		this.firOption = firOption;
	}
	public String getSecOption() {
		return secOption;
	}
	public void setSecOption(String secOption) {
		this.secOption = secOption;
	}
	public String getThiOption() {
		return thiOption;
	}
	public void setThiOption(String thiOption) {
		this.thiOption = thiOption;
	}
	public String getFouOption() {
		return fouOption;
	}
	public void setFouOption(String fouOption) {
		this.fouOption = fouOption;
	}
	public String getIMGURL() {
		return IMGURL;
	}
	public void setIMGURL(String iMGURL) {
		IMGURL = iMGURL;
	}
	@Override
	public String toString() {
		return "QuestionBank [ID_Q=" + ID_Q + ", QCON=" + QCON + ", flag=" + flag + ", firOption=" + firOption
				+ ", secOption=" + secOption + ", thiOption=" + thiOption + ", fouOption=" + fouOption + ", IMGURL="
				+ IMGURL + ", ANSWER=" + ANSWER + "]";
	}
	

}
