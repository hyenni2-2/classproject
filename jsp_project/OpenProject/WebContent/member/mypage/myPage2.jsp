<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/include/loginCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="styleSheet"
	href="<%=request.getContextPath()%>/css/default.css">
<style>
</style>
</head>
<body>

	<!-- 나중에 web-inf 폴더 안으로 옮길거라,상대경로를 적용할 수 없다. 따라서 절대 경로를 썼음. -->
	<%@ include file="/include/header.jsp"%>

	<%@ include file="/include/nav.jsp"%>

	<!-- 각 페이지마다 콘텐츠는 다르기 때문에 남겨둔다. -->
	<div class="contents">
		<h2 class="content_title">My Page 2</h2>
		<hr>
		<div class="content"><%=session.getAttribute("loginInfo")%></div>
	</div>

	<%@ include file="/include/footer.jsp"%>

</body>
</html>