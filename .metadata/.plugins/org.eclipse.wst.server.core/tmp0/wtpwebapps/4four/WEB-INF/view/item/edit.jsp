<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ǰ ����</title>
</head>
<body>
<form:form modelAttribute="item" action="update.shop" enctype="multipart/form-data">
	<form:hidden path="id"/>
	<form:hidden path="pictureUrl"/>
	<h2>��ǰ ���� ����</h2>
	<table>
		<tr>
			<td>��ǰ��</td>
			<td><form:input path="name" maxlength="20"/></td>
			<td><font color="red"><form:errors path="name"/></font></td></tr>
		<tr>
			<td>��ǰ����</td>
			<td><form:input path="price" maxlength="20"/></td>
			<td><font color="red"><form:errors path="price"/></font></td></tr>
		<tr>
			<td>��ǰ�̹���</td>
			<td><input type="file" name="picture"/></td>
			<td>${item.pictureUrl }</td></tr>
		<tr>
			<td>��ǰ����</td>
			<td><form:textarea path="description" cols="20" rows="5"/></td>
			<td><font color="red"><form:errors path="description"/></font></td></tr>
		<tr>
			<td colspan="3">
				<input type="submit" value="���� ���">&nbsp;
				<input type="button" value="��ǰ ���" onclick="location.href='list.shop'"></td></tr>
	</table>
</form:form>
</body>
</html>