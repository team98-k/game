<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>유저 업데이트</h3>
<form method="POST" action="/user-info/update">
<input type="hidden" name="uiNum" value="${userUpdate.uiNum}">
아이디 : <input type="text" name="uiId" value="${userUpdate.uiId}" disabled="disabled"><br>
비밀번호 : <input type="text" name="uiPwd" value="${userUpdate.uiPwd}"><br>
이름 : <input type="text" name="uiName" value="${userUpdate.uiName}"><br>
생년월일 : <input type="date" name="uiBirth" value="${userUpdate.uiBirth}"><br>
소개 : <textarea name="uiDesc">${userUpdate.uiDesc}</textarea><br>
<button>수정</button>
</form>
</body>
</html>