package com.aia.firstspring.member.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	// 메소드는 ViewName을 반환해야 한다. 반환 타입을 ModelAndView를 이용해서 반환
    @RequestMapping("/hello")
	public ModelAndView hello() {
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("member/hello"); 
    	// 경로 이름 : /WEB-INF/view/member/hello.jsp -> prefix를 지우고 뒷 부분을 넣음(member/hello), 
    	// .jsp는 suffix부분
    	mav.addObject("greeting", greeting());
    	
    	return mav;
    }

	private String greeting() {
		
		String result = "hello";
		
		int nowTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if(nowTime>=6 && nowTime<=10) {
			result = "Good morning";
		} else if(nowTime>=12 && nowTime<=15) {
			result="Take a lunch, huh?";
		} else if (nowTime>=18 && nowTime<=22) {
			result = "Good night.";
		}
		
		return result;
	}
	
}
