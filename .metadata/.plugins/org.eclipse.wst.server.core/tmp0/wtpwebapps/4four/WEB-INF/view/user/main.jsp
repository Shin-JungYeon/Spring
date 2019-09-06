<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 정보</title>
</head>
<body>
<h2> 환영합니다. ${sessionScope.loginUser.id }님</h2>
<a href="mypage.deco?id=${loginUser.id }">mypage</a><br>
<a href="logout.deco">로그아웃</a>
</body>
</html>