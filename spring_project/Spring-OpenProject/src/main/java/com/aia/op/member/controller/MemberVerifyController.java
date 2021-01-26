package com.aia.op.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aia.op.member.service.MemberVerifyService;

public class MemberVerifyController {
	
	@Autowired
	private MemberVerifyService verifyService;
	
	@RequestMapping("/member/verify")
	public void memberVerify(
			@RequestParam("idx") int idx,
			@RequestParam("code") String code,
			Model model
			) {
		
		model.addAttribute("result", verifyService.memberVerify(idx, code));
		// /WEB-INF/views/member/verify.jsp
		
	}

}
