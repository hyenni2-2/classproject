<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
session.invalidate(); // 현재 세션을 소멸 -> 속성까지 소멸 loginInfo 데이터는 삭제가 된다.
response.sendRedirect(request.getContextPath());  // /op 
%>