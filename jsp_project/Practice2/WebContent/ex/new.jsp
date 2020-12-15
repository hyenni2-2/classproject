<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Date" %>
    
    <%
    Date now = new Date();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
hello : <%=now %> 
</h1>
<h1>
컨텍스트 경로 : <%=request.getContextPath() %>
</h1>

</body>
</html>