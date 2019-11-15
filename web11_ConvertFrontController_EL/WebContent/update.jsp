<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here </title>
</head>
<body>
<!--  수정하기 위해서는 로긴 상태에서 해야한다...세션에 수정하고자 하는 vo가 바인딩 되어 있어야 한다-->
<c:choose>
	<c:when test="${not empty vo}">
		<form action="MainServlet" method="post">
		<input type="hidden" name="command" value="update">
		아이디 : <input type="text" name="id" value="${vo.id}" readonly="readonly"><br><br>
		패스워드 :<input type="text" name="password"  value="${vo.password}"><br><br>
		이  름 :<input type="text" name="name"  value="${vo.name}"><br><br>
		주  소 :<input type="text" name="address"  value="${vo.address}"><br><br>
		<input type="submit" value="회원정보 수정하기">	
	</form>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
		alert("회원에 대한 정보가 없어서 수정할수 없습니다...");
		location.href="login.jsp";
	</script>
	</c:otherwise>
</c:choose>
</body>
</html>


<%-- <%
	MemberVO vo=  (MemberVO)session.getAttribute("vo");
	if(vo!=null){ //로그인 되어 있다면....
%>
	<form action="UpdateServlet" method="post">
		아이디 : <input type="text" name="id" value="<%=vo.getId() %>" readonly="readonly"><br><br>
		패스워드 :<input type="text" name="password"  value="<%=vo.getPassword() %>"><br><br>
		이  름 :<input type="text" name="name"  value="<%=vo.getName() %>"><br><br>
		주  소 :<input type="text" name="address"  value="<%=vo.getAddress() %>"><br><br>
		<input type="submit" value="회원정보 수정하기">	
	</form>
<%
	}else{ //로그인이 안되어 있다면...
%>
	
<% } %> --%>
























