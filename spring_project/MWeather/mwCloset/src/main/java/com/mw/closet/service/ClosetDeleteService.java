package com.mw.closet.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mw.closet.dao.ClosetDao;

@Service
public class ClosetDeleteService {
	
	private ClosetDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int closetDelete(int idx) {
		
		dao = template.getMapper(ClosetDao.class);
		
		return dao.deleteCloset(idx);
		
	}
	
	

}
