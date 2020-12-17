<%@page import="util.CookieBox"%>
<%@page import="form.MemberData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 자바 코드 짜는 부분 -->
<%

// beans 객체 생성
MemberData memberData = new MemberData();

// 사용자로부터 데이터 받은 거 넣기. 로그인의 경우 ID는 세션으로 해도되지만(해야하지만) PW는 하면안됨! 
String userId = request.getParameter("userid");
int pw = Integer.parseInt(request.getParameter("pw"));

String chk = request.getParameter("chk");

if(chk!=null && chk.equals("on") && userId != null && !userId.isEmpty()) {
	// 쿠키 생성해서 저장
	// uid = userId
	
	response.addCookie(CookieBox.createCookie("uid", userId, "/", 60*60*24*365));
} else {
	response.addCookie(CookieBox.createCookie("uid", userId, "/", 0));
}

// beans에 저장하기
memberData.setUserid(userId);
memberData.setPw(pw);

// view.js에 beans 객체 전달하기
request.setAttribute("memData", memberData);

%>

<jsp:forward page="memberView.jsp"/>