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
    border-color: white;
}

/* 콤보박스 스타일 */
.phone-combo-container {
    display: flex;
    align-items: center;
    font-size: 1.5rem;
    border:2px solid white;
    margin-bottom: 10px;
    border-radius: 5px;
    background-color: white;
}

.phone-combo-container select {
	height : 40px;
	border-style: none;
	width : 50px;
	margin-left: 10px;
}

.phoneinput{
	width : 340px;
	height : 40px;
	margin-bottom: 0px;
	border-style: none;
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
                    <input name="pw" type="password" required placeholder="비밀번호" /> 
                    <input name="pw-check" type="password" required placeholder="비밀번호 확인" />
                </div>
                <div class="namebox">
                    <input name="username" required placeholder="성명" />
                    <!-- 콤보박스를 전화번호 입력칸 안으로 배치합니다 -->
                    <div class="phone-combo-container">
                        <select name="phonePrefix" required>
                            <option value="010">010</option>
                            <option value="011">011</option>
                            <option value="016">016</option>
                            <option value="017">017</option>
                            <option value="018">018</option>
                            <option value="019">019</option>
                        </select>
                        <input class="phoneinput" name="phone" required />
                    </div>
                    <input name="birth" type="date" required />
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