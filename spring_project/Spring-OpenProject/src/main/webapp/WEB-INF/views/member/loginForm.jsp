<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/include/basicset.jsp" %>
<style>
</style>
</head>
<body>

	<!-- 나중에 web-inf 폴더 안으로 옮길거라,상대경로를 적용할 수 없다. 따라서 절대 경로를 썼음. -->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<%@ include file="/WEB-INF/views/include/nav.jsp"%>

	<!-- 각 페이지마다 콘텐츠는 다르기 때문에 남겨둔다. -->
<div class="my-3 p-3 bg-white rounded shadow-sm">
    <h3 class="border-bottom pb-2 mb-0">Login Form</h3>
    <div class="d-flex text-muted pt-3"> 
			
			
			
			 <form method="post" class="calign-items-center">
    <label for="userid" class="visually-hidden">Email address</label>
    <input type="email" id="inputEmail" name="userid" value="${cookie.uid.value} class="form-control" placeholder="Email address" required autofocus>
    <label for="pw" class="visually-hidden">Password</label>
    <input type="password" id="pw" name="pw" class="form-control" placeholder="Password" required>
    <div class="checkbox mb-3">
      <label>
        <input type="checkbox" name="chk" value="on" ${cookie.uid ne null ? 'checked':''}> Remember ID
      </label>
    </div>
    <input type="submit" value="로그인" class="w-100 btn btn-lg btn-primary">
  </form>
  
  
			
		</div>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>

</body>
</html>