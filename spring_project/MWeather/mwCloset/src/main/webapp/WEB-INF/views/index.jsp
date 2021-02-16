<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
   session.setAttribute("memIdx", 1);
   session.setAttribute("cName", "메이웨더");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>+WEATHER WEAR+</title>

<link rel="styleSheet" href="<c:url value="/css/default.css"/>">
<link rel="styleSheet"
	href="<c:url value="/bootstrap/bootstrap.min.css"/>">
<link rel="styleSheet" href="<c:url value="/css/closet.css"/>">

<!-- bootstrap START -->
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<!-- <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script> -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
	integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
	crossorigin="anonymous"></script>
<!-- bootstrap END -->

<!-- db에 보낼 전역변수 js값 -->
<script>
var memIdx = ${memIdx};
var cName = '${cName}';
</script>

<%@ include file="/WEB-INF/views/include/basicset.jsp"%>

<script src="<c:url value="/js/codiset.js"/>"> </script>




</head>

<body bgcolor="#f5f5f5">

	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<div class="content" id="content" name="content">
		<!-- 리스트 출력 -->
		<div class="closetList"></div>
		<!-- 코디게시판 -->
		<div class="codipart" id="codipart" name="codipart">
			<!-- 코디선택 -->
			<div class="codiView" id="codiView" name="codiView"></div>
			<!-- 코디 대분류 리스트 -->
			<div class="codi" id="codi" name="codi"></div>

			<!-- 코디조합버튼 -->
			<div class="codicon" id="codicon" name="codicon">
				<img src="<c:url value="/image/icon/back.png"/>" id="codiback"
					onclick="backDrag()"> <img
					src="<c:url value="/image/icon/list.png"/>" id="codilist"
					onclick="showList()"> <img
					src="<c:url value="/image/icon/save.png"/>" id="codisave"
					onclick="saveDrag()"> <img
					src="<c:url value="/image/icon/reset.png"/>" id="codireset"
					onclick="resetDrag()">
			</div>
			<!-- 조합배경 -->
			<div class="codibg" id="codibg" name="codibg"></div>
			<!-- 클로젯 글쓰기 게시판 -->
			<div class="closetReg" id="closetReg" name="closetReg"></div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>




</body>
</html>