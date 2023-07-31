<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.wrapper{}
	.wrapper>.show_block{
		width : 1800px;
		display:flex;
		justify-content : center;
		align-items : center;
		border : 1px solid gray;
		margin : 100px auto;	
	}
	.wrapper>.show_block>*{
		margin : 50px;
		width : 500px;
		height : 500px;
		border : 1px solid gray;
		position:relative;
	}
	.wrapper>.show_block>*::before{	
		position:absolute;
		top:-20px;
		left : 240px;
	}
	
	.wrapper>.show_block>.c_total{}
	.wrapper>.show_block>.c_user{}
	.wrapper>.show_block>.c_admin{}
</style>


<!-- chart.js -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<!-- drawchart.js  -->
<script src="resources/js/drawchart.js" defer></script>
<script src="resources/js/TodayChart.js" defer></script>
</head>
<body>
TODAY_LOG : TOTAL : ${todayLog.total}  USER : ${todayLog.user } MEMBER : ${todayLog.member} DATE : ${todayLog.date}  <br/>
<div class=wrapper>

	<h1>ADMIN DASHBoard</h1>
	<hr>
	<a href="javascript:history.go(-1)">이전으로</a>
	<hr>
	<div class="show_block">
		<div class=c_total >
			<canvas id="total"></canvas>
		</div>
		<div class=c_user  >
			<canvas id=user></canvas>
		</div>
		<div class=c_member  >
			<canvas id=member></canvas>
		</div>
	</div>
</div>

<script defer>
	
	/* 랜더링 될때 Chart표시하기  */
	document.addEventListener("DOMContentLoaded",function(){
	
		/* today  */
		const todayTotal = '${todayLog.total}';
		const todayUser = '${todayLog.user}';
		const todayMember = '${todayLog.member}';
		const todayDate = '${todayLog.date}';
		const todayobj = { 'total' : todayTotal, 'user' : todayUser,'member':todayMember,'date':todayDate};
		todayChart( todayobj , 'total')
		/*  */
		chartByData('user')
		/*  */
		chartByData('member')
	})
</script>

</body>
</html>