
<!--1. 지시어 : 컴파일 시에 특정한 내용을 컨테이너에게 알려주는 역할을 한다  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--2. tag는 못들어가고 자바코드만 이 안에 들어갈 수 있다. --> 
<!-- jsp의 내장객체
	 request, response, application, out, session
 -->   
<%
	String url = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=";
	String keyword=request.getParameter("word");
	url += keyword;
	response.sendRedirect(url);
%>
<!--3. 출력문 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>