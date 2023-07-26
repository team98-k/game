<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>GAME</h3>
	<c:if test="${user!=null}">
	${user.uiNum}님 안녕하세요.
	<a href="/user-info/list">유저 정보</a>
	<button onclick="location.href='/user-info/logout'">로그아웃</button>
	</c:if>
	<c:if test="${user==null}">
	<button onclick="location.href='/user-info/login'">로그인</button>
	</c:if>
</body>
</html>