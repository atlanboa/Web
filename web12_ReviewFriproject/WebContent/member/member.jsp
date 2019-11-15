<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	margin : 0 auto ;
	width : 500px;
	background-color: #D5D5D5;
}
table {
	width : 500px;
	text-align: center;
}

input {
	height: 20px;
}
#address {
	width: 176px;
	height: 20px;
}
td {
	padding: 5px;
}
</style>
<script type="text/javascript">
function inputCheck(){

	if(PW.value != PW2.value){
		alert("비밀번호와 비밀번호 확인은 같아야 함~~~");
		pw.focus();
		return;
	}
	document.regForm.submit();
}//check()

</script>
</head>
<body>
<h1> 회원 가입 화면</h1>
<p/>
	<form name="regForm"  method="post"  action="${pageContext.request.contextPath}/member.do?command=addMember">
		<table>
			<tr>
				<td id="myid" align="right" width="50%">아이디</td>
				<td width="50%"><input type="text"  id="ID" name="ID" required="required"></td>
			</tr>

			<tr>
				<td id="myid" align="right">비밀번호</td>
				<td><input type="password"  id="PW" name="PW" required="required"></td>
			</tr>

			<tr>
				<td id="myid" align="right">비밀번호 확인</td>
				<td><input type="password"  id="PW2" name="PW2" required="required"></td>
			</tr>

			<tr>
				<td class="name" align="right">이름</td>
				<td><input type="text" name="NAME" required="required"></td>
			</tr>

			<tr>
				<td class="name" align="right">닉네임</td>
				<td><input type="text" name="NICKNAME"></td>
			</tr>

			<tr>
				<td align="right">이메일</td>
				<td><input type="email" name="EMAIL" id="EMAIL"> </td>
			</tr>
			<tr>
				<td align="right">홈페이지/블로그</td>
				<td><input type="url" name="HOMEPAGE" id="HOMEPAGE" /></td>
			</tr>
			<tr>
				<td align="right">거주지</td>
				<td><select name="ADDRESS" id="address" >
						<option value="서울">서울</option>
						<option value="부산">부산</option>
						<option value="광주">광주</option>
						<option value="경기도">경기도</option>
						<option value="강원">강원</option>
				</select></td>
			</tr>
			<tr>
				<td align="right">취미</td>
				<td><input type="checkbox" name="HOBBY" value="컴퓨터">컴퓨터<input
					type="checkbox" name="HOBBY" value="여행">여행<input
					type="checkbox" name="HOBBY" value="독서">독서 <input
					type="checkbox" name="HOBBY" value="영화">영화</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input  type="button" value="가입하기" onclick="inputCheck()" />
					<input	type="reset" value="초기화"  />
					<input  type="button" value="메인 페이지" onclick="location.href='index.jsp'" /> 					
			</tr>
		</table>
	</form>
</body>
</html>