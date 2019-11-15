<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%
	MemberVO rvo = (MemberVO)session.getAttribute("vo");
	if(rvo==null){ //어떤 것도 바인딩 되어 있지 않다...
		out.println("다시 로그인 부터 하세여...");
		out.println("<a href='login_form.html'>GO Login page~~~</a>");
	}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Login Information....</h2><p>
Login ID ::<b><%= rvo.getId() %></b><br><br>
User Name ::<b><%= rvo.getName() %></b><br><br>
User Address :: <b><%= rvo.getAddress() %></b><br><br>
JSessionID Value ::<b><%= session.getId() %></b><br><br>
<hr>
<a href='logout.jsp'><font color="RED">Going LogOut Page~~</font></a>
<a href='login_form.html'><font color="RED">Going Logging Page~~</font></a>
</body>
</html>















