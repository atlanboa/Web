<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forEach 사용법</title>
</head>
<body>
<c:forEach var="cnt" begin="1" end="8" step="2">
	<font size=${cnt} color=red>야호~~~~밥묵는다~~~집에간다</font><br>
</c:forEach>


</body>
</html>