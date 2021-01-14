<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/css/default.css" var="url_defaultCss" scope="application"/> <!-- scope가 application이면 static과 같은 기능,  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <link rel="styleSheet"
	href="${pageContext.request.contextPath}/css/default.css"> --%>
	<%-- <link rel="styleSheet" href="<c:url value="/css/default.css"/>"> --%>
<%@ include file="/WEB-INF/views/include/basicset.jsp" %>
<style>
</style>
</head>
<body>



	<!-- 나중에 web-inf 폴더 안으로 옮길거라,상대경로를 적용할 수 없다. 따라서 절대 경로를 썼음. -->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<%@ include file="/WEB-INF/views/include/nav.jsp"%>

	<!-- 각 페이지마다 콘텐츠는 다르기 때문에 남겨둔다. -->
	<div class="contents">
		<h2 class="content_title">index</h2>
		<hr>
		<div class="content">인덱스 페이지입니다.</div>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>

</body>
</html>