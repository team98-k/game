<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원 등록</h3>
<input type="text" id="uiId" placeholder="아이디"><br>
<input type="text" id="uiName" placeholder="이름"><br>
<input type="password" id="uiPwd" placeholder="비밀번호"><br>
<textarea id="uiDesc" placeholder="소개"></textarea><br>
<input type="date" id="uiBirth" placeholder="생년월일"><br>
<button onclick="sendObj()">등록</button>
<script>
	function sendObj(){
		const param = {
				uiId : document.querySelector('#uiId').value,
				uiName : document.querySelector('#uiName').value,
				uiPwd : document.querySelector('#uiPwd').value,
				uiDesc : document.querySelector('#uiDesc').value,
				uiBirth : document.querySelector('#uiBirth').value
		}
		const json = JSON.stringify(param);
		const xhr = new XMLHttpRequest();
		xhr.open('POST', '/user-info/insert');
		xhr.setRequestHeader('Content-Type','application/json');
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					console.log(xhr.resposeText);
					location.href = '/views/user-info/list';
				}
			}
		}
		xhr.send(json);
	}
</script>
</body>
</html>