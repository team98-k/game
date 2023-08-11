<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
	<div class="container">
	<h3>유저 정보</h3>	
	<select name="searchType" id="searchType">
		<option value="1">이름</option>
		<option value="2">아이디</option>
	</select>
	<input type="text" name="searchStr" placeholder="검색어" id="searchStr">
	<button onclick="loadFunc()">검색</button>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>유저 번호</th>
					<th>유저 이름</th>
					<th>유저 아이디</th>
				</tr>
			</thead>
			<tbody id="tBody">
			</tbody>
		</table>
	<div align="right">
		<a href="/views/user-info/insert">등록</a>		
	</div>
	</div>
<script type="text/javascript">
	const loadFunc = function(){
	    const xhr = new XMLHttpRequest();
	    
	    xhr.open('GET', '/user-info/list');
	    xhr.onreadystatechange = function(){
	        if(xhr.readyState==4){
	            if(xhr.status==200){
	                const obj = JSON.parse(xhr.responseText);
	                console.log(obj);
	                let html = '';
	                for(const userInfo of obj){
	                    html += '<tr>';
	                    html += '<td>'+userInfo.uiNum+'</td>';
	                    html += '<td>'+userInfo.uiName+'</td>';
	                    html += '<td>'+userInfo.uiId+'</td>';
	                    html += '</tr>';
	                }
	                document.querySelector('#tBody').innerHTML = html;
	            }
	        }
	    }
	    xhr.send();
	};
	window.addEventListener('load', loadFunc);
</script>
</body>
</html>