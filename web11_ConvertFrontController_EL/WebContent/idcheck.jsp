<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	/* flag값에 따라서 로직이 다르게 전개된다.. */
	function closeWindow(result) {
		//여기서는 원래의 폼을 제어해야 한다...
		var of = window.opener.document.registerForm;
		if(result=='true'){ //아이디가 있다면...사용못함
			of.id.value="";
			of.id.focus();
		}else{ //아이디가 없다면...사용가능
			of.password.focus();
			of.flag.value=of.id.value;
			of.id.readOnly = true;	//수정불가...			
			//of.id.disabled = true; //결과적으로 값을 전송못하는 상황이 초래.
		}//
		
		//window.self.close();
		self.close();
	}
</script>

</head>

<body bgcolor="orange">
	<c:set var="message" value="해당 ID를 사용할 수 없음"/>
	<c:if test="${!flag}">
		<c:set var="message" value="해당 ID를 사용할 수 있음"/>
	</c:if>
	<b>${param.id}</b>, ${message}
	<input type="button" value="확인" onclick="closeWindow('${flag}')">
</body>
</html>























