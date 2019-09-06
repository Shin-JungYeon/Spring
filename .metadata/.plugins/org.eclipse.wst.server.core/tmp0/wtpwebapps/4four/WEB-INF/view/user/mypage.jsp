<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>마이페이지</title>
<script>
	$(document).ready(function(){
		$("#minfo").show();
		$("#oinfo").hide();
		$(".saleLine").each(function(){
			$(this).hide();
		})
		$("#tab1").addClass("select");
	})
	function disp_div(id,tab){
		$(".info").each(function(){
			$(this).hide();
		})
		$(".tab").each(function(){
			$(this).removeClass("select");
		})
		$("#"+id).show();
		$("#"+tab).addClass("select");
	}
	function list_disp(id){
		$("#"+id).toggle();
	}
</script>
<style>
	.select {
		padding:3px;
		text-decoration:none; font-weight:bold;
		background-color: lightblue;
	}
	.select>a{
		color:white;
	}
</style>
</head>
<body>
<h2>MY PAGE</h2>
<h2>${user.id }님의 페이지입니다.</h2>
<table>
	<tr>
		<td id="tab1" class="tab"><a href="javascript:disp_div('minfo','tab1')">회원정보보기</a></td>
<%-- 		<c:if test="${user.id != 'admin' }"> --%>
		
<!-- 		<td id="tab2" class="tab"><a href="javascript:disp_div('oinfo','tab2')">주문정보보기</a></td> -->
<%-- 		</c:if></tr> --%>
	</tr>
</table>
<!-- <div id="oinfo" class="info" style="display:none; width:100%;"> -->
<!-- 	<table> -->
<!-- 		<tr> -->
<!-- 			<td colspan="3" align="center"><b>주문 등록</b></td></tr> -->
<!-- 		<tr> -->
<!-- 			<th>주문 번호</th><th>주문 일자</th><th>총 주문금액</th></tr> -->
<%-- 		<c:forEach items="${salelist }" var="sale" varStatus="stat"> --%>
<!-- 		<tr> -->
<%-- 			<td align="center"><a href="javascript:list_disp('saleLine${stat.index }')">${sale.saleId }</a></td> --%>
<%-- 			<td align="center"><fmt:formatDate value="${sale.updatetime }" pattern="yyyy-MM-dd"/></td> --%>
<%-- 			<td align="right">${sale.totAmount }원</td></tr> --%>
<%-- 		<tr id="saleLine${stat.index }" class="saleLine"> --%>
<!-- 			<td colspan="3" align="center"> -->
<!-- 				<table> -->
<!-- 					<tr> -->
<!-- 						<th width="25%">상품명</th> -->
<!-- 						<th width="25%">상품가격</th> -->
<!-- 						<th width="25%">구매수량</th> -->
<!-- 						<th width="25%">상품총액</th></tr> -->
<%-- 					<c:forEach items="${sale.itemList }" var="saleItem"> --%>
<!-- 					<tr> -->
<%-- 						<td align="center" class="title">${saleItem.item.name }</td> --%>
<%-- 						<td align="right">${saleItem.item.price }원</td> --%>
<%-- 						<td align="right">${saleItem.quantity }개</td> --%>
<%-- 						<td align="right">${saleItem.item.price * saleItem.quantity }원</td></tr> --%>
<%-- 					</c:forEach> --%>
<!-- 				</table></td></tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</table> -->
<!-- </div> -->
<div id="minfo" class="info">
	<table>
		<tr><td colspan="2">회원 정보</td></tr>
		<tr><td>아이디</td><td>${user.id }</td></tr>
		<tr><td>이메일</td><td>${user.email }</td></tr>
	</table><br>
<%--
	1. 로그인 상태, 본인 계정만 수정 가능하도록 하기.
	2. id에 해당하는 정보를 db에서 읽기
	3. update.jsp(유효성 검증) 페이지로 이동
 --%>
	<a href="update.deco?id=${user.id }">[회원정보수정]</a>&nbsp;
<%-- 	<c:if test="${loginUser.userId != 'admin' }"> --%>
		<a href="delete.deco?id=${user.id }">[회원탈퇴]</a>&nbsp;
<%-- 	</c:if> --%>
	<c:if test="${loginUser.id == 'admin' }">
		<a href="../admin/list.deco">[회원목록]</a>&nbsp;
	</c:if>
</div>
</body>
</html>