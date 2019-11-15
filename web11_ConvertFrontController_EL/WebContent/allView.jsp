<%@page import="model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.MemberDAO"%>
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
<h3 align="center">회원 명단 보기</h3><p>
<c:forEach items="${list}" var="item" varStatus="index">
	<tr>
		<td>${index.count}</td>
		<td>${item.id}</td>
		<td>${item.name}</td>
		<td>${item.address}</td>
	</tr>
	<br>
</c:forEach>
</body>
</html>








