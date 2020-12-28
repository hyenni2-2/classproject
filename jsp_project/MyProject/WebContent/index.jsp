<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/design/basic.css" var="basicCss" scope="application"></c:url> <!-- css를 적용하기 위한 기본 설정 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<link rel="styleSheet" href="${basicCss}"> <!-- 위에서 적용한 css를 불러오기 -->
</head>
<body>

<!-- 헤더,네비,후터 불러오기 -->

<%@ include file="/factors/header.jsp" %>
<%@ include file="/factors/nav.jsp" %>

<div class="contents">
<h3>메인 페이지입니다.</h3>
</div>

<%@ include file="/factors/footer.jsp" %>

</body>
</html>