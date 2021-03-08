package com.mw.closet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mw.closet.domain.ClosetEditRequest;
import com.mw.closet.domain.ClosetListRequest;
import com.mw.closet.domain.ClosetWriteRequest;
import com.mw.closet.service.ClosetEditService;

@RestController
@RequestMapping
public class ClosetEditController {
	
	@Autowired
	ClosetEditService editService;
	
	
	
	
	@GetMapping("/edit/{cIdx}")
	@CrossOrigin
	public ClosetListRequest getClosetMember(@PathVariable("cIdx") int cIdx) {
		return editService.getClosetMember(cIdx);
	}
	
	
	@PostMapping("/edit")
	@CrossOrigin
	public int editCloset(@RequestBody ClosetEditRequest edit) {
		System.out.println(edit);
		return editService.getEditCloset(edit);
	}
}
