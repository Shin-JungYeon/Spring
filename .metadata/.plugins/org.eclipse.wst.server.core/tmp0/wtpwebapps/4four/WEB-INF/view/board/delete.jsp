<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ��� ���� ȭ��</title>
</head>
<body>
<form:form modelAttribute="board" action="delete.shop" name="f" method="post">
	<form:hidden path="num"/>
	
<table id="list">
	<caption>MODEL1 �Խñ� ���� ȭ��</caption>
	<tr>
		<td>�Խñ� ��й�ȣ</td>
		<td><form:password path="pass"/></td></tr>
	<tr>
		<td colspan="2"><input type="submit" value="�Խñۻ���"></td>
</table>
</form:form>
</body>
</html>