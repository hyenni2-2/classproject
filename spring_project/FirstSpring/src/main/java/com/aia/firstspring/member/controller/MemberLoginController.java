package com.aia.firstspring.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aia.firstspring.member.domain.LoginRequest;

@Controller
@RequestMapping("/member/login") // 공통경로라 위에 씀
public class MemberLoginController {
	
	// @RequestMapping(value = "/member/login", method = RequestMethod.GET)
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getLoginForm() {
		return new ModelAndView("member/loginForm"); // setViewName과 동일, 
	}
	
	// @RequestMapping(value = "/member/login", method = RequestMethod.POST)
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView login(
                            @RequestParam("uid") String uid, 
                            @RequestParam("pw") String pw,
                            HttpServletRequest request, LoginRequest loginRequest) {
	
		// 사용자의 파라미터 값을 받는 방법
		// 1. HttpSevletRequest 객체 이용
		// 2. @RequestParam(폼의 name 속성)
		// 3. 커맨드객체(Beans) 이용

		// login("cool", "1111") 처리와 같음 (RequestParam이)
		System.out.println(loginRequest);
		
		String userId = request.getParameter("uid");
		String userPw = request.getParameter("pw");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/login"); // 로그인 되었을 때 보이는 페이지
	    mav.addObject("uid", uid);
	    mav.addObject("pw", pw);
	    mav.addObject("userId", userId);
	    mav.addObject("userPw", userPw);
	    // mav.addObject("loginRequest", loginRequest); -> 커맨드 객체여서 따로 요청하지 않아도 공유된다.
	

		return mav;
	}

}
