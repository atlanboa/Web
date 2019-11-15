<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO rvo = (MemberVO)session.getAttribute("vo");
	if(rvo==null){
%>
	<b>
		<a href='login_form.html'>다시 로그인부터</a>
	</b>
<% 		
	}else{
		session.invalidate();
	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logoutpop() {
		alert("Log Out!!!");
	}
</script>
</head>
<body onload="return logoutpop()">
	<b>로그 아웃 되셨습니다...</b><br>
	<a href='login_form.html'>다시 홈으로..</a>
</body>
</html>

