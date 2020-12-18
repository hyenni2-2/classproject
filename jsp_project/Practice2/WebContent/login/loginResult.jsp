<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// 회원정보를 변수로 만들기
String memId = request.getParameter("memid");
String pw = request.getParameter("pw");

// 저장 체크용 변수 만들기
String chk = request.getParameter("chk");


// session을 이용해서 로그인처리를 해야 함(회원 정보를 가지고 있어야 로그인 상태를 유지할 수 있기 때문에)
// 로그인 여부를 체크할 함수 만들기
// id, pw는 똑같이 설정
boolean logChk = false;

if(memId.equals(pw)){
	// 로그인 처리를 진행해야함 -> 만약 로그인된다면, 객체 만들어서 보관해야하니까
	// beans 객체 만들기 -> LoginData의 생성자 이용
	LoginData login = new LoginData();
	
	// beans에 저장하기
	login.setMemId(memId);
	login.setPw(pw);
	
	// view.jsp에 객체를 전달하기 : 앞부분은 본인이 이름붙이는 것. logInfo라는 이름의 login 객체를 전달.
	request.setAttribute("logInfo", login);
	// 이 로그인한 정보를 session 객체에 저장 (그래야 로그인정보를 유지하고 맞춤화된 정보를 제공할 수 있음)
	session.setAttribute("logIn", login);
	
	// 체크값은 true로 반환
	logChk = true;

} 

if(logChk){
%>	
	<!--  loginView.jsp에 전달 -->
	<jsp:forward page="loginView.jsp"/>	
<%
} else {
	%>	
	<script>
	
	
	
	</script>
<%
}
%>











%>
