package com.game.vo;

public class ClassInfoVO {
	private int ciNum;
	private String ciName;
	private String ciDesc;
	private String ciProf;
	private int score;
	
	public int getCiNum() {
		return ciNum;
	}
	public void setCiNum(int ciNum) {
		this.ciNum = ciNum;
	}
	public String getCiName() {
		return ciName;
	}
	public void setCiName(String ciName) {
		this.ciName = ciName;
	}
	public String getCiDesc() {
		return ciDesc;
	}
	public void setCiDesc(String ciDesc) {
		this.ciDesc = ciDesc;
	}
	public String getCiProf() {
		return ciProf;
	}
	public void setCiProf(String ciProf) {
		this.ciProf = ciProf;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "ClassInfoVO [ciNum=" + ciNum + ", ciName=" + ciName + ", ciDesc=" + ciDesc + ", ciProf=" + ciProf
				+ ", score=" + score + "]";
	}
}
