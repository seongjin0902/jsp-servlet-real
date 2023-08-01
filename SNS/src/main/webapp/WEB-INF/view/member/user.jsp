<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- google icon cdn -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<!-- google icon style -->
<style>
.material-symbols-outlined {
  font-variation-settings:
  'FILL' 0,
  'wght' 400,
  'GRAD' -25,
  'opsz' 48;
  font-size:2rem;
}

.alarm_block{
	border : 1px solid;
	width:50px;height:50px;
	display:flex;
	justify-content:center;
	align-items:center;
	
	position:relative;
}
.alarm_block .dotted_bg{
	width:15px;height:15px;
	background-color:red;
	border-radius:50%;
	position:absolute;
	left:22px;
	top:12px;
	
	font-size:0.7rem;
	color:white;
	font-weight:700;
	text-align:center;
	line-height:15px;
}

.hide{
	display : none;
}

</style>


</head>
<body>
<h1>USER PAGE</h1>
ID : ${ID}
<br>

<div class="alarm_block">
	<c:if test="${not empty alarm_cnt}">
		<a href="javascript:showMsg()">
			<span class="dotted_bg">${alarm_cnt } </span>
		</a>
	</c:if>
	<span class="material-symbols-outlined">
	notifications
	</span>
</div>


<h3>대여 내역 조회(비동기 요청)</h3>
<button class=lend_btn class="width:500px; border : 1px solid;">조회하기</button>
<div class="mylendList">

</div>
<hr/>
<!-- axios cdn -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.4.0/axios.min.js" integrity="sha512-uMtXmF28A2Ab/JJO2t/vYhlaa/3ahUOgj1Zf27M5rOo8/+fcTUVH0/E0ll68njmjrLqOBjXM3V9NiPFL5ywWPQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
const projectPath='${pageContext.request.contextPath}';
const ServerPort = '${pageContext.request.serverPort}';
const ServerHost = '<%=request.getLocalAddr()%>';

	function showMsg(){
		const list = '${alarm_list}';
		console.log("list",list);
		alert(list);
		

		console.log("serverHost : " , ServerHost);
		const params = {params :{'userid': '${ID}' } }
		axios.post("http://"+ServerHost+':'+ServerPort+projectPath+'/lend/messageRemove.do',null,params)
		.then(response=>{ 
			
			alert("success");
			console.log("response.data : ",typeof response.data);
			if(response.data===true){
				const dotted_bg_el =document.querySelector('.dotted_bg');
				dotted_bg_el.classList.add("hide");	
			}
			
			
		})
		.catch(error=>{alert("error");})
		
	}


	function formatDate(date) {
		  const year = date.getFullYear();
		  const month = String(date.getMonth() + 1).padStart(2, '0');
		  const day = String(date.getDate()).padStart(2, '0');
		  console.log(year,month,day);
		  
		  return year+"-"+month+"-"+day;
		}
	
	const lend_btn_el = document.querySelector('.lend_btn');
	lend_btn_el.addEventListener('click',function(){
			
		axios.get("http://"+ServerHost+':'+ServerPort+projectPath+'/lend/search.do')
		.then(response=>{
			console.log('response',response);
			
			 
			const mylendList_el = document.querySelector('.mylendList');
			const list = response.data;
			list.forEach((dto)=>{
			
				console.log('dto',dto);
					
				const dto_el = document.createElement('div');
				dto_el.classList.add("item");
				
				dto_el.innerHTML+="<span>"+dto.lendId+"</span> ";
				dto_el.innerHTML+="<span>"+dto.bookcode+"</span> ";
				dto_el.innerHTML+="<span>"+dto.id+"</span> ";
				dto_el.innerHTML+="<span>"+ formatDate(new Date(dto.lendDate))+"</span> | ";
				dto_el.innerHTML+="<span>"+ formatDate(new Date(dto.returnDate))+"</span><br/>";
				mylendList_el.appendChild(dto_el);	
				
			}) 
			
			
			
		})
		.catch(error=>{console.log('error',error)})
	})
	

		
</script>


<h3>나의 정보 확인(비동기 요청)</h3>
<hr/>
ServerHost : <%=request.getLocalAddr()%><br/>
<a href="javascript:history.go(-1)">이전으로</a>
</body>
</html>