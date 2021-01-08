package com.aia.firstspring.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	
	@RequestMapping("/cookie/make")
	public String makeCookie(HttpServletResponse response) {
		
		// 쿠키 생성 -> 응답으로 처리
		response.addCookie(new Cookie("auth", "test")); // 쿠키는 문자열 저장
		return "cookie/make"; // /WEB-INF/view/(prefix) cookie/make.jsp 이 경로를 만들어줌
	}
	
	@RequestMapping("/cookie/view")
	public String viewCookie(
			Model model,
		    HttpServletRequest request, // -> request객체 이용해서 cookies 배열 저장
		   //  @CookieValue("auth") String cookieAuth
		    @CookieValue(value="auth", defaultValue = "not") String cookieAuth,
		    @CookieValue(value = "uid", required = false) String uid
			) { // 모델 객체에 쿠키 정보를 담아줌
		
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			System.out.println(cookies[i].getName()+"="+cookies[i].getValue());
		}
		
		model.addAttribute("userName","최혜인");
		model.addAttribute("cookieInfo", cookies);
		model.addAttribute("cookieAuth", cookieAuth);
		model.addAttribute("uid", uid);
		
		return "cookie/view"; // /WEB-INF/view/cookie/view.jsp
	}

}
