package com.mw.closet.domain;

import lombok.Data;

@Data
public class ClosetLike {
	
	private int cIdx;
	private int memIdx;
	private int likeChk; // 1번: 등록 2번: 삭제
	private String jsessionId; // jsession 가져오기
	
}
