<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

	<h1>회원가입 페이지</h1>
	<form action="rqResult.jsp">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName" id="userName"></td>
			</tr>
			<tr>
				<td>생일</td>
				<td><input type="date" name="bd" id="bd"></td>
			</tr>
			<tr>
				<td>해보고싶은 수상레저</td>
				<td><input type="checkbox" name="water" value="프리다이빙">프리다이빙<br>
					<input type="checkbox" name="water" value="스노클링">스노클링<br>
					<input type="checkbox" name="water" value="스쿠버다이빙">스쿠버다이빙<br>
					<input type="checkbox" name="water" value="수상스키">수상스키<br>
				</td>
			</tr>
			<tr>
				<td>혈액형</td>
				<td><select name="bType">
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="O">O</option>
						<option value="AB">AB</option>
				</select></td>
			</tr>
			<tr>
			<td><input type="submit" value="가입"><input type="reset"></td>
			</tr>
		</table>
	</form>

</body>
</html>