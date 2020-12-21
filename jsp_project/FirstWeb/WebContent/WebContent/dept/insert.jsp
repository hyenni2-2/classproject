<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 


// 한글 처리
request.setCharacterEncoding("utf-8");


// 데이터받고 -> 
// 폼 값 getParameter로 받기 

// sql: insert -> 
// insert_view로 포워딩

// java API사용할 수 있게
Connection con = null;

// 1. 드라이버 로드하기
Class.forName("com.mysql.cj.jdbc.Driver");

// 2. DB 연결하기
String jdbcUrl = "jdbc:mysql://localhost:3306/open?serverTimezone=UTC";
String user = "aia";
String pw = "aia";

con = DriverManager.getConnection(jdbcUrl, user, pw);

out.println("<h3>MySQL is Connected!</h3>");

//SQL 변수 만들기
String deptSql = "insert into dept values(?,?,?)";

// Statement 만들기
Statement st = con.createStatement();


ResultSet rs = st.executeQuery(deptSql);

%>
<jsp:forward page="insult_view.jsp"/>