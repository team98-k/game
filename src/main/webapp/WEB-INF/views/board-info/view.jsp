<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp" />
</head>
<body>
<div class="container">
<h3>게시물 보기</h3>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th scope="col">번호</th>
				<td id="biNum">${param.biNum}</td>
			</tr>
			<tr>
				<th scope="col">제목</th>
				<td id="biTitle"></td>
			</tr>
			<tr>
				<th scope="col">내용</th>
				<td id="biContent"></td>
			</tr>
			<tr>
				<th scope="col">작성자</th>
				<td id="uiNum"></td>
			</tr>
			<tr>
				<th scope="col">작성일</th>
				<td id="credat"></td>
			</tr>
				<tr>
					<th colspan="2">
						<button type="button" onclick="goPage('/board-info/update?biNum=${board.biNum}')">수정</button>
						<button>삭제</button>
					</th>
				</tr>
		</thead>
	</table>
</div>
<script>
	function goPage(url) {
		location.href = url;
	};
	const loadFunc = function(){
		const xhr = new XMLHttpRequest();
		 xhr.open('GET', '/json/one?biNum=${param.biNum}');
		 xhr.onreadystatechange = function(){
			 if(xhr.readyState === 4){
				 if(xhr.status === 200){
					 const board = JSON.parse(xhr.responseText);
					 for(let key in board){
						 console.log(key, board[key]);
						 if(document.querySelector('#' + key)){
							 document.querySelector('#' + key).innerHTML = board[key];
						 }
					 }
				 }
			 }
		 }
		 xhr.send();
	};
	window.addEventListener('load', loadFunc);
</script>
</body>
</html>