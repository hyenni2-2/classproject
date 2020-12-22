<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
 Enumeration<String> attrNames = application.getAttributeNames();
 
 while(attrNames.hasMoreElements()) { // 불리언 타입으로 반환
	 
	 String attrName = attrNames.nextElement();
   Object value = application.getAttribute(attrName);
	 
	 out.println(attrName +"=" + value.toString() + "<br>");
 }
 
%>

</body>
</html>