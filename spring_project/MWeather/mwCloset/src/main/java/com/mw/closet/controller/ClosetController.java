package com.mw.closet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

@RestController
@RequestMapping
public class ClosetController {
	
	@Autowired
	ClosetListService listService;

	//페이징한 List 가져오기
	@GetMapping("/list/{page}")     // /closet/list
	@CrossOrigin
	public ClosetPage getClosetList(@PathVariable("page") int page, HttpServletRequest request){
		System.out.println("page:"+page+", "+request);
		return listService.closetPaging(page, request);
	}
	
	// 상세페이지 보여주는 메서드
	@GetMapping("/list/view/{cidx}")
	@CrossOrigin
	public ClosetListRequest closetView(@PathVariable("cidx") int cidx, HttpServletRequest request) {
		System.out.println("cIdx:"+cidx);
		return listService.getClosetView(cidx, request);
	}
	
	
	// 좋아요 처리하는 메서드
	@PostMapping("/list/like")
	@CrossOrigin
	public String insertLike(ClosetLike likeRequest) {
		System.out.println("리퀘스트값:"+likeRequest);
		return listService.likeInsert(likeRequest);
	}
		

}
