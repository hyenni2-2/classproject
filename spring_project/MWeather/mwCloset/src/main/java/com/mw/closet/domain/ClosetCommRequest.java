package com.mw.closet.domain;

import lombok.Data;

@Data
public class ClosetCommRequest {
	
	private int memIdx;
	private String cName;
	private String cmtText;
	private int cIdx;

}
