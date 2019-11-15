<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>kaka :</b>
${param.id}<br>
<h2>당신이 오늘 주문하신 메뉴들입니다..</h2>
<ul>
	<li>${paramValues.menu[0]}</li>
	<li>${paramValues.menu[1]}</li>
	<li>${paramValues.menu[2]}</li>
	<li>${paramValues.menu[3]}</li>
</ul>
</body>
</html>