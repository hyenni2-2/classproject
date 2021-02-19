package com.mw.closet.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.mysql.cj.xdevapi.JsonArray;

import lombok.Data;

// form 데이터 빈즈
@Data
public class ClosetWriteRequest {
	
	private int cIdx;
	private int memIdx;
	private String name;
	private List<Closet> cphoto; // ajax 통해 받을 데이터
	private String ctext; 
	private String imgData; // db로 보낼 데이터
	private String like;

	 // db로 보낼 데이터(직렬화)
	public String getimgData() {
		Gson gson = new Gson();
		String json = gson.toJson(cphoto);
		return json;
	}

	
}
	
