<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
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

    th,
    td {
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
<script>
    function toggleEditForm(boardNumber) {
        var row = document.getElementById('row-' + boardNumber);
        var contentCell = row.getElementsByClassName('content-cell')[0];
        var editForm = row.getElementsByClassName('edit-form')[0];
        var contentInput = editForm.getElementsByTagName('input')[0];
        var editButton = row.getElementsByClassName('edit-button')[0];
        var saveButton = row.getElementsByClassName('save-button')[0];

        if (contentCell.style.display === 'none') {
            contentCell.style.display = 'table-cell';
            editForm.style.display = 'none';
            editButton.style.display = 'block';
            saveButton.style.display = 'none';
        } else {
            contentCell.style.display = 'none';
            editForm.style.display = 'table-cell';
            contentInput.value = contentCell.innerText.trim();
            editButton.style.display = 'none';
            saveButton.style.display = 'block';
        }
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

    <c:if test="${not empty posts}">
        <table border="1">
            <tr>
                <th>글 번호</th>
                <th>작성자</th>
                <th>글 내용</th>
                <th>작성날짜</th>
                <th>조회수</th>
                <th>좋아요</th>
                <th>수정</th>
            </tr>
            <c:forEach var="board" items="${posts}">
                <tr id="row-${board.number}">
                    <td>${board.number}</td>
                    <td>${board.id}</td>
                    <td class="content-cell">${board.contents}</td>
                    <td>${board.date}</td>
                    <td>${board.hits}</td>
                    <td>${board.like}</td>
                    <td>
                        <button class="edit-button" onclick="toggleEditForm('${board.number}')">수정</button>
                        <button class="save-button" style="display: none;" onclick="toggleEditForm('${board.number}')">저장</button>
                        <div class="edit-form">
                            <input type="text">
                            <button class="cancel-button" onclick="toggleEditForm('${board.number}')">취소</button>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
