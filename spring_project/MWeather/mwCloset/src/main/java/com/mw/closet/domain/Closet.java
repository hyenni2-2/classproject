package com.mw.closet.domain;

import java.sql.Timestamp;

import lombok.Data;

// tbl_closet DB 정보

public @Data class Closet {
	
	private int mem_idx;
	private String c_name;
	private String c_Dphoto;
	private String c_PhotoOut;
	private String c_MerDb;
	private String c_Text;
	private int c_Like;
	private int c_Bmk;
	private Timestamp c_Date;
	private String c_Ip;
	
	// 페이징을 위한 생성자
	public Closet(int mem_idx, String c_name, String c_PhotoOut, int c_Like, int c_Bmk) {
		this.mem_idx = mem_idx;
		this.c_name = c_name;
		this.c_PhotoOut = c_PhotoOut;
		this.c_Like = c_Like;
		this.c_Bmk = c_Bmk;
	}
}
