<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판 삭제 화면</title>
</head>
<body>
<form:form modelAttribute="board" action="delete.shop" name="f" method="post">
	<form:hidden path="num"/>
	
<table id="list">
	<caption>MODEL1 게시글 삭제 화면</caption>
	<tr>
		<td>게시글 비밀번호</td>
		<td><form:password path="pass"/></td></tr>
	<tr>
		<td colspan="2"><input type="submit" value="게시글삭제"></td>
</table>
</form:form>
</body>
</html>