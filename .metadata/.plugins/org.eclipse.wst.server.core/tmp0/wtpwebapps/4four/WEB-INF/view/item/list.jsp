<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>상품 목록</title>
</head>
<body>
<a href="create.shop">상품등록</a>
<a href="../cart/cartView.shop" style="float:right;">장바구니 보기</a>
<table border="1" style="border-collapse: collapse;">
	<tr>
		<th width="80">상품ID</th>
		<th width="320">상품명</th>
		<th width="100">가격</th>
		<th width="80">수정</th>
		<th width="80">삭제</th></tr>
	<c:forEach items="${itemList }" var="item">
	<tr align="center">
		<td>${item.id }</td>
		<td><a href="detail.shop?id=${item.id }">${item.name }</a></td>
		<td><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="CURRENCY" pattern="￦###,###" value="${item.price }"/>원</td>
		<td><a href="edit.shop?id=${item.id }">[수정]</a></td>
		<td><a href="confirm.shop?id=${item.id }">[삭제]</a></td>
		
	</c:forEach>
</table>
</body>
</html>