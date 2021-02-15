package com.mw.closet.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import lombok.Data;


// tbl_closet DB 정보
@Data
public class Closet {

	private int memIdx;
	private String cName;
	private String cSrc;
	private int xPos;
	private int yPos;
	private int zPos;
	private Timestamp cRegdate;
	private String cText;
	
	public Date getToDate() {
		return new Date(this.cRegdate.getTime());
	}
}
