package com.aia.op.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.op.member.domain.MemberRegRequest;
import com.aia.op.member.service.MemberRegService;


@Controller
@RequestMapping("/member/reg") // 이 경로에 GET방식으로 들어온다.
public class MemberRegController {
	
	@Autowired
	private MemberRegService regService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getRegForm() {
		return "member/memberRegForm";
	}
 
	@RequestMapping(method = RequestMethod.POST)
	public String memberReg(
			@ModelAttribute("regData") MemberRegRequest regRequest, // beans 데이터가 넘어오게 된다.
			HttpServletRequest request,
		    Model model
			) {
		System.out.println(regRequest);
		int result = regService.memberReg(regRequest, request);
		
		model.addAttribute("result", result);
		
		return "member/memberRegView";
	}
}
