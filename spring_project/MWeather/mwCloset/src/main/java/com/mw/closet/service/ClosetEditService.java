package com.mw.closet.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mw.closet.dao.ClosetDao;
import com.mw.closet.domain.ClosetEditRequest;
import com.mw.closet.domain.ClosetListRequest;
import com.mw.closet.domain.ClosetWriteRequest;


@Service
public class ClosetEditService {
	
	private ClosetDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	// cIdx로 멤버 셀렉해서 불러오기 -> 수정할 정보가 필요하므로
	public ClosetWriteRequest getClosetMember(int cIdx) {
		dao = template.getMapper(ClosetDao.class);
		return dao.getClosetMember(cIdx);
	}
	
	// 수정하는 기능 구현
	public int getEditCloset(int cIdx,ClosetEditRequest edit) {
		int result = 0;
		// 수정한 데이터를 저장하는 부분 (set으로)
		ClosetWriteRequest write = edit.getToCloset();
		try {
			dao = template.getMapper(ClosetDao.class);
			result = dao.updateCloset(write);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
