package com.aia.firstspring.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberSearchController {

	@RequestMapping("/member/search") // search라는 요청이 들어오면 아래 메서드가 보임
	public String searchMember(
			// @RequestParam("p") int pageNumber,
			@RequestParam(value = "p", defaultValue = "1") int pageNumber,
			// @RequestParam("uid") String uid,
			@RequestParam(value = "uid", required = false) String uid,
			@RequestParam(value = "name", required = false) String name 
			) {
		// http://localhost:8080/.../(컨텍스트 경로 들어감)member/search?p=1&uid=cool&name=COOl
		
		System.out.println("p : " +pageNumber);
		System.out.println("uid : "+uid);
		System.out.println("name : " + name);

		
		return "member/search"; // view 이름 -> view의 경로
	}
	
	
	
}
