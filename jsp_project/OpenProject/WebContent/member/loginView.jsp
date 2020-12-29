<%@page import="member.model.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%
	// LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
%>
<c:if test="${not loginChk}">
<script>
	alert("아이디 또는 비밀번호가 다릅니다. 다시 로그인해주세요.");
	history.go(-1); // 뒷페이지로 가게함
</script>
</c:if>
<c:if test="${loginChk}"> <!-- 로그인체크가 정상적으로 들어오지 않으면 html안만들어지게함 -->
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
		<h2 class="content_title">Login</h2>
		<hr>
		<div class="content">로그인 되었습니다. <br>
		<%-- <%= loginInfo %> --%>
		${loginInfo}
		</div>
	</div>

	<%@ include file="/include/footer.jsp"%>

</body>
</html>
</c:if>