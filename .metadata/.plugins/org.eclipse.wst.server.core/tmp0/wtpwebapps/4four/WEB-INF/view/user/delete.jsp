<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ��Ż�� Ȯ��</title>
</head>
<body>
<table>
	<tr><td>���̵�</td><td>${user.id }</td></tr>
	<tr><td>�̸���</td><td>${user.email }</td></tr>
</table>
<form action="delete.deco" method="post" name="deleteForm">
	<input type="hidden" name="id" value="${param.id }">
	��й�ȣ <input type="password" name="password"><br>
	<a href="javascript:deleteForm.submit()">[ȸ��Ż��]</a>
</form>
</body>
</html>