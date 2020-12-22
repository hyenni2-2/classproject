<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  request.setAttribute("userName", "김선호1");
  session.setAttribute("userName", "김선호2");
  application.setAttribute("userName", "김선호3");
  session.setAttribute("userId", "yebbo");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> 
 requestScope.userName : ${requestScope.userName}, 
                         ${userName},
                         <%= request.getAttribute("userName") %> <br>
                         
 sessionScope.userId : ${sessionScope.userId}, 
                       ${userId},
                         <%= session.getAttribute("userId") %> <br>
                         
 param.code : <%= request.getParameter("code") %>, 
               ${param.code } <br>
 pageContext : <%= pageContext.getRequest().getServletContext().getContextPath()%> ,
               ${pageContext.request.requestURI }.  <br> <!-- URI:localhost:8080 이후의 경로 -->      
               ${pageContext.request.requestURL }. <br> 
               ${pageContext.request.contextPath } , <br>
               <%= request.getContextPath() %>    
                     
</h1>

<a href="view1.jsp">session 페이지 확인</a>

</body>
</html>