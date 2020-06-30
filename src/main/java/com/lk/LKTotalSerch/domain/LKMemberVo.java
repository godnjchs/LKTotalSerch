package com.lk.LKTotalSerch.domain;

import java.sql.Date;

import com.lk.LKTotalSerch.common.Encryption;

public class LKMemberVo {
	private String userId;
	private String pwd;
	private String userName;
	private Date regDate;
	
	
	public LKMemberVo() {
		
	}
	public LKMemberVo(String userId, String pwd, String name, Date regDate) {
		
		this.userId = userId;
		this.pwd = pwd;
		this.userName = name;
		this.regDate = regDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		;
		this.pwd =Encryption.sha256(pwd);
	}
	public String getName() {
		return userName;
	}
	public void setName(String name) {
		this.userName = name;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "LKMemberVo [userId=" + userId + ", pwd=" + pwd + ", name=" + userName + ", regDate=" + regDate + "]";
	}
	
}
