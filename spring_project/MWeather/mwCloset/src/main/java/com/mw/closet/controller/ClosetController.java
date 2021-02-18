package com.mw.closet.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public ClosetPage getClosetList(@PathVariable("page") int page){
		System.out.println("page:"+page);
		return listService.closetPaging(page);
	}
	
	
	
	

}
