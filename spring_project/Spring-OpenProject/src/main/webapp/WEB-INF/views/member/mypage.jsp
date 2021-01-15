<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<%@ include file="/WEB-INF/views/include/basicset.jsp" %>
<style>

img {
 width :100px;
 border-radius : 50%;
}
</style>
</head>
<body>

	<!-- 나중에 web-inf 폴더 안으로 옮길거라,상대경로를 적용할 수 없다. 따라서 절대 경로를 썼음. -->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<%@ include file="/WEB-INF/views/include/nav.jsp"%>

	<!-- 각 페이지마다 콘텐츠는 다르기 때문에 남겨둔다. -->
	<div class="contents">
		<h2 class="content_title">My Page</h2>
		<hr>
		<div class="content">My Page입니다. <br>
		${loginInfo} <br>
		<img alt="회원사진" src="<c:url value="/fileupload/member/${loginInfo.memberphoto}"/>"> 
		</div>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>

</body>
</html>
