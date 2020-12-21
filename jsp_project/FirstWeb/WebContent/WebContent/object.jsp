<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    
    request.setAttribute("userName", "최혜인");
    
    application.setAttribute("userId", "1111");
    
    session.setAttribute("nickname", "혜니");
    
    pageContext.setAttribute("age", 31);
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%= request.getAttribute("userName") %>,
<%= application.getAttribute("userId") %>,
<%= session.getAttribute("nickname") %>,
<%= pageContext.getAttribute("age") %>

</body>
</html>