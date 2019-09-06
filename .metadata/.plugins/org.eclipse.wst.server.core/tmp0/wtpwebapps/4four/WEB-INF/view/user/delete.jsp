<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원탈퇴 확인</title>
</head>
<body>
<table>
	<tr><td>아이디</td><td>${user.id }</td></tr>
	<tr><td>이메일</td><td>${user.email }</td></tr>
</table>
<form action="delete.deco" method="post" name="deleteForm">
	<input type="hidden" name="id" value="${param.id }">
	비밀번호 <input type="password" name="password"><br>
	<a href="javascript:deleteForm.submit()">[회원탈퇴]</a>
</form>
</body>
</html>