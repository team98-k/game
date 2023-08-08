package com.game.vo;

public class UserInfoVO {
	private int uiNum;
	private String uiNmae;
	private String uiId;
	private String uiPwd;
	private String uiImgPath;
	private String desc;
	private String uiBirth;
	private String credat;
	private String cretim;
	private String lmodat;
	private String lmotim;
	private String active;
	public int getUiNum() {
		return uiNum;
	}
	public void setUiNum(int uiNum) {
		this.uiNum = uiNum;
	}
	public String getUiNmae() {
		return uiNmae;
	}
	public void setUiNmae(String uiNmae) {
		this.uiNmae = uiNmae;
	}
	public String getUiId() {
		return uiId;
	}
	public void setUiId(String uiId) {
		this.uiId = uiId;
	}
	public String getUiPwd() {
		return uiPwd;
	}
	public void setUiPwd(String uiPwd) {
		this.uiPwd = uiPwd;
	}
	public String getUiImgPath() {
		return uiImgPath;
	}
	public void setUiImgPath(String uiImgPath) {
		this.uiImgPath = uiImgPath;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getUiBirth() {
		return uiBirth;
	}
	public void setUiBirth(String uiBirth) {
		this.uiBirth = uiBirth;
	}
	public String getCredat() {
		return credat;
	}
	public void setCredat(String credat) {
		this.credat = credat;
	}
	public String getCretim() {
		return cretim;
	}
	public void setCretim(String cretim) {
		this.cretim = cretim;
	}
	public String getLmodat() {
		return lmodat;
	}
	public void setLmodat(String lmodat) {
		this.lmodat = lmodat;
	}
	public String getLmotim() {
		return lmotim;
	}
	public void setLmotim(String lmotim) {
		this.lmotim = lmotim;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "UserInfoVO [uiNum=" + uiNum + ", uiNmae=" + uiNmae + ", uiId=" + uiId + ", uiPwd=" + uiPwd
				+ ", uiImgPath=" + uiImgPath + ", desc=" + desc + ", uiBirth=" + uiBirth + ", credat=" + credat
				+ ", cretim=" + cretim + ", lmodat=" + lmodat + ", lmotim=" + lmotim + ", active=" + active + "]";
	}
}
