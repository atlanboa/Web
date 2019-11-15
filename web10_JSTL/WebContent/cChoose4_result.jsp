<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${param.num1 == '0'}">
		<h2>안녕하세요</h2>
	</c:when>
	<c:when test="${param.num1 == '1'}">
		<h2>반가워요</h2>
	</c:when>
	<c:otherwise>
		<h2>배고파요</h2>
	</c:otherwise>
</c:choose>
</body>
</html>