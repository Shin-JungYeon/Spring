<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ǰ �� ����</title>
</head>
<body>
<h2> ��ǰ �� </h2>
<table>
	<tr>
		<td><img src="../img/${item.pictureUrl }" width="200" height="200"></td>
		<td>
			<table>
				<tr><td>��ǰ��</td><td>${item.name }</td></tr>
				<tr><td>����</td><td>${item.price }��</td></tr>
				<tr><td>��ǰ����</td><td>${item.description }</td></tr>
				<tr><td colspan="2">
						<form action="../cart/cartAdd.shop">
							<input type="hidden" name="id" value="${item.id }">
							<table>
								<tr>
									<td>
										<select name="quantity">
											<c:forEach begin="1" end="10" var="i">
												<option>${i }</option>
											</c:forEach>
										</select>
									</td>
									<td><input type="submit" value="��ٱ���">
										<input type="button" value="��ǰ���" onclick="location.href='list.shop'">
							</table>
						</form>
			</table>
		</td></tr>
</table>
</body>
</html>