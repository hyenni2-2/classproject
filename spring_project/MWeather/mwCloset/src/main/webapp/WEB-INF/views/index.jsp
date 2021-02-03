<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>+WEATHER WEAR+</title>

<link rel="styleSheet" href="<c:url value="/css/default.css"/>">
<link rel="styleSheet" href="<c:url value="/bootstrap/bootstrap.min.css"/>">
<link rel="styleSheet" href="<c:url value="/css/closet.css"/>">


<%@ include file="/WEB-INF/views/include/basicset.jsp"%>


</head>

<body bgcolor="#f5f5f5">

	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	
	<div class="content" id="content" name="content">
	  <!-- 리스트 출력 -->
	  <script type="text/javascript" src="<c:url value="/js/closet.js"/>"> </script> 
	  
	  <!-- 코디게시판 -->
	  <div class="codipart" id="codipart" name="codipart">
	  <div class="codibg" id="codibg" name="codibg">
	  
	  draggable js
	  </div>
	  <div class="codi" id="codi" name="codi">
	   <script type="text/javascript" src="<c:url value="/js/codiset.js"/>"> </script> 
	  </div>
	  </div>
	  </div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>




</body>
</html>