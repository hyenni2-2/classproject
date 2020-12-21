<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav>
	<ul> <!-- /op라고 context path를 설정했기 때문에 /op만 넣어줘도 된다. -->
		<li><a href="<%= request.getContextPath()%>">HOME</a></li>
		<li><a href="<%= request.getContextPath()%>/member/memberRegForm.jsp">회원가입</a></li>
		<li>
		
		<%
		
		if(session.getAttribute("loginInfo")==null){
			%>
			<a href="<%= request.getContextPath()%>/member/loginForm.jsp">LOGIN</a>
			<%	
		} else {
		 %>
		 <a href="<%= request.getContextPath()%>/member/logout.jsp">LOGOUT</a>
		 <%	
		}
		 %>

		</li>
		<li><a href="<%= request.getContextPath()%>/member/mypage/myPage1.jsp">myPage1</a></li>
		<li><a href="<%= request.getContextPath()%>/member/mypage/myPage2.jsp">myPage2</a></li>
		<li><a href="#">HOME</a></li>
	</ul>
</nav>