package com.mw.closet.dao;

import java.util.List;
import java.util.Map;

import com.mw.closet.domain.Closet;
import com.mw.closet.domain.ClosetListRequest;
import com.mw.closet.domain.ClosetWriteRequest;
import com.mw.closet.domain.Codi;

public interface ClosetDao {

	// 전체 리스트 출력
	List<ClosetWriteRequest> selectAll();
    // 코디 메인화면 출력
	List<Codi> getCodiSet();
	// 클로젯 게시판 등록
	int insertClosetWrite(ClosetWriteRequest regRequest);
	// 게시물 삭제
	int deleteCloset(int idx);
	// 클로젯 게시물 개수 확인
	int selectAllCount(Map<String, Object> listMap);
	// 페이지에 맞는 리스트 출력
	List<ClosetListRequest> selectClosetList(Map<String, Object> listMap);
	
	

}
