package com.mw.closet.dao;

import java.util.List;
import java.util.Map;

import com.mw.closet.domain.Closet;
import com.mw.closet.domain.ClosetEditRequest;
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
	int deleteCloset(int cIdx);
	// 클로젯 게시물 개수 확인
	int selectAllCount(Map<String, Object> listMap);
	// 페이지에 맞는 리스트 출력
	List<ClosetListRequest> selectClosetList(Map<String, Object> listMap);
	// 회원 정보 조회 : cIdx로 조회
	ClosetWriteRequest getClosetMember(int cIdx);
	// 게시글 업데이트
	int updateCloset(ClosetWriteRequest write);
	
	

}
