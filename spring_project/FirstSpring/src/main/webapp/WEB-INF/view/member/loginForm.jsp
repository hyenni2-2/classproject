<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인폼</title>
</head>
<body>
 
 <h1>Login Form</h1>
 
 <form method="post"> <!-- 현재 경로 : /member/login(get방식으로 했을 때) -->
  id <input type="text" name="uid"><br>
  pw <input type="password" name="pw"><br>
  <input type="submit">
</form>

</body>
</html>