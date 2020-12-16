<%@page import="form.MemberData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
	
	MemberData data = (MemberData)request.getAttribute("memData");
	
	%>
	
	
<!DOCTYPE html>
<!-- HTML 바디 짜는 부분(사용자에게 보여주는(VIEW)부분)-->
<html>
<head>
<meta charset="UTF-8">
<title>Membership 페이지</title>
</head>
<body>

	<h1>Membership</h1>
	<table>
		<tr>
			<td>이름</td>
			<td><%= data.getUserid() %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%= data.getPw() %></td>
		</tr>
	</table>

</body>
</html>