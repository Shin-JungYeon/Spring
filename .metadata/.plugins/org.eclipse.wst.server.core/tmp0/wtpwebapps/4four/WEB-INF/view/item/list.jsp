<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ǰ ���</title>
</head>
<body>
<a href="create.shop">��ǰ���</a>
<a href="../cart/cartView.shop" style="float:right;">��ٱ��� ����</a>
<table border="1" style="border-collapse: collapse;">
	<tr>
		<th width="80">��ǰID</th>
		<th width="320">��ǰ��</th>
		<th width="100">����</th>
		<th width="80">����</th>
		<th width="80">����</th></tr>
	<c:forEach items="${itemList }" var="item">
	<tr align="center">
		<td>${item.id }</td>
		<td><a href="detail.shop?id=${item.id }">${item.name }</a></td>
		<td><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="CURRENCY" pattern="��###,###" value="${item.price }"/>��</td>
		<td><a href="edit.shop?id=${item.id }">[����]</a></td>
		<td><a href="confirm.shop?id=${item.id }">[����]</a></td>
		
	</c:forEach>
</table>
</body>
</html>