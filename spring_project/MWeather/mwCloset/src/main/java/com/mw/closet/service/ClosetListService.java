package com.mw.closet.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mw.closet.dao.ClosetDao;
import com.mw.closet.domain.Closet;
import com.mw.closet.domain.ClosetLike;
import com.mw.closet.domain.ClosetListRequest;
import com.mw.closet.domain.ClosetPage;
import com.mw.closet.domain.ClosetWriteRequest;
import com.mw.closet.domain.LoginInfo;



@Service
public class ClosetListService {
	
	private ClosetDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Autowired
	RedisService redisService;
	
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

			
			// 페이지에 맞는 리스트
			List<ClosetListRequest> closetList = dao.selectClosetList(listMap);
			System.out.println("클로젯리스트 페이지:"+closetList);
			
			// 매개변수로 넣기
			paging = new ClosetPage(page, totalClosetCount, onePageCnt, closetList, startRow, endRow);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return paging;
	}
	
	// 게시물 상세페이지 불러오는 메서드
	public ClosetListRequest getClosetView(int cIdx, String jsessionId, ClosetWriteRequest writeRequest) {
		
		ClosetListRequest getList = null;
		
		// jsessionid로 memIdx 가져오기
		LoginInfo redisLogin = redisService.getUserInformation(jsessionId);
		
		int memIdx = 0;
		
		// 로그인 체크하기
		if(redisLogin!=null ) {
			memIdx = redisLogin.getMemIdx();
			String cName = redisLogin.getMemName();
			
			writeRequest.setMemIdx(redisLogin.getMemIdx());
			writeRequest.setName(redisLogin.getMemName());
		}

		System.out.println("상세페이지:"+cIdx+","+ memIdx);
			try {
				dao = template.getMapper(ClosetDao.class);
				getList = dao.getListView(cIdx);
			
				// 내 좋아요 개수 카운트하기
				if(memIdx>0) {
					int myLikeCnt = dao.getMyLikeCnt(cIdx, memIdx);
					getList.setMyLikeCnt(myLikeCnt);
					System.out.println("겟리스트:"+getList);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return getList;
	}
	
	// 게시물 좋아요 입력하는 메서드
	public String likeInsert(ClosetLike likeRequest) {
		String like ="N";
		
		// jsessionid로 memIdx 가져오기
		LoginInfo redisLogin = redisService.getUserInformation(likeRequest.getJsessionId());
		
		try {
			int cIdx = likeRequest.getCIdx();
			int memIdx = 0;
			
		if(redisLogin!=null) {
			memIdx = redisLogin.getMemIdx();
		}
			likeRequest.setMemIdx(memIdx);
			int likeChk = likeRequest.getLikeChk();
			
			dao = template.getMapper(ClosetDao.class);
			// 좋아요 등록(1:등록, 2:삭제) -> 리스트 테이블에 좋아요 여부 입력
			if(likeChk==1) {
				// 좋아요 테이블에 insert
				if(dao.insertLike(likeRequest)>0) {
					// 게시물 좋아요 수 update
					if(dao.updateClosetLike(1,cIdx)> 0) {
						// 리스트 테이블에 좋아요 체크 입력
						like = "submit:Y";
					}
				}
			// 좋아요 삭제(뒤에 -1로 해서 xml에서 update할 때 더함
			} else {
				if(dao.deleteLike(cIdx,memIdx) > 0) {
					if(dao.updateClosetLike(-1,cIdx) > 0) {
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
