package com.mw.closet.domain;

import java.util.List;

import lombok.Data;

@Data
public class ClosetListRequest {
	
	private int cidx;
	private int memIdx;
	private String name;
	private String cphoto;
	private int clikecnt; // 모든 사용자가 좋아요 한 개수
	private String ctext;
	private int myLikeCnt; // 내가 좋아요 한 개수

}
