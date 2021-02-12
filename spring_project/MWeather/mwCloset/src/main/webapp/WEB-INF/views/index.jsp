<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
   session.setAttribute("mem_idx", "1");
   session.setAttribute("c_name", "메이웨더");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>+WEATHER WEAR+</title>

<link rel="styleSheet" href="<c:url value="/css/default.css"/>">
<link rel="styleSheet" href="<c:url value="/bootstrap/bootstrap.min.css"/>">
<link rel="styleSheet" href="<c:url value="/css/closet.css"/>">


<%@ include file="/WEB-INF/views/include/basicset.jsp"%>

<!-- <script> 
var mem_idx = ${mem_idx}
var c_name = ${c_name}
</script> -->

<%-- <script src="<c:url value="/js/closet.js"/>"> </script> --%>
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
	  <img src="<c:url value="/image/icon/back.png"/>" id="codiback" onclick="backDrag()">
	  <img src="<c:url value="/image/icon/forward.png"/>" id="codiforward" onclick="backDrag()">
	  <img src="<c:url value="/image/icon/list.png"/>" id="codilist" onclick="showList()">
	  <img src="<c:url value="/image/icon/save.png"/>" id="codisave" onclick="saveDrag()">
	  <img src="<c:url value="/image/icon/reset.png"/>" id="codireset" onclick="resetDrag()">
	  
	  
	  </div>
	  <!-- 조합배경 -->
	  <div class="codibg" id="codibg" name="codibg">
	   <!-- 클로젯 글쓰기 게시판 -->
	  <div class="closetReg" id="closetReg" name="closetReg">
	  </div>
	  </div>
	 
	  
	  </div>
	  </div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>




</body>
</html>