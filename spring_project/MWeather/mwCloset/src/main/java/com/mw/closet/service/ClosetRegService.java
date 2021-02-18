package com.mw.closet.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.JSONPObject;
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
			regRequest.setName(cName);
			// 나머지 요소 받아오기
			regRequest.getimgData();
			regRequest.getCtext();
			
			dao = template.getMapper(ClosetDao.class);
		    result = dao.insertClosetWrite(regRequest);
		} catch (Exception e) {
						e.printStackTrace();
					}
				return result;
			}		
		}


