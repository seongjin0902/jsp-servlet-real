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

.sendid {
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
	margin-top: 20px;
	border-radius: 5px;
	height: auto;
	background-color: white;
	padding-top: 10px;
	text-align: center;
	width: 900px;
	flex: 1; /* 콘텐츠에 맞게 높이를 늘림 */
	overflow-y: auto; /* 내용이 넘칠 경우 스크롤 처리 */
	border : 1px solid gray;
}

.chatbox{
	height : 800px;
	min-height: 300px;
}

.sendbox {
	margin-left: 30px;
	margin-right: 30px;
	overflow: auto; /* 스크롤 추가 */
	
}

.sendmessage {
	color: black;
	border-bottom: 2px dashed gray;
	padding: 20px;
	text-align: right;
	width : auto;
}

.resbox {
	margin-left: 30px;
	margin-right: 30px;
	overflow: auto; /* 스크롤 추가 */
}

.resmessage {
	color: black;
	border-bottom: 2px dashed gray;
	padding: 20px;
	text-align: left;
}

button {
	width: 80px;
	height: 70px;
	line-height: 50px;
	text-align: center;
	border-radius: 10px;
	background-color: white;
	margin: 20px;
	align-self : flex-end;
}

label {
	font-size: 50px;
	font-weight: bold;
	text-align: center;
}

textarea {
	border-radius: 5px;
	font-size: 1.5rem;
	border: none;
	outline: none; /* 포커스 테두리도 없애기 */
	resize: none; /* 사용자 크기 조절 비활성화 */
	width: 800px;
	overflow: hidden; /* 내용이 넘칠 경우 숨김 처리 */
	height: 50px;
	display: block;
	padding-left: 20px;
	padding-top: 20px;
}

.inputbox {
	display: flex;
	justify-content: center;
	align-items: center;
	background-color: white;
	border: 1px solid black;
	border-radius : 5px;
	height: auto;
	margin: 30px;
}
</style>

<script>
	// 텍스트 내용에 따라 높이 자동 조절
	function adjustHeight(textarea) {
		textarea.style.height = 'auto';
		textarea.style.height = textarea.scrollHeight + 'px';
		textarea.scrollTop = textarea.scrollHeight;
	}
</script>
</head>
<body>

	<h1>
		<label>WeSee</label>
	</h1>

	<div class="bigbox">
		<label class="sendid">여기에 ID를 띄운다</label>
		<div class="box">
			<div class = "chatbox">
				<div class="sendbox">
					<div class="sendmessage">헬로망고?</div>
					<div class="sendmessage">대답해주겐니?</div>
				</div>
				<div class="resbox">
					<div class="resmessage">응??</div>
					<div class="resmessage">나불렀어?</div>
				</div>
			</div>

			<div class="inputbox">
				<textarea oninput="adjustHeight(this)" placeholder="메시지를 입력하세요."></textarea>
				<button>전송</button>
			</div>

		</div>
	</div>






</body>
</html>