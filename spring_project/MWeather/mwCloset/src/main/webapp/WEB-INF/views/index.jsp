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
<link rel="styleSheet" href="<c:url value="/css/closet.css"/>">
<link rel="styleSheet"
	href="<c:url value="/bootstrap/bootstrap.min.css"/>">
	
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
<!-- js 파일 -->
<script src="<c:url value="/js/codiset.js"/>"> </script>

<%@ include file="/WEB-INF/views/include/basicset.jsp"%>

</head>

<body bgcolor="#f5f5f5">

   <%@ include file="/WEB-INF/views/include/header.jsp"%>

   <div class="content" id="content" name="content">
   	<div class="closet" id="closet" name="closet"></div>
   </div>
   	
   
   <%@ include file="/WEB-INF/views/include/footer.jsp" %>

</body>
</html>