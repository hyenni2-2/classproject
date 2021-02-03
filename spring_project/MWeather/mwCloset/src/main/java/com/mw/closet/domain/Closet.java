package com.mw.closet.domain;

import java.sql.Timestamp;

import lombok.Data;


// tbl_closet DB 정보
@Data
public class Closet {
	
	private int cIdx;
	private int memIdx;
	private String cName;
	private String cDphoto;
	private String cPhotoOut;
	private String cMerDb;
	private String cText;
	private int cLikeCnt;
	private int cBmkCnt;
	private Timestamp cDate;
	private String cIp;

	

}
