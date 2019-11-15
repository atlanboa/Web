<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>1. 결과 페이지 정보입니다... :: JSP Basic Tag 사용</h2>
<%= request.getAttribute("RESULT") %><br>
<%= session.getAttribute("RESULT") %><br>
<hr>
<h2>2. 결과 페이지 정보입니다... :: EL 사용</h2>
1)1 ~ 100까지의 합산정보: ${requestScope.RESULT}<br>
2)세션 정보 : ${sessionScope.RESULT}
<hr>
1)정보출력 1: ${RESULT}
2)정보출력 2: ${NAME}
</body>
</html>