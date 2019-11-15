<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2><b>당신의 정보를 출력합니다...</b></h2>
<%-- <%
	MemberVO vo = (MemberVO)request.getAttribute("vo");
	out.println(vo.getName());
	out.println(vo.getAddress());
%> --%>

<%-- <% MemberVO vo = (MemberVO)request.getAttribute("vo"); %>
이 름 <%= vo.getName() %><br>
아이디 <%= vo.getId() %><br>
주 소 <%= vo.getAddress() %><br> --%>

${vo}
<br>
이 름 :  ${vo.name}  <br>
아이디 : ${vo.id}   <br>
주소 : ${vo.address} <br>
</body>
</html>