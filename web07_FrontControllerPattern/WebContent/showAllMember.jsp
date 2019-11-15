<%@page import="model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
    	//out.println(list);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body table{
		margin: 0px;
		margin-left: auto;
		margin-right: auto;
		width: 55%;
	}
	
	tr td{
		text-align: center;
	}
	table tr:hover{
		background-color: pink; 
	}
	th{
		background-color: red; color: white;
	}
</style>
</head>
<body>

<h3><b>현재 가입하신 회원은 ${param.name} 입니다.</b></h3>

<h2 align="center">전체 회원 명단 리스트</h2><br><br>
<table border="2">
	<tr>
		<th>번호</th><th>아이디</th><th>이름</th><th>주소</th>
	</tr>
	
	<%
		for(int i = 0; i < list.size(); i++){
	%>
		<tr>
			<td><%= i+1 %></td>
			<td><%= list.get(i).getId()%></td>
			<td><%= list.get(i).getName()%></td>
			<td><%= list.get(i).getAddress()%></td>
		</tr>
	<%		
		}
	%>
</table>
</body>
</html>