package com.mw.closet.domain;

import lombok.Data;

@Data
public class ClosetListRequest {
	
	private int cidx;
	private int memIdx;
	private String name;
	private String cphoto;
	private int clikecnt;
	private String ctext;
	
	
	public ClosetListRequest getEditInfo() {
		ClosetListRequest cReq = new ClosetListRequest();
		cReq.setCphoto(cphoto);
		cReq.setCtext(ctext);
		return cReq;
	}

}
