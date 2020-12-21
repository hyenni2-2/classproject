<%@page import="form.JoinData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	
	JoinData data = (JoinData)request.getAttribute("joinData");
	
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join View</title>
</head>
<body>

	<h1>JOIN CHECK</h1>
	<table>
		<tr>
			<td>아이디</td>
			<td><%= data.getId() %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%= data.getPw() %></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%= data.getName() %></td>
		</tr>
		<tr>
			<td>사진</td>
			<td><%= data.getPhoto() %></td>
		</tr>
	</table>
</body>
</html>