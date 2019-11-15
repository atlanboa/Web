<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="num1" value="7"></c:set>
<c:set var="num2" value="9"></c:set>
<!-- html 주석입니다. 소스보기에서 보인다. -->
<%-- jsp 주석입니다. 소스보기에서 안 보인다. 
	multiple이라는 변수를 하나 지정... num1*num2를 한 값을 변수의 값으로 할당.
--%>
<c:set var="multiple" value="${num1*num2}" scope="request"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>set :: 변수를 지정하는 기능</title>
</head>
<body>
<b>${num1} 과 ${num2}의 곱은 ${multiple }입니다.</b>
<jsp:forward page="cset2_result.jsp"></jsp:forward>
</body>
</html>