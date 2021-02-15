package com.mw.closet.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

// form 데이터 빈즈
@Data
public class ClosetWriteRequest {
	
	private int memIdx;
	private String cName;
	private List<Closet> cPhotoOut;
	private Timestamp cRegdate;
	private String cText; 
		
	public Date getToDate() {
		return new Date(this.cRegdate.getTime());
	}
	
}
	
