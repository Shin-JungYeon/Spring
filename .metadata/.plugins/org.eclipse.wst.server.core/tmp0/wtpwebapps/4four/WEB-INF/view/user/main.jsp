<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ����</title>
</head>
<body>
<h2> ȯ���մϴ�. ${sessionScope.loginUser.id }��</h2>
<a href="mypage.deco?id=${loginUser.id }">mypage</a><br>
<a href="logout.deco">�α׾ƿ�</a>
</body>
</html>