<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WeSee</title>
<style>
body {
	width: 1024px;
	height: 860px;
	margin: 10px auto;
}

h1 {
	text-align: center;
	text-decoration-line: none;
	color: black;
	font-size: 50px;
	border-bottom: 5px solid;
	padding-bottom: 30px;
}

.bigbox {
	display: flex;
	justify-content: space-evenly;
	margin-top: 30%;
}

.box {
	display: flex;
	flex-direction: column; /*수직정렬*/
	justify-content: space-evenly;
	flex-grow: 2;
	border-radius: 5%;
	width: 420px;
	height: 280px;
	background-color: black;
	padding-top: 10px;
	text-align: center;
	background-color: black;
	padding-top: 10px;
	padding-top: 10px;
}

div>input {
	display: flex;
	font-size: 30px;
	width: 350px;
	height: 40px;
	margin: 30px;
	margin-bottom: 10px;
	color: white;
	background-color: black;
	border-color: black;
}

a {
	width: 200px;
	height: 50px;
}

a.ex1 {
	display: inline-block;
	line-height: 50px;
	text-align: center;
}

.ex2 {
	display: flex;
	justify-content: space-evenly;
}

.wesee {
	margin-top: 50px;
	flex-grow: 1;
}

label {
	font-size: 50px;
	font-weight: bold;
	text-align: center;
}

button {
	width: 200px;
	height: 50px;
	background-color: white;
	text-decoration: none;
	color: black;
	border-style: none;
	cursor: pointer;
}

.msg{
	width : 650px;
	font-size: 1.5rem;
	border-top : 2px solid gray;
}

.joinbox {
	display: flex;
	justify-content: space-around;
}

.join{
	width : 450px;
	margin-left: 80px;
}
</style>
</head>
<body>

	<h1>
		<label>WeSee</label>
	</h1>


	<div class="bigbox">
		<div class="wesee">
			<label>우리는 바라고 -Wish-<br>우리는 본다. -WeSee-
			</label>
		</div>

		<form action="login.do" method="post">
			<div class="box">
				<input name="id" type="text" placeholder="아이디" /> <input name="pw"
					type="password" placeholder="비밀번호" />
				<div class="ex2">
					<button>로그인</button>
				</div>
			</div>
		</form>



	</div>
	<div class="joinbox">
			<%-- msg 변수에 값이 있을 때에만 출력 --%>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>
		<button class="join" onclick="goToJoinPage()">회원가입을 하시려면 이곳을 클릭하세요.</button>
	</div>


	<script>
		function goToJoinPage() {
			window.location.href = "<c:url value='/join.jsp' />";
		}
	</script>

</body>
</html>