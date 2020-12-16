<%@page import="form.FormData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

 // 자바 코드 처리

 // 1. 사용자로부터 받은 데이터를 beans에 저장하고,
 //    beans 객체를 생성
 FormData formData = new FormData();

 // 사용자로부터 데이터를 받아온다. Request 객체 사용
 String userName = request.getParameter("userName");
 String job = request.getParameter("job");
 String[] interest = request.getParameterValues("interest");
 
 // beans에 데이터를 바인딩(저장)
 formData.setName(userName); // 이름 저장
 formData.setJob(job); // 직업 저장
 formData.setInterest(interest); // 관심사 저장
 
 // view.js로 beans 객체를 전달(공유)
 request.setAttribute("data", formData);
 
%>

<jsp:forward page="view.jsp"/>