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

.title {
	font-family: Arial, sans-serif;
	font-size: 2rem;
}

.bigbox {
	height: 800px;
	display: flex;
	flex-direction: column; /*수직정렬*/
	justify-content: center;
	align-items: center;
	width: 1024px;
}

.box {
	display: flex;
	flex-direction: column; /*수직정렬*/
	justify-content: space-evenly;
	border-radius: 5px;
	height: 700px;
	background-color: black;
	padding-top: 10px;
	text-align: center;
	width: 500px;
}

div>input {
	display: flex;
	font-size: 30px;
	width: 400px;
	height: 40px;
	font-size: 1.5rem;
}

.jointitle {
	height: 150px;
	margin-top: 50px;
	margin-bottom: 80px;
	text-align: center;
	line-height: 150px;
	text-align: center;
}

label {
	font-size: 50px;
	font-weight: bold;
	text-align: center;
}

input {
	border-radius: 5px;
	margin-bottom: 8px;
}

.idbox {
	display: flex;
	flex-direction: column; /*수직정렬*/
	justify-content: center;
	align-items: center;
	padding: 20px;
	border-radius: 5px;
	border-bottom: 3px solid white;
	padding-bottom: 60px;
}

.idbox input {
	font-size: 16px;
	padding: 10px;
}

.namebox {
	display: flex;
	flex-direction: column; /*수직정렬*/
	justify-content: center;
	align-items: center;
	padding: 20px;
	border-radius: 5px;
}

.namebox input {
	font-size: 16px;
	padding: 10px;
}

.joinBB {
	text-align: center;
}

.joinB {
	width: 150px;
	height: 50px;
	line-height: 50px;
	border-radius: 10px;
	background-color: white;
}
</style>
</head>
<body>

	<h1>
		<label>WeSee</label>
	</h1>

	<div class="bigbox">
		<label class="title">JOIN</label>
		<div class="box">
		
		
			<form action="register.do" method="post">
				<div class="idbox">
					<input name="id" required placeholder="아이디" /> 
					<input name="pw"
						type="password" required placeholder="비밀번호" /> <input
						name="pw-check" type="password" required placeholder="비밀번호 확인" />
				</div>
				<div class="namebox">
					<input name="username" required placeholder="성명" /> <input
						name="phone" value="010-" required /> <input name="birth"
						pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" placeholder="생년월일 0000-00-00"
						required />
				</div>
				
			<div class="joinBB">
				<input class="joinB" type="submit" value="가입" />
			</div>
			</form>




		</div>
			<div class="msg">${msg}</div>
	</div>

</body>
</html>