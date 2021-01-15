package com.aia.op.member.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 로그인 여부를 확인하고
		// 로그인 상태 -> return true
		// 비로그인 상태 -> return false, 로그인 페이지로 redirect
	HttpSession session = request.getSession(false); 
	// Session이 null일 때 그대로 유지하기 위해서 false 전달
	if(session != null && session.getAttribute("loginInfo")!=null) {
		return true;
	}
	    // 로그인폼으로 이동
	    response.sendRedirect(request.getContextPath()+"/member/login");
		return false;
	}


}
