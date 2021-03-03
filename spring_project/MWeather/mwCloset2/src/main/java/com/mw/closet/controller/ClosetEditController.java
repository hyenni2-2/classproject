package com.mw.closet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mw.closet.domain.ClosetEditRequest;
import com.mw.closet.domain.ClosetWriteRequest;
import com.mw.closet.service.ClosetEditService;

@RestController
@RequestMapping
public class ClosetEditController {
	
	@Autowired
	ClosetEditService editService;
	
	@PostMapping("/edit")
	public int editCloset(@RequestBody ClosetEditRequest edit) {
		System.out.println(edit);
		return editService.getEditCloset(edit);
	}
}
