<!-- 
jstl기술을 사용하기 위해서는
1. jar파일 2개가 필요..
2. 지시어에 taglib 속성을 하나 무조건 추가
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>out :: jstl에서 출력을 담당하는 부분</title>
</head>
<body>
<c:out value="오늘은 금요일입니다."></c:out>
<c:out value="<h1>오늘은 금요일입니다.</h1>"></c:out>
<c:out value="<h1><font color=red>오늘은 금요일입니다.</font></h1>" escapeXml="false"></c:out>
</body>
</html>