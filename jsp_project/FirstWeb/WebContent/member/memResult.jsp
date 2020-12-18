<%@page import="util.CookieBox"%>
<%@page import="form.MemberData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 자바 코드 짜는 부분 -->
<%



// 사용자로부터 데이터 받은 거 넣기. 로그인의 경우 ID는 세션으로 해도되지만(해야하지만) PW는 하면안됨! 
String userId = request.getParameter("userid");
String pw = request.getParameter("pw");

String chk = request.getParameter("chk");

if(chk!=null && chk.equals("on") && userId != null && !userId.isEmpty()) {
	// 쿠키 생성해서 저장
	// uid = userId
	
	response.addCookie(CookieBox.createCookie("uid", userId, "/", 60*60*24*365));
} else {
	response.addCookie(CookieBox.createCookie("uid", userId, "/", 0));
}

// session을 이용해서 로그인 처리
// id, pw 비교해서 같으면 로그인 성공, 다르면 실패
// 로그인 여부 체크
boolean loginChk = false;

if(userId.equals(pw)){
	// 로그인 처리
	
	// beans 객체 생성
	MemberData memberData = new MemberData();
	
	// beans에 저장하기
	memberData.setUserid(userId);
	memberData.setPw(pw);
	
	// view.js에 beans 객체 전달하기
	request.setAttribute("memData", memberData);
	// 로그인 정보를 session 객체의 속성에 저장
	session.setAttribute("loginInfo", memberData);
	
	
	loginChk = true;

}
// login_view.jsp로 포워딩
if(loginChk) {
%>
<jsp:forward page="memberView.jsp" />
<%
} else {
	%>
<script>
	alert("아이디 또는 비밀번호가 다릅니다. 다시 로그인해주세요.");
	history.go(-1); // 뒷페이지로 가게함
	</script>
<%
}
%>






