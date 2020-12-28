<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOIN PAGE</title>
<link rel="styleSheet" href="${basicCss}" />
</head>
<body>

	<!-- 헤더,네비,후터 불러오기 -->

	<%@ include file="/factors/header.jsp"%>
	<%@ include file="/factors/nav.jsp"%>


	<div class="contents">
		<h2 class="content_title">회원가입</h2>
		<hr>
		<div class="content">
			<form action="joinMem.jsp" method="post" enctype="multipart/form-data">
				<!-- 사진을 업데이트 하기 위한 enctype 설정 -->
				<table>
					<tr>
						<th>아이디</th>
						<td><input type="text" id="joinId" name="joinId"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" id="pw" name="pw"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" id="joinName" name="joinName"></td>
					</tr>
					<tr>
						<th>사진</th>
						<td><input type="file" id="joinPhoto" name="joinPhoto"></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="submit" value="가입하기"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<%@ include file="/factors/footer.jsp"%>

</body>
</html>