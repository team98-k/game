<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
번호 : <span id ="num">${param.num}</span><br>
이름 : <input type="text" id="name"><br>
나이 : <input type="text" id="age"><br>
주소 : <input type="text" id="address"><br>
<button onclick="updateObj()">수정</button>
<script>
function updateObj(){
	const param = {
			num : document.querySelector('#num').value,
			name : document.querySelector('#name').value,
			age : document.querySelector('#age').value,
			address : document.querySelector('#address').value
		}
	const json = JSON.stringify(param);
	const xhr = new XMLHttpRequest();
	xhr.open('POST', '/list/update?num=${param.num}');
	xhr.setRequestHeader('Content-Type', 'application/json');
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				if(xhr.responseText === '1'){
					alert('수정 완료!');
				}else{
					alert('이미 수정된 데이터입니다.');						
				}
				location.href='/views/list';
			}
		}
	}
	xhr.send(json);
}
window.addEventListener('load', function(){
	const xhr = new XMLHttpRequest();
	xhr.open('GET', '/list/one?num='+${param.num});
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				const obj = JSON.parse(xhr.responseText);
				for(const key in obj){
					document.querySelector('#'+key).value = obj[key];
				}
			}
		}
	}
	xhr.send();
})
</script>
</body>
</html>