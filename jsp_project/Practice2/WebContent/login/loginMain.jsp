<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<h1>Login</h1>
	<hr>
	<form action="memResult.jsp" method="post">
		<table>
			<tr>
				<th><label for="memid">아이디</label></th>
				<td><input type="text" id="memid" name="memid"></td>
			</tr>
			<tr>
				<th><label for="pw">비밀번호</label></th>
				<td><input type="password" id="pw" name="pw"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="checkbox" name="chk"> 아이디 저장</td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="로그인"></td>
			</tr>
		</table>
	</form>

</body>
</html>