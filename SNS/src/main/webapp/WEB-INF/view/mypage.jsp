<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WeSee - My Page</title>
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

.info-container {
	margin-top: 50px;
	text-align: center;
}

.info-item {
	margin-bottom: 20px;
}

.edit-button {
	margin-top: 30px;
	text-align: center;
}
</style>
</head>
<body>
    <h1>
        <label>WeSee</label>
    </h1>
    <h3>내 프로필</h3>
    <div class="info-container">
        <div class="info-item">
            <label>ID:</label> <span>${member.id}</span>
        </div>
        <div class="info-item">
            <label>Password:</label> <span>${member.pw}</span>
        </div>
        <div class="info-item">
            <label>성명:</label> <span>${member.username}</span>
        </div>
        <div class="info-item">
            <label>번호:</label> <span>${member.phone}</span>
        </div>
        <div class="info-item">
            <label>생년월일:</label> <span>${member.birth}</span>
        </div>
    </div>

    <div class="edit-button">
        <button onclick="editUserInfo()">수정하기</button>
    </div>

    <!-- 자바스크립트 및 기타 HTML 내용을 이곳에 추가하세요 -->

</body>
</html>
