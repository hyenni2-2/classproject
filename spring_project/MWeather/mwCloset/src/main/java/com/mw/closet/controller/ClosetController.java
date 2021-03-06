package com.mw.closet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mw.closet.domain.ClosetLike;
import com.mw.closet.domain.ClosetListRequest;
import com.mw.closet.domain.ClosetPage;
import com.mw.closet.domain.ClosetWriteRequest;
import com.mw.closet.service.ClosetListService;
import com.mw.closet.service.RedisService;

@RestController
@RequestMapping
public class ClosetController {
	
	@Autowired
	ClosetListService listService;
	
	@Autowired
	RedisService redisService;

	//페이징한 List 가져오기
	@GetMapping("/list/{cPage}")     // /closet/list
	@CrossOrigin
	public ClosetPage getClosetList(@PathVariable("cPage") int cPage, HttpServletRequest request){
		System.out.println("page:"+cPage+", "+request);
		return listService.closetPaging(cPage, request);
	}
	
	// 상세페이지 보여주는 메서드
		@GetMapping("/list/view/{cIdx}/{jsessionId}")
		@CrossOrigin
		public ClosetListRequest closetView(@PathVariable("cIdx") int cIdx, @PathVariable("jsessionId") String OriginJsessionId, ClosetListRequest listRequest,HttpServletRequest request) {
			System.out.println("cIdx:"+cIdx);
			
			return listService.getClosetView(cIdx, OriginJsessionId, listRequest,request);
		}

	
	// 좋아요 처리하는 메서드
	@PostMapping("/list/like")
	@CrossOrigin
	public String insertLike(ClosetLike likeRequest) {
		System.out.println("리퀘스트값:"+likeRequest);
		return listService.likeInsert(likeRequest);
	}
	
}