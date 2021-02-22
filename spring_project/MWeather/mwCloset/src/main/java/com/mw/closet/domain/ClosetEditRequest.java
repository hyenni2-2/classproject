package com.mw.closet.domain;

import lombok.Data;

public class ClosetEditRequest {

	private int cIdx;
	private String imgData;
	private String ctext;
	
	public int getcIdx() {
		return cIdx;
	}

	public void setcIdx(int cIdx) {
		this.cIdx = cIdx;
	}



	public String getImgData() {
		return imgData;
	}



	public void setImgData(String imgData) {
		this.imgData = imgData;
	}



	public String getCtext() {
		return ctext;
	}



	public void setCtext(String ctext) {
		this.ctext = ctext;
	}

	@Override
	public String toString() {
		return "ClosetEditRequest [cIdx=" + cIdx + ", imgData=" + imgData + ", ctext=" + ctext + "]";
	}

	public ClosetWriteRequest getToCloset() {
		ClosetWriteRequest write = new ClosetWriteRequest();
		write.setCidx(cIdx);
		write.setImgData(imgData);
		write.setCtext(ctext);
		return write;
	}
}
