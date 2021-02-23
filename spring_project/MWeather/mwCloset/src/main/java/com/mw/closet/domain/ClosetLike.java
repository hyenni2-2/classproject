package com.mw.closet.domain;

import lombok.Data;

@Data
public class ClosetLike {
	
	private int cidx;
	private int memIdx;
	private int likeChk; // 1번: 등록 2번: 삭제
	
}
