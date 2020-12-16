<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <%
  request.setAttribute("lang", "ko");
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- sendRedirect는 request를 공유하지 않음. forward나 include를 써야함 -->
<jsp:forward page="forward.jsp"/> 

<!-- <% response.sendRedirect("forward.jsp"); %> --%>  


</body>
</html>