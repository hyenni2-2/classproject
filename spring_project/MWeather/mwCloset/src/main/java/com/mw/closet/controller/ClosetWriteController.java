package com.mw.closet.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mw.closet.domain.ClosetWriteRequest;
import com.mw.closet.domain.LoginInfo;
import com.mw.closet.service.ClosetRegService;
import com.mw.closet.service.RedisService;

@RestController
@RequestMapping
public class ClosetWriteController {
	@Autowired
	ClosetRegService writeService;
	
	@Autowired
	RedisService redisService;
	
	// 글쓰기
	@PostMapping("/write")  // /closet/write
	@CrossOrigin
	public int closetWrite(@RequestBody ClosetWriteRequest regRequest,HttpServletRequest request) {
		System.out.println("레그리퀘스트:"+regRequest);
		return writeService.insertClosetWrite(regRequest, request);
	}
	


}
