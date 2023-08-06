<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>

<!-- 
 *************해야될 것************
 
1. ID 중복체크 버튼 만들기
2. PHONE 입력칸에 010- 디폴트 값 넣기
3. BIRTH는 0000-00-00 이런식

 -->








<form action="login.do" method="post">
	ID : <input name="id" /><br>
	PW : <input name="pw" type="password"/><br>
	PW-CHECK : <input name="pw-check" type="password"/><br>
	NAME : <input name="name" /><br>
	PHONE : <input name="phone" /><br>
	BIRTH : <input name="birth" /><br>
	<input type=submit value="가입" />
</form>
<hr />
<div class="msg">
	${msg}
</div>

</body>
</html>
