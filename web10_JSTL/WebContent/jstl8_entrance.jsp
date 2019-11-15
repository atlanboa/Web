<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${param.age>=19}">
		<b>${param.name}</b> 님은 성인이므로 카페 입장 가능^^
		<script>
			alert("'${param.name}') 님은 성인이므로 카페입장 가능하십니다...")
			location.href="adult_cafe.jsp?age=${param.age}";
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("'${param.name}') 님은 미성년이므로 카페입장 불가능하십니다...")
			location.href="";
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>