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
			
			// 맵에 저장할 정보 : 시작열, 한페이지당 게시물개수, 현재 페이지
			Map<String, Object>listMap = new HashMap<String, Object>();
			listMap.put("start", startRow);
			listMap.put("count", onePageCnt);
			listMap.put("nowPage", page);
			System.out.println(startRow);
			System.out.println(onePageCnt);
			System.out.println(page);
			
			// 총 게시물 개수
			int totalClosetCount = dao.selectAllCount(listMap);
			System.out.println("게시물 총 개수:"+totalClosetCount);
			
			// 페이지에 맞는 리스트
			List<ClosetListRequest> closetList = dao.selectClosetList(listMap);
			System.out.println("클로제ㅅ리스트 페이지:"+closetList);
			
			// 매개변수로 넣기
			paging = new ClosetPage(page, totalClosetCount, onePageCnt, closetList, startRow, endRow);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return paging;
	}
	

}
