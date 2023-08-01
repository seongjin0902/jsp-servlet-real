<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	overflow: auto;
	max-height: 860px;
}

h1 {
	text-align: center;
	text-decoration-line: none;
	color: black;
	font-size: 50px;
	border-bottom: 5px solid;
	padding-bottom: 30px;
}

a {
	text-decoration-line: none;
	color: black;
	font-size: 50px;
}

table {
	border: 1px solid;
}

table>tr>th {
	border: 1px solid;
}

.scroll::-webkit-scrollbar {
	display: none;
}
</style>
</head>
<body class="scroll">

	<h1>
		<a href="/WeSee/">WeSee</a>
	</h1>

	<div>
		<button style="border: none; background-color: white;">
			<img src="Resource/Bell.png">
		</button>
		<button style="border: none; background-color: white;">
			<img src="Resource/Search.png">
		</button>
		<button style="border: none; background-color: white;">
			<img src="Resource/Pencil.png">
		</button>
		<a href=<c:url value="/messageController"/>>
			<button style="border: none; background-color: white;">
				<img src="Resource/Message.png">
			</button>
		</a>
		<a href=<c:url value="/MypageController"/>>
		<button style="border: none; background-color: white;">
			<img src="Resource/Person.png">
		</button>
		</a>
	</div>
	<div
		style="display: flex; justify-content: space-evenly; margin-top: 30px;">
		<table style="width: 400px; height: 650px; background-color: black;">
			<tr style="width: 400px; height: 20px;">
				<th style="display: flex; color: white;">
					<div>
						<label>mango123</label>
					</div>
					<div style="margin-left: 170px;">
						<label>2023-07-27(15:30)</label>
					</div>
				</th>
				<!-- 글쓴 시간이 빠를수록 위쪽으로 배치  -->
			</tr>
			<tr>
				<th style="background-color: white; height: 450px;"><div
						class="scroll" style="max-height: 450px; overflow: auto;">글내용(사진,글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)</div></th>
			</tr>
			<tr>
				<th style="display: flex; height: 28px; background-color: white;">
					<div>
						<button style="border: 0px; background-color: white;">
							<img src="Resource/Good.png">
						</button>
					</div>
					<div>좋아요</div>
					<div>3.5k</div> <!-- 자동숫자올라감. 1000이 넘어가면1.0k로 변경 소수점 둘째짜리 삭제 가능?-->
					<div style="margin-left: 150px;">
						<label>조회수</label>
					</div>
					<div style="margin-left: 20px;">66</div> <!--  자동숫자올라감.1000이 넘어가면 1.0k로 변경..소수점 둘째짜리 삭제 가능?? -->
				</th>
			</tr>
			<tr class='scroll'
				style="background-color: white; height: 90px; overflow: auto;">
				<td style="display: flex;">
					<div style="position: relative;">mango456</div>
					<div class='scroll'
						style="position: relative; margin-left: 5px; max-width: 190px; max-height: 21px; overflow: auto;">나는
						망고입니다ffaddgdfsgsffas..</div> <!--DB 게시물의 댓글중 빨리적은 순서대로  -->
					<div style="position: relative; margin-left: 10px;">02.02.01
						15:30</div> <!-- nowdate(date)  -->
				</td>
				<td style="display: flex;">
					<div style="position: relative;">Durumi</div>
					<div class='scroll'
						style="position: relative; margin-left: 5px; max-width: 190px; max-height: 21px; overflow: auto;">나는두루미입니다.fas..</div>
					<!--DB 게시물의 댓글중 빨리적은 순서대로  -->
					<div style="position: relative; margin-left: 10px;">02.02.01
						15:30</div> <!-- nowdate(date)  -->
				</td>
				<td style="display: flex;">
					<div style="position: relative;">mango456</div>
					<div class='scroll'
						style="position: relative; margin-left: 5px; max-width: 190px; max-height: 21px; overflow: auto;">나는
						망고입니다ffaddgdfsgsffas..</div> <!--DB 게시물의 댓글중 빨리적은 순서대로  -->
					<div style="position: relative; margin-left: 10px;">02.02.01
						15:30</div> <!-- nowdate(date)  -->
				</td>
				<td style="display: flex;">
					<div style="position: relative;">mango456</div>
					<div class='scroll'
						style="position: relative; margin-left: 5px; max-width: 190px; max-height: 21px; overflow: auto;">나는
						망고입니다ffaddgdfsgsffas..</div> <!--DB 게시물의 댓글중 빨리적은 순서대로  -->
					<div style="position: relative; margin-left: 10px;">02.02.01
						15:30</div> <!-- nowdate(date)  -->
				</td>
				<td style="display: flex;">
					<div style="position: relative;">mango456</div>
					<div class='scroll'
						style="position: relative; margin-left: 5px; max-width: 190px; max-height: 21px; overflow: auto;">나는
						망고입니다ffaddgdfsgsffas..</div> <!--DB 게시물의 댓글중 빨리적은 순서대로  -->
					<div style="position: relative; margin-left: 10px;">02.02.01
						15:30</div> <!-- nowdate(date)  -->
				</td>



			</tr>


			<tr style="background-color: white;">
				<th>
					<div>
						<textarea class='scroll' placeholder="댓글을 입력하세요."
							style="border: none; resize: none; width: 380px; outline: none;"></textarea>
					</div>
				</th>
			</tr>
		</table>
		<table style="width: 400px; height: 650px; background-color: black;">
			<tr style="width: 400px; height: 20px;">
				<th style="display: flex; color: white;">
					<div>
						<label>mango123</label>
					</div>
					<div style="margin-left: 170px;">
						<label>2023-07-27(15:30)</label>
					</div>
				</th>
				<!-- 글쓴 시간이 빠를수록 위쪽으로 배치  -->
			</tr>
			<tr>
				<th style="background-color: white; height: 450px;"><div
						class="scroll" style="max-height: 450px; overflow: auto;">글내용(사진,글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)글내용(사진,동영상)</div></th>
			</tr>
			<tr>
				<th style="display: flex; height: 28px; background-color: white;">
					<div>
						<button style="border: 0px; background-color: white;">
							<img src="Resource/Good.png">
						</button>
					</div>
					<div>좋아요</div>
					<div>3.5k</div> <!-- 자동숫자올라감. 1000이 넘어가면1.0k로 변경 소수점 둘째짜리 삭제 가능?-->
					<div style="margin-left: 150px;">
						<label>조회수</label>
					</div>
					<div style="margin-left: 20px;">66</div> <!--  자동숫자올라감.1000이 넘어가면 1.0k로 변경..소수점 둘째짜리 삭제 가능?? -->
				</th>
			</tr>
			<tr class='scroll'
				style="background-color: white; height: 90px; overflow: auto;">

				<td style="display: flex;">
					<div style="position: relative;">mango456</div>
					<div class='scroll'
						style="position: relative; margin-left: 5px; max-width: 190px; max-height: 21px; overflow: auto;">나는
						망고입니다ffaddgdfsgsffas..</div> <!--DB 게시물의 댓글중 빨리적은 순서대로  -->
					<div style="position: relative; margin-left: 10px;">02.02.01
						15:30</div> <!-- nowdate(date)  -->
				</td>
				<td style="display: flex;">
					<div style="position: relative;">Durumi</div>
					<div class='scroll'
						style="position: relative; margin-left: 5px; max-width: 190px; max-height: 21px; overflow: auto;">나는두루미입니다.fas..</div>
					<!--DB 게시물의 댓글중 빨리적은 순서대로  -->
					<div style="position: relative; margin-left: 10px;">02.02.01
						15:30</div> <!-- nowdate(date)  -->
				</td>
				<td style="display: flex;">
					<div style="position: relative;">mango456</div>
					<div class='scroll'
						style="position: relative; margin-left: 5px; max-width: 190px; max-height: 21px; overflow: auto;">나는
						망고입니다ffaddgdfsgsffas..</div> <!--DB 게시물의 댓글중 빨리적은 순서대로  -->
					<div style="position: relative; margin-left: 10px;">02.02.01
						15:30</div> <!-- nowdate(date)  -->
				</td>

			</tr>

			<tr style="background-color: white;">
				<th>
					<div>
						<textarea class='scroll' placeholder="댓글을 입력하세요."
							style="border: none; resize: none; width: 380px; outline: none;"></textarea>
					</div>
				</th>
			</tr>
		</table>
	</div>






</body>
</html>