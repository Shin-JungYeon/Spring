<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ٱ���</title>
</head>
<body>
<h2>��ٱ���</h2>
<table>
	<tr>
		<td colspan="4">��ٱ��� ��ǰ ���</td></tr>
	<tr>
		<th>��ǰ��</th>
		<th>����</th>
		<th>����</th>
		<th>�հ�</th></tr>
	<c:set var="tot" value="${0 }"/>
	<c:forEach items="${cart.itemSetList }" var="itemSet" varStatus="stat">
	<tr>
		<td>${itemSet.item.name }</td>
		<td>${itemSet.item.price }</td>
		<td>${itemSet.quantity }</td>
		<td>${itemSet.item.price * itemSet.quantity }<a href="../cart/cartPop.shop?index=${stat.index }">��</a></td></tr>
	<c:set var="tot" value="${tot+(itemSet.item.price*itemSet.quantity) }"/>
	</c:forEach>
	<tr>
		<td colspan="4" align="right">�� ���� �ݾ� : ${tot }��</td></tr>
</table>
<br>
${message }
<br>
<a href="../item/list.shop">��ǰ���</a>&nbsp;
<a href="../cart/checkout.shop">�ֹ��ϱ�</a>
</body>
</html>