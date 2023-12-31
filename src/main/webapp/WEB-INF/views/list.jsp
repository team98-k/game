<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	tr.link{
		background-color: white;
		color:black;
		coursor:pointer;
	}
	tr.link:hover{
		color:green;
		coursor:pointer;
	}
</style>
</head>
<body>
	<button onclick="location.href='/views/insert'">등록</button>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>주소</th>
		</tr>
		<tbody id="tBody">
		</tbody>
	</table>
	<script type="text/javascript">
	function goPage(num){
		location.href  = '/views/one?num='+num;
	};
	function loadFunc(){
		const xhr = new XMLHttpRequest();
	    xhr.open('GET', '/list');
	    xhr.onreadystatechange = function(){
	        if(xhr.readyState==4){
	            if(xhr.status==200){
	                const list = JSON.parse(xhr.responseText);
	                let html = '';
	                for(const map of list){
	                    html += '<tr class="link" onclick="goPage('+map.num+')">';
	                    html += '<td>'+map.num+'</td>';
	                    html += '<td>'+map.name+'</td>';
	                    html += '<td>'+map.age+'</td>';
	                    html += '<td>'+map.address+'</td>';
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