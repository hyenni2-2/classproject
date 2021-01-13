package com.aia.op.member.domain;

import java.sql.Timestamp;

public class Member {
	
	// 맵핑에 필요한 객체 만들기(db 테이블 데이터)
	private int idx;
	private String memberid;
	private String membername;
	private String password;
	private String memberphoto; // db에는 파일명이 필요하기 때문에 String 타입으로 저장
	private Timestamp regdate;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemberphoto() {
		return memberphoto;
	}
	public void setMemberphoto(String memberphoto) {
		this.memberphoto = memberphoto;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	public LoginInfo toLoginInfo() {
		return new LoginInfo(memberid, membername, memberphoto);
	}
		
	@Override
	public String toString() {
		return "Member [idx=" + idx + ", memberid=" + memberid + ", membername=" + membername + ", password=" + password
				+ ", memberphoto=" + memberphoto + ", regdate=" + regdate + "]";
	}
	

}
