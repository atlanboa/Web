<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>if 사용법</title>
</head>
<body>
<c:if test="${param.num1 >= 10 }">
	${param.num1}
</c:if>
<c:if test="${param.num1 < 10 }">
	<p>hello</p>
</c:if>

</body>
</html>