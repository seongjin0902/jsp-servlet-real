<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="${pageContext.request.contextPath}/board/add.do">
		<div class="container">
			<h2>게시판 글쓰기</h2>
			<table class="table table-hover">
				<tbody>
					<tr>
						<td><input type="text" class="form-control"
							placeholder="글 제목" name="title" maxlength="40"></td>
					</tr>
					<tr>
						<td><textarea type="text" class="form-control"
								placeholder="글 내용을 작성하세요" name="contents" maxlength="1024"
								style="height: 400px;"></textarea></td>
					</tr>
				</tbody>
			</table>
			<input type="submit" class="btn btn-primary pull-right" value="글쓰기">
		</div>
	</form>
</body>
</html>