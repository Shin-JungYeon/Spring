<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>삭제 전 확인</title>
</head>
<body>
<h2> 삭제 전 확인 </h2>
<table>
	<tr>
		<td><img src="../img/${item.pictureUrl }" width="200" height="200"></td>
		<td>
			<table>
				<tr><td>상품명</td><td>${item.name }</td></tr>
				<tr><td>가격</td><td>${item.price }원</td></tr>
				<tr><td>상품설명</td><td>${item.description }</td></tr>
				<tr><td colspan="2">
							<input type="button" value="삭제확인" onclick="location.href='delete.shop?id=${item.id}'">
							<input type="button" value="상품목록" onclick="location.href='list.shop'"></td></tr>
			</table>
		</td></tr>
</table>
</body>
</html>