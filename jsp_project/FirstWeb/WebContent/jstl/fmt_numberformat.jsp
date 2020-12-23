<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<fmt:formatNumber value="1000000" />
	<!-- ,넣어서 표현해줌 -->
	<fmt:formatNumber value="1000000" groupingUsed="false" />
	<!-- ,빼고 표현 -->

	<c:set var="number" value="10000000" scope="page" /> <!-- scope=page가 디폴트 -->
	
	<br>
	<fmt:formatNumber value="${number}" />
	<fmt:formatNumber var="formatNumber" value="${number}"/> <!-- 변수 선언이기 때문에 출력되지 않음 -->
	<br>
	${formatNumber}
	
	<br>
	
	통화 : <fmt:formatNumber value="${number}" type="currency" currencySymbol="$"/>
	<br>
	퍼센트 : <fmt:formatNumber value="${number/50000000}" type="percent" groupingUsed="false"/>
	<br>
	패턴 : <fmt:formatNumber value="${number}" pattern="00,000,000.00"/> <!-- 숫자 -> 문자열로 만든다. -->
	

</body>
</html>