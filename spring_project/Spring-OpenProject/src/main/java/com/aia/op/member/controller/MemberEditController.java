package com.aia.op.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aia.op.member.domain.MemberEditRequest;
import com.aia.op.member.service.MemberEditService;

@Controller
@RequestMapping("/member/edit")
public class MemberEditController {
	
	@Autowired
	private MemberEditService editService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String editForm(
			@RequestParam("idx") int idx, // 폼에서 /member/edit?idx= 이부분의 파라미터를 가져오는 것
			Model model
			) {
		// Service -> MemberDao -> mapper 로 들어가고, mapper에서 Member를 반환 
		// 반환값을 뷰로 보내줌
		model.addAttribute("member", editService.getMember(idx));
		
		return "member/editForm";
	}
	
	@RequestMapping(method = RequestMethod.POST) 	
	public String editMember(
			MemberEditRequest editRequest,
			HttpServletRequest request,
			Model model
			) {
		// Service -> MemberDao : update -> mapper -> int
		// System.out.println(editRequest);
		
		model.addAttribute("result", editService.editMember(editRequest, request));
		
		return "member/edit";
	}

}
