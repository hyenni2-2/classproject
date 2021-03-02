<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<title>+WEATHER WEAR+</title>

<link rel="styleSheet" href="<c:url value="/css/default.css"/>">
<link rel="styleSheet" href="<c:url value="/css/closet.css"/>">
<link rel="styleSheet"
	href="<c:url value="/bootstrap/bootstrap.min.css"/>">
	
<%@ include file="/WEB-INF/views/include/basicset.jsp"%>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">


<!-- js 파일 -->
<script src="<c:url value="/js/codiset.js"/>"> </script>



</head>

<body class="bg_color">

   <%@ include file="/WEB-INF/views/include/header.jsp"%>

   <div class="content" id="content" name="content">
   	<div class="closet" id="closet" name="closet"></div>
   </div>
   	
   
   <%@ include file="/WEB-INF/views/include/footer.jsp" %>

</body>
</html>