package com.mw.closet.domain;

import lombok.Data;

@Data
public class ClosetListRequest {
	
	private int idx;
	private String memIdx;
	private String name;
	private String photo;
	private int likecnt;
	private String text;
	
}
