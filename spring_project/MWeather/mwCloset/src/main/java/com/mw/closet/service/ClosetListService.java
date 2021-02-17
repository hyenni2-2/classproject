package com.mw.closet.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mw.closet.dao.ClosetDao;
import com.mw.closet.domain.Closet;
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
//	public ClosetPage closetPaging(ClosetPage page) {
//		ClosetPage paging = null;
//		
//		try {
//			dao = template.getMapper(ClosetDao.class);
//			
//			int nowPage = 1;
//			int onePageCnt = 9;
//			int startRow = (nowPage-1)*onePageCnt;
//			int eneRow = (startRow+onePageCnt)-1;
//			
//		} catch(Exception e) {
//			
//		}
//		
//	}
	

}
