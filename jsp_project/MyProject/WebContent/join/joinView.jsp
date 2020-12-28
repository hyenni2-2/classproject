<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="styleSheet" href="${basicCss}">
</head>
<body>

	<!-- 헤더,네비,후터 불러오기 -->
	<%@ include file="/factors/header.jsp"%>
	<%@ include file="/factors/nav.jsp"%>
	
	<div class="contents">
		<h2 class="content_title">가입 확인</h2>
		<hr>
		<div class="content">
		 <c:if test="${result>0}">
		 <h2>회원가입 완료!</h2>
		 </c:if>
		 <c:if test="${result eq 0}">
		 <h2>회원가입 실패..</h2>
		 </c:if>
		 </div>
		 </div>

	<%@ include file="/factors/footer.jsp"%>
	
</body>
</html>