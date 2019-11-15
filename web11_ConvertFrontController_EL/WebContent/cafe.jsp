<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- login하지 않고 바로 주소창에서 cafe.jsp를 바로 치고 들어오는 사람이 있다. -->
<c:choose>
	<c:when test="${not empty vo}">
		${vo.address} 에 거주하는 ${vo.name}님, Cafe 입장 환영!!!<br>
		<a href="index.jsp">홈으로</a>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
	    alert("주소를 바로 치고 들어오셨네요!! 로그인부터 하셔야 합니다~~~");
	    location.href="login.jsp";
	    //location.href="http://id:domain name/page";
	</script>
	</c:otherwise>
</c:choose>
</body>
</html>























