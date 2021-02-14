package com.mw.closet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mw.closet.domain.Closet;
import com.mw.closet.service.ClosetListService;

@RestController
@RequestMapping("/list")
public class ClosetListController {
	
	@Autowired
	ClosetListService listService;
	
	@GetMapping
	@CrossOrigin
	public List<Closet> getClosetList(){
		return listService.getList();
	}
	
	

}
