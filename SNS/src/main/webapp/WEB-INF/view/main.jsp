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

<h1>MAIN</h1>
Account : ${ID} <br/>
Role : ${ROLE} <br/>
<hr>
<!-- 나의 메뉴이동 -->
<c:if test="${not empty ROLE}">
	<a href=<c:url value="/mypage.do" /> >나의메뉴로 이동</a></br>
</c:if>


<!-- 도서 조회하기 -->
<hr>
<div>
	<div class="search_block">
		<input placeholder="keyfield" />
		<input placeholder="keyword" />
		<button class=search_btn>조회</button>
	</div>
	<div class="show_block" style="width:500px;height:500px;border:1px solid;overflow:auto;">
	
	</div>
</div>

<hr>


<hr/>
<c:if test="${empty ROLE}">
	<a href="${pageContext.request.contextPath}/login.do"  >LOGIN</a></br>
</c:if>
<c:if test="${not empty ROLE}">
	<a href="${pageContext.request.contextPath}/logout.do" > >LOGOUT</a></br>
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

<!-- axios cdn -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.4.0/axios.min.js" integrity="sha512-uMtXmF28A2Ab/JJO2t/vYhlaa/3ahUOgj1Zf27M5rOo8/+fcTUVH0/E0ll68njmjrLqOBjXM3V9NiPFL5ywWPQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
	const search_btn_el=document.querySelector('.search_btn');
	search_btn_el.addEventListener('click',function(){
		const projectPath='${pageContext.request.contextPath}';
		const ServerPort = '${pageContext.request.serverPort}';
		console.log("search_btn_el click..",projectPath);
		
		
		const show_block_el = document.querySelector('.show_block');
		//ajax , fetch , promise , axios 선택해서 비동기 요청
		//axios Cdn 연결이후에 작업하세요(https://cdnjs.com/libraries/axios)	
		axios.get("http://192.168.2.254:"+ ServerPort + projectPath +"/book/search.do")
		.then(response=>{ 
			console.log("success!",response.data); 
			const list = response.data;
			
		
			
			list.forEach((dto)=>{
			
				console.log('dto',dto);
				const dto_el = document.createElement('div');
				dto_el.classList.add("item");
				
				dto_el.innerHTML+="<span>"+dto.bookcode+"</span> ";
				dto_el.innerHTML+="<span>"+dto.bookname+"</span> ";
				dto_el.innerHTML+="<span>"+dto.isbn+"</span> ";
				dto_el.innerHTML+="<span>"+dto.publisher+"</span><br/>";
				show_block_el.appendChild(dto_el);
				
			})
			
			
		})
		.catch(error=>{ console.log("fail.."); })	//실패시 처리로직
		
	})
</script>





</body>
</html>