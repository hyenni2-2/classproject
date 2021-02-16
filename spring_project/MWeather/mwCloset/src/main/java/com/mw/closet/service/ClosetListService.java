package com.mw.closet.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mw.closet.dao.ClosetDao;
import com.mw.closet.domain.Closet;
import com.mw.closet.domain.ClosetWriteRequest;

@Service
public class ClosetListService {
	
	private ClosetDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public List<ClosetWriteRequest> getList(){
		
		List<ClosetWriteRequest> list = null; 

			dao = template.getMapper(ClosetDao.class);
			list = dao.selectAll();
			System.out.println(list);

		return list;
	}

}
