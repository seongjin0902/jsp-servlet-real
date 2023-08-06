<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>메인이에옹</h1>
ID : ${ID} <br/>
ROLE : ${ROLE}<br/>
<hr>

<c:if test="${not empty ROLE}">
	<a href=<c:url value="/logout.do" /> >LOGOUT</a></br>
</c:if>

<hr/>
<div class=msg>
${msg}
</div>

EL's Project PATH : ${pageContext.request.contextPath}<br/>
EL's Project ServerPort :${pageContext.request.serverPort}<br/>
<%
	int port = request.getServerPort();
%>


</body>
</html>