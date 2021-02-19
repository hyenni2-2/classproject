package com.mw.closet.domain;

import lombok.Data;

@Data
public class ClosetEditRequest {

	private int cIdx;
	private String imgData;
	private String ctext;
	
	public ClosetWriteRequest getToCloset() {
		ClosetWriteRequest write = new ClosetWriteRequest();
		write.setImgData(imgData);
		write.setCtext(ctext);
		return write;
	}
}
