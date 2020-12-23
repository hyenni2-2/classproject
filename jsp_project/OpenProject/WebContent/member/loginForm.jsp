<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
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
<link rel="styleSheet" href="${url_defaultCss}">
<style>
</style>
</head>
<body>

	<!-- 나중에 web-inf 폴더 안으로 옮길거라,상대경로를 적용할 수 없다. 따라서 절대 경로를 썼음. -->
	<%@ include file="/include/header.jsp"%>

	<%@ include file="/include/nav.jsp"%>

	<!-- 각 페이지마다 콘텐츠는 다르기 때문에 남겨둔다. -->
	<div class="contents">
		<h2 class="content_title">Login Form</h2>
		<hr>
		<div class="content"> 
			<form action="<c:url value="/member/login.jsp"/>" method="post">
				<table>
					<tr>
						<th><label for="userid">아이디</label></th>
						<td><input type="text" id="userid" name="userid"
							value="<%= saveId %>"></td>
					</tr>
					<tr>
						<th><label for="pw">비밀번호</label></th>
						<td><input type="password" id="pw" name="pw"></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="checkbox" name="chk" value="on"
							<%= checked %>> 아이디 저장</td>
					</tr>
					<tr>
						<th></th>
						<td><input type="submit" value="로그인"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<%@ include file="/include/footer.jsp"%>

</body>
</html>