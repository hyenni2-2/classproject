package com.mw.closet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mw.closet.service.ClosetDeleteService;

@RestController
@RequestMapping
public class ClosetDeleteController {
	
	@Autowired
	ClosetDeleteService delService;
	
	@GetMapping("/delete/{cIdx}")
	@CrossOrigin
	public int deleteClosetList(@PathVariable(name="cIdx") int cIdx) {
		System.out.println("cIdx : "+cIdx);
		return delService.closetDelete(cIdx);
	}

}
