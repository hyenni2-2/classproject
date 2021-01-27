<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<body class="bg-light">



	<!-- 나중에 web-inf 폴더 안으로 옮길거라,상대경로를 적용할 수 없다. 따라서 절대 경로를 썼음. -->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<%@ include file="/WEB-INF/views/include/nav.jsp"%>

<main class="container">
  <div class="d-flex align-items-center p-3 my-3 text-white bg-purple rounded shadow-sm">
    <img class="me-3" src="../assets/brand/bootstrap-logo-white.svg" alt="" width="48" height="38">
    <div class="lh-1">
      <h1 class="h6 mb-0 text-white lh-1">Index</h1>
      <small>Since 2011</small>
    </div>
  </div>
	<!-- 각 페이지마다 콘텐츠는 다르기 때문에 남겨둔다. -->
	<div class="contents">
		<h2 class="content_title">index</h2>
		<hr>
		<div class="content">인덱스 페이지입니다.</div>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>



<script>
<c:if test="${param.type eq 'delete'}">
<c:if test="${param.result eq 'ok'}">
alert('로그아웃되었습니다.');
</c:if>
<c:if test="${param.result ne 'ok'}">
alert('처리 과정에서 오류가 발생했습니다.');
</c:if>
</c:if>
</script>



</body>
</html>