<%@ page language="java" contentType="text/html; charset=EUC-KR"
pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>폼에 입력된 데이타를 출력합니다...</h2>
<%
String id = (String)application.getAttribute("id");
out.println(id);
%>
<%=(String)application.getAttribute("id") %><br>
<%=(String)application.getAttribute("pass") %><br>
<%=(String)application.getAttribute("gender") %><br>
<%=(String)application.getAttribute("command") %><br>
<%=(String)application.getAttribute("intro") %><br>
</body>
</html>