//package com.mw.closet.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.mw.closet.service.ClosetDeleteService;
//
//@RestController
//@RequestMapping("/delete/{cIdx}")
//public class ClosetDeleteController {
//	
//	@Autowired
//	ClosetDeleteService delService;
//	
//	public int deleteClosetList(@PathVariable(name="cIdx")) {
//		return delService.closetDelete(cIdx);
//	}
//
//}
