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
import com.mw.closet.domain.LoginInfo;

@Service
public class ClosetRegService {

	private ClosetDao dao;

	@Autowired
	private SqlSessionTemplate template;

	@Autowired
	RedisService redis;
	
	// 글 저장(멤버idx, 닉네임, 글내용)
	public int insertClosetWrite(ClosetWriteRequest regRequest, HttpServletRequest request) {
		int result = 0;
		try {
			// memidx, cname JSESSION ID로 가져오기
			 LoginInfo redisLogin = redis.getUserInformation(regRequest.getJsessionId());	
			regRequest.setMemIdx(redisLogin.getMemIdx());
			regRequest.setName(redisLogin.getMemName());
						
			// 세션값 가져오기(테스트용)
//			int memIdx = (int) request.getSession().getAttribute("memIdx");
//			String name = (String) request.getSession().getAttribute("name");
//			
//			regRequest.setMemIdx(memIdx);
//			regRequest.setName(name);
//			
//			regRequest.getMemIdx();
//			regRequest.getName();
			
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


