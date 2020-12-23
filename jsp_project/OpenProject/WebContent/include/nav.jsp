<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
	<ul> <!-- /op라고 context path를 설정했기 때문에 /op만 넣어줘도 된다. --> 
		<li><a href="<c:url value="/"/>">HOME</a></li>  <!-- -> /op/ : index 부르는 것과 같음 -->
		<li><a href="<c:url value="/member/memberRegForm.jsp"/>">회원가입</a></li>
		<li>
		
		<%
		
		if(session.getAttribute("loginInfo")==null){
			%>
			<a href="<c:url value="/member/loginForm.jsp"/>">LOGIN</a>
			<%	
		} else {
		 %>
		 <a href="<c:url value="/member/logout.jsp"/>">LOGOUT</a>
		 <%	
		}
		 %>

		</li>
		<li><a href="<c:url value="/member/mypage/myPage1.jsp"/>">myPage1</a></li>
		<li><a href="<c:url value="/member/mypage/myPage2.jsp"/>">myPage2</a></li>
		<li><a href="#">HOME</a></li>
	</ul>
</nav>