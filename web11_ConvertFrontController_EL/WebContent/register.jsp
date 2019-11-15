<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function registerData(){
		var f=document.registerForm;
		
		if(f.flag.value=="false"){
			alert("아이디 중복확인하세요");
			return false;
		} 
	}//registerData()

	function checkId() { //여기서 id 중복체크를 하겠다.
		var str = document.registerForm.id.value;
	    window.open("MainServlet?command=idCheck&&id="+str,"","width=300,height=200,top=100,left=400");
		
	}//checkId	
</script>
</head>
<body>
<h3>회원가입</h3>
<!-- register_action에서 하고있는 기능이  RegisterServletd으로 이동
	 register_result.jsp로 결과를 보낸다.
-->
	<form action="MainServlet" name="registerForm" 
	method="post" onsubmit="return registerData()">
		<input type="hidden" name="command" value="register">
		아이디 : <input type="text" name="id" required="required">
		<input type="button" value="중복확인" onclick="checkId()"><br>
		패스워드 : <input type="password" name="password" required="required"><br>
		이름 : <input type="text" name="name" required="required"><br>
		주소 : <input type="text" name="address" required="required"><br>	
		<input type="hidden" name="flag" value="false">	<!-- 중요 -->
		<input type="submit" value="회원가입">
	</form>
</body>
</html>























