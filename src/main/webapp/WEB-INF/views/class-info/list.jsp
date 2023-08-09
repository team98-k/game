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
<h3>게시판</h3>	
<select name="searchType" id="searchType">
	<option value="1">과목</option>
	<option value="2">교수님</option>
</select>
<input type="text" name="searchStr" placeholder="검색어" id="searchStr">
<button onclick="loadFunc()">검색</button>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">과목 이름</th>
				<th scope="col">과목 설명</th>
				<th scope="col">점수</th>
			</tr>
		</thead>
		<tbody id="tBody">
			<tr>
				<td colspan="4" align="right">
					<button type="button" class= "btn btn-primary" onclick="goPage('/classInfo-info/insert')">등록</button>
				</td>
			</tr>
		</tbody>
	</table>
</div>
<script>
	
	function goPage(url) {
		location.href=url;
	};
	const loadFunc = function(){
           const xhr = new XMLHttpRequest();
           const searchStr = document.querySelector('#searchStr');
           const searchType = document.querySelector('#searchType');
           
           let url = '/json/list?';
           if(searchStr.value!==''){
           	url += 'searchType=' + searchType.value + '&searchStr='+searchStr.value;
           }
           xhr.open('GET', '/class-info/list');
           xhr.onreadystatechange = function(){
               if(xhr.readyState==4){
                   if(xhr.status==200){
                       const obj = JSON.parse(xhr.responseText);
                       console.log(obj);
                       let html = '';
                       for(const classInfo of obj){
                           html += '<tr>';
                           html += '<td>'+classInfo.ciNum+'</td>';
                           html += '<td><a href="/views/class-info/view?ciNum='+classInfo.ciNum+'">'+ classInfo.ciName +'</a></td>';
                           html += '<td>'+classInfo.ciDesc+'</td>';
                           html += '<td>'+classInfo.ciProf+'</td>';
                           html += '<td>'+classInfo.score+'</td>';
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