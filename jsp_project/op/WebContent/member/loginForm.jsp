<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    CookieBox cookieBox = new CookieBox(request);
    
    String saveId = cookieBox.exists("uid") ? cookieBox.getValue("uid"):"";
    String checked = cookieBox.exists("uid") ? "checked":"";
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="styleSheet" href="<%= request.getContextPath() %>/css/default.css">
<style>
</style>
</head>
<body >


	<%@ include file="/include/header.jsp"  %>
		
	<%@ include file="/include/nav.jsp"  %>
	
	<div class="contents">
		<h2 class="content_title">Login Form/h2>
		<hr>
		<div class="content">
		
		</div>
	</div>
	
	<%@ include file="/include/footer.jsp" %>

	
	
	
	
	
	
	
	
	


</body>
</html>