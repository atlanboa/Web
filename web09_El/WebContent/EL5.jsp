<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> 배열에 값을 바인딩함...</h2><p>
<%
	String[ ] winner=  new String[3];
	winner[0] = "김연아";
	winner[1] = "율리아";
	winner[2] = "아사다마오";
	request.setAttribute("winner", winner);
	
	ArrayList<String> items = new ArrayList<String>();
	items.add("딸기");
	items.add("포도");
	items.add("오렌지");
	items.add("키위");
	request.setAttribute("items", items);
	
	HashMap<String, String> map = new HashMap<String,String>();
	map.put("Edgar", "Boston");
	map.put("James", "N.Y");
	map.put("Gosling", "India");
	map.put("Peter", "L.A");
	session.setAttribute("map", map);
	
	request.getRequestDispatcher("collectionEl3_view.jsp?name=Edgar").forward(request, response);
%>
</body>
</html>





























