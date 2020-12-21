<%@page import="form.JoinData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

JoinData joinData = new JoinData();

String id = request.getParameter("userid");
String pw = request.getParameter("pw");
String name = request.getParameter("username");
String photo = request.getParameter("userphoto");

joinData.setId(id);
joinData.setName(pw);
joinData.setPw(pw);
joinData.setPhoto(photo);

request.setAttribute("joinData", joinData);

%>

<jsp:forward page="joinView.jsp"/>