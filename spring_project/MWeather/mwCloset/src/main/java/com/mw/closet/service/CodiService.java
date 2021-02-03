package com.mw.closet.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mw.closet.dao.ClosetDao;
import com.mw.closet.domain.Closet;
import com.mw.closet.domain.Codi;

@Service
public class CodiService {
	
	private ClosetDao dao;
	
	@Autowired
	SqlSessionTemplate template;

	public List<Codi> getCodiList() {
		
		List<Codi> codiList = null;

		try {
		dao = template.getMapper(ClosetDao.class);
		codiList = dao.getCodiSet();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return codiList;
	}
	
	

}
