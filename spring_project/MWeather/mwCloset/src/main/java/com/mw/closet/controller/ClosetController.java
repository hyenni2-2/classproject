package com.mw.closet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mw.closet.domain.Closet;
import com.mw.closet.domain.ClosetWriteRequest;
import com.mw.closet.domain.Codi;
import com.mw.closet.service.ClosetListService;
import com.mw.closet.service.ClosetRegService;
import com.mw.closet.service.CodiService;

@RestController
@RequestMapping("/list")
public class ClosetController {
	
	@Autowired
	ClosetListService listService;

	// List 가져오기
	@GetMapping     // /closet/list
	@CrossOrigin
	public List<ClosetWriteRequest> getClosetList(){
		return listService.getList();
	}

}
