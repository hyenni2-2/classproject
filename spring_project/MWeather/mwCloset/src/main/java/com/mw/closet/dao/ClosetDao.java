package com.mw.closet.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mw.closet.domain.Closet;
import com.mw.closet.domain.ClosetEditRequest;
import com.mw.closet.domain.ClosetLike;
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
	int updateCloset(ClosetWriteRequest writere);
	// 상세페이지 가져오기
	ClosetListRequest getListView(int cidx);
	// 좋아요 입력
	int insertLike(ClosetLike likeRequest);
	// 공통 테이블에 좋아요 수 update
	int updateClosetLike(int i, int cidx);
	// 좋아요 삭제
	int deleteLike(@Param("cidx") int cidx, @Param("memIdx") int memIdx);
	// 내 좋아요 수 가져오기
	int getMyLikeCnt(@Param("cidx") int cidx, @Param("memIdx") int memIdx);


}
