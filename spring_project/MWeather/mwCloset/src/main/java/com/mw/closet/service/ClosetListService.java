package com.mw.closet.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mw.closet.dao.ClosetDao;
import com.mw.closet.domain.Closet;
import com.mw.closet.domain.ClosetLike;
import com.mw.closet.domain.ClosetListRequest;
import com.mw.closet.domain.ClosetPage;
import com.mw.closet.domain.ClosetWriteRequest;

@Service
public class ClosetListService {
	
	private ClosetDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	// 전체 리스트 불러오기
	public List<ClosetWriteRequest> getList(){
		
		List<ClosetWriteRequest> list = null; 

			dao = template.getMapper(ClosetDao.class);
			list = dao.selectAll();
			System.out.println(list);

		return list;
	}
	
	// 페이지네이션 처리
	public ClosetPage closetPaging(int page, HttpServletRequest request) {
		ClosetPage paging = null;
		
		try {
			dao = template.getMapper(ClosetDao.class);
			
			int onePageCnt = 30;
			int startRow = (page-1)*onePageCnt;
			int endRow = (startRow+onePageCnt)-1;
			int memIdx = (int) request.getSession().getAttribute("memIdx");
			
			
			// 맵에 저장할 정보 : 시작열, 한페이지당 게시물개수, 현재 페이지, 게시물 당 좋아요 개수
			Map<String, Object>listMap = new HashMap<String, Object>();
			listMap.put("start", startRow);
			listMap.put("count", onePageCnt);
			listMap.put("nowPage", page);
			System.out.println(startRow);
			System.out.println(onePageCnt);
			System.out.println(page);
			// System.out.println(likeCnt);
			
			// 총 게시물 개수
			int totalClosetCount = dao.selectAllCount(listMap);
			System.out.println("게시물 총 개수:"+totalClosetCount);
			
			// 내 좋아요 개수
			// int myLikeCnt=dao.getMyLikeCnt(cidx, memIdx);
			// listMap.put("myLikeCnt", myLikeCnt);
			int myLikeCnt = 0;
			
			// 페이지에 맞는 리스트
			List<ClosetListRequest> closetList = dao.selectClosetList(listMap);
			System.out.println("클로젯리스트 페이지:"+closetList);
			
			// 매개변수로 넣기
			paging = new ClosetPage(page, totalClosetCount, onePageCnt, closetList, startRow, endRow, myLikeCnt);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return paging;
	}
	
	// 게시물 상세페이지 불러오는 메서드
	public ClosetListRequest getClosetView(int cidx, HttpServletRequest request) {
		
		ClosetListRequest getList = null;
		int memIdx = (int) request.getSession().getAttribute("memIdx");
		System.out.println("상세페이지:"+cidx+","+memIdx);
			try {
				dao = template.getMapper(ClosetDao.class);
				getList = dao.getListView(cidx);
				// 내 좋아요 개수 카운트하기
				int myLikeCnt = dao.getMyLikeCnt(cidx, memIdx);
				getList.setMyLikeCnt(myLikeCnt);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return getList;
	}
	
	// 게시물 좋아요 입력하는 메서드
	public String likeInsert(ClosetLike likeRequest) {
		String like ="N";
		
		try {
			int cidx = likeRequest.getCidx();
			int memIdx = likeRequest.getMemIdx();
			
			dao = template.getMapper(ClosetDao.class);
			// 좋아요 등록(1:등록, 2:삭제)
			if(likeRequest.getLikeChk()==1) {
				// 좋아요 테이블에 insert
				if(dao.insertLike(likeRequest)>0) {
					// 게시물 좋아요 수 update
					if(dao.updateClosetLike(1,likeRequest.getCidx())> 0) {
						like = "submit:Y";
					}
				}
			// 좋아요 삭제(뒤에 -1로 해서 xml에서 update할 때 더함
			} else {
				if(dao.deleteLike(cidx,memIdx) > 0) {
					if(dao.updateClosetLike(-1,likeRequest.getCidx()) > 0) {
						 like = "delete:Y";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return like;
	}


}
