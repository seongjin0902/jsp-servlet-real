<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
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

p {
	text-align: center;
	font-size: 18px;
	margin: 10px 0;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	padding: 10px;
	text-align: center;
	border-bottom: 1px solid #ccc;
}

th {
	background-color: #f2f2f2;
}

.no-data {
	text-align: center;
	margin: 20px 0;
	font-size: 18px;
	color: #999;
}

.edit-form {
	display: none;
}

.edit-form input {
	width: 100%;
	padding: 5px;
	border: 1px solid #ccc;
}

.edit-form button {
	margin-right: 5px;
}
</style>
</head>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>

	function editRow(boardNumber, contents) {
		var row = document.getElementById('row-' + boardNumber);
		var cells = row.getElementsByTagName('td');

		
			var cellValue = cells[2].innerText;
			cells[2].innerHTML = '<input type="text" name="contents-' + boardNumber + '" value="' + cellValue + '" />';
		

		var editButton = row.getElementsByClassName('edit-button')[0];
		var saveButton = row.getElementsByClassName('save-button')[0];
		editButton.style.display = 'none';
		saveButton.style.display = 'block';
	}

	function saveRow(boardNumber) {
		var row = document.getElementById('row-' + boardNumber);
		var inputs = row.getElementsByTagName('input');

		var formData = new FormData();
		formData.append('boardNumber', boardNumber);
		for (var i = 0; i < inputs.length; i++) {
			formData.append(inputs[i].name, inputs[i].value);
		}

		var apiUrl = "http://localhost:8080/SNS/member/mypage.do";

		
		const params = {params :{"boardNumber" : boardNumber,"contents" : inputs[0].value } }
		
		
		console.log("requestData",null,params);
		axios.post(apiUrl,null,params)
		.then(response=>{ console.log("response",response); location.reload();})
		.catch(error=>{})
		/* 
		var xhr = new XMLHttpRequest();
		xhr.open('POST', 'mypage.do', true);
		xhr.onload = function() {
			if (xhr.status === 200) {
				// 서버에서 처리가 성공적으로 완료됐을 때 실행할 로직
				console.log(xhr.responseText);
				var response = JSON.parse(xhr.responseText);
				if (response.success) {
					for (var i = 2; i < inputs.length; i++) {
						var cellValue = inputs[i].value;
						cells[i].innerHTML = cellValue;
					}
					var editButton = row.getElementsByClassName('edit-button')[0];
					var saveButton = row.getElementsByClassName('save-button')[0];
					editButton.style.display = 'block';
					saveButton.style.display = 'none';
				} else {
					alert('수정에 실패했습니다.');
				}
			}
		};
		xhr.send(formData); */
	}
</script>
</head>
<body>
	<h1>My Page</h1>

	<p>회원 ID : ${ID}</p>

	<%-- DB에 저장된 정보를 가져오는 코드 --%>
	<c:if test="${empty posts}">
		<p class="no-data">데이터가 없습니다.</p>
	</c:if>

	<div class="wrapper">
		<header>
			<!-- 이전 header 영역... -->
		</header>
		<main>
			<section>
				<div class="show--block">
					<!-- 이전 로그인한 회원 정보 영역... -->
					<h2>작성한 게시물 목록</h2>
					<div>
						<c:if test="${not empty posts}">
							<table border="1">
								<tr>
									<th>글 번호</th>
									<th>작성자</th>
									<th>내용</th>
									<th>작성날짜</th>
									<th>조회수</th>
									<th>좋아요</th>
									<th>수정</th>
									<th>삭제</th>
								</tr>
								<c:forEach items="${posts}" var="board">
									<tr id="row-${board.number}">
										<td>${board.number}</td>
										<td>${board.id}</td>
										<td class=contents>${board.contents}</td>
										<td>${board.date}</td>
										<td>${board.hits}</td>
										<td>${board.like}</td>
										<td>
											<button class="edit-button"
												onclick="editRow('${board.number}', '${board.contents}')">수정</button>
											<button class="save-button" style="display: none;"
												onclick="saveRow('${board.number}')">저장</button>
										</td>
								
										<td>

											<form action="board/delete.do" method="post">
												<!-- 삭제 기능을 수행하는 폼 추가 -->
												<input type="hidden" name="boardNumber"
													value="${board.number}" />
												<button type="submit">삭제</button>
											
											</form>
										</td>
									</tr>
								</c:forEach>
							</table>
						</c:if>
						<c:if test="${empty posts}">
							<!-- 작성한 게시물이 없을 때의 처리... -->
						</c:if>
					</div>
				</div>
			</section>
			<!-- 이전 section 영역... -->
		</main>
		<footer></footer>
	</div>
</body>
</html>