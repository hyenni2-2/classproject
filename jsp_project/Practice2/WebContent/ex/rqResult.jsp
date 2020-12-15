<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>

	<h1>회원정보 페이지</h1>
	<table>
		<tr>
			<td>이름</td>
			<td><%= request.getParameter("userName") %></td>
		</tr>
		<tr>
			<td>생일</td>
			<td><%= request.getParameter("bd") %></td>
		</tr>
		<tr>
			<td>해보고싶은 수상레저</td> <!-- 여러개니까 잊지말고 배열로 받아야함 -->
			<td>
			<%
			
			String[] water = request.getParameterValues("water");
			
			for(int i=0; i<water.length; i++){
				out.println(water[i]+"<br>");
			}
			
			%>
			</td>
		</tr>
		<tr>
			<td>혈액형</td>
			<td><%= request.getParameter("bType") %></td>
		</tr>
	</table>

</body>
</html>