package com.mw.closet.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import lombok.Data;

// form 데이터 빈즈
@Data
public class ClosetWriteRequest {
	
	private int memIdx;
	private String cName;
	private Map<Closet> cPhotoOut;
	private Timestamp cRegdate;
	private String cText; 
		
	public Date getToDate() {
		return new Date(this.cRegdate.getTime());
	}
	
}
	
