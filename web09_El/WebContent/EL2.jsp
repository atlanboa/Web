<%@page import="vo.Product"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberVO vo = new MemberVO("kim","queen77","김연아","태능");
	session.setAttribute("vo", vo);
	
	Product p = new Product();
	p.setName("누가바");
	p.setPrice(1000);
	session.setAttribute("p",p);
	ArrayList list = new ArrayList();
	list.add("아사다마오");
	list.add("율리아");
	list.add("소트니코바");
	list.add("김혜진");
	session.setAttribute("list", list);
	
	HashMap map = new HashMap();
	map.put("map1",new MemberVO("yul","990","울리아","러시아"));
	map.put("map2",new MemberVO("jen","345","전지현","한국"));
	session.setAttribute("map", map);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
EL로 출력 결과 보기<a href="El2_result.jsp">EL gogo!!!</a>
</body>
</html>













