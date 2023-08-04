<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	
}

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

.wrapper {
	
}

.wrapper>header {
	
}

.wrapper>header>.top--header {
	
}

.wrapper>header>nav {
	
}

.wrapper>main {
	
}

.wrapper>footer {
	
}
</style>
</head>
<body>
	<div class="wrapper">
		<header>
			<div class="top--header"></div>
			<h1>
				<label>WeSee</label>
			</h1>
			<nav></nav>
		</header>
		<main>
			<section>
				<form action="add.do" method="post">
					<input type="hidden" name="userId" value="${sessionScope.userId}"
						class="show--block">사용자ID : ${sessionScope.userId}</input>
					<div>
						글 내용을 입력하시라요.
						<textarea name="contents" id="contents">여기에 입력</textarea>
					</div>
					<button type="submit">저장</button>
				</form>
				<div class="msg">${msg}</div>



			</section>
			<section></section>
			<section></section>
		</main>
		<footer></footer>
	</div>


</body>
</html>