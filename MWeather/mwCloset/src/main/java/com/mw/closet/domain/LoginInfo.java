package com.mw.closet.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginInfo implements Serializable {
	private int memIdx=0;
	private String memName;
	
	public LoginInfo(int memIdx, String memName) {
		this.memIdx = memIdx;
		this.memName = memName;
	}

}
