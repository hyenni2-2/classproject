package com.mw.closet.service;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mw.closet.dao.ClosetDao;
import com.mw.closet.domain.Closet;
import com.mw.closet.domain.ClosetWriteRequest;

@Service
public class ClosetRegService {

	private ClosetDao dao;

	@Autowired
	private SqlSessionTemplate template;

	// 글 저장(멤버idx, 닉네임, 글내용)
	public int insertClosetWrite(ClosetWriteRequest regRequest, HttpServletRequest request) {
		int result = 0;
		try {
			// memidx, cname session에서 가져오기
			int memIdx = (int) request.getSession().getAttribute("memIdx");
			String cName = (String) request.getSession().getAttribute("cName");

			regRequest.setMemIdx(memIdx);
			regRequest.setCName(cName);
			// 나머지 요소 받아오기
			regRequest.getCPhotoOut();
			regRequest.getToDate();
			regRequest.getCText();
			// 이미지 정보 저장되어있는지 확인
			if(regRequest.getCPhotoOut()!=null) {
				Iterator<Closet> itr = regRequest.getCPhotoOut().iterator();
				while(itr.hasNext()) {
					@SuppressWarnings("unchecked")
					List<Closet> imgList = (List<Closet>) itr.next();
					System.out.println("imgList:"+imgList);
					
						dao = template.getMapper(ClosetDao.class);
						result = dao.insertClosetWrite(regRequest);
				}
			} 
		}
			catch (Exception e) {
						e.printStackTrace();
					}
				return result;
			}		
		}

// 이미지 배열 저장
//	public int insertList(ClosetWriteRequest regRequest, HttpServletRequest request) {
//		int result = 0;
//		// 배열에 정보 담겨 있는지 확인
//		if (regRequest.getCPhotoOut() != null) {
//			// iterator 통해서 조회
//			Iterator<Closet> itr = regRequest.getCPhotoOut().iterator();
//			while(itr.hasNext()) {
//				// closet 타입의 리스트로 반환
//				@SuppressWarnings("unchecked")
//				List<Closet> imgList = (List<Closet>) itr.next();
//				System.out.println("imgList:"+imgList);
//				
//				try {
//					dao = template.getMapper(ClosetDao.class);
//					result = dao.insertClosetImg(regRequest);
//				}
//			}
//			
//
//		}
