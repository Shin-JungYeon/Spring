<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����������</title>
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
<h2>${user.id }���� �������Դϴ�.</h2>
<table>
	<tr>
		<td id="tab1" class="tab"><a href="javascript:disp_div('minfo','tab1')">ȸ����������</a></td>
<%-- 		<c:if test="${user.id != 'admin' }"> --%>
		
<!-- 		<td id="tab2" class="tab"><a href="javascript:disp_div('oinfo','tab2')">�ֹ���������</a></td> -->
<%-- 		</c:if></tr> --%>
	</tr>
</table>
<!-- <div id="oinfo" class="info" style="display:none; width:100%;"> -->
<!-- 	<table> -->
<!-- 		<tr> -->
<!-- 			<td colspan="3" align="center"><b>�ֹ� ���</b></td></tr> -->
<!-- 		<tr> -->
<!-- 			<th>�ֹ� ��ȣ</th><th>�ֹ� ����</th><th>�� �ֹ��ݾ�</th></tr> -->
<%-- 		<c:forEach items="${salelist }" var="sale" varStatus="stat"> --%>
<!-- 		<tr> -->
<%-- 			<td align="center"><a href="javascript:list_disp('saleLine${stat.index }')">${sale.saleId }</a></td> --%>
<%-- 			<td align="center"><fmt:formatDate value="${sale.updatetime }" pattern="yyyy-MM-dd"/></td> --%>
<%-- 			<td align="right">${sale.totAmount }��</td></tr> --%>
<%-- 		<tr id="saleLine${stat.index }" class="saleLine"> --%>
<!-- 			<td colspan="3" align="center"> -->
<!-- 				<table> -->
<!-- 					<tr> -->
<!-- 						<th width="25%">��ǰ��</th> -->
<!-- 						<th width="25%">��ǰ����</th> -->
<!-- 						<th width="25%">���ż���</th> -->
<!-- 						<th width="25%">��ǰ�Ѿ�</th></tr> -->
<%-- 					<c:forEach items="${sale.itemList }" var="saleItem"> --%>
<!-- 					<tr> -->
<%-- 						<td align="center" class="title">${saleItem.item.name }</td> --%>
<%-- 						<td align="right">${saleItem.item.price }��</td> --%>
<%-- 						<td align="right">${saleItem.quantity }��</td> --%>
<%-- 						<td align="right">${saleItem.item.price * saleItem.quantity }��</td></tr> --%>
<%-- 					</c:forEach> --%>
<!-- 				</table></td></tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</table> -->
<!-- </div> -->
<div id="minfo" class="info">
	<table>
		<tr><td colspan="2">ȸ�� ����</td></tr>
		<tr><td>���̵�</td><td>${user.id }</td></tr>
		<tr><td>�̸���</td><td>${user.email }</td></tr>
	</table><br>
<%--
	1. �α��� ����, ���� ������ ���� �����ϵ��� �ϱ�.
	2. id�� �ش��ϴ� ������ db���� �б�
	3. update.jsp(��ȿ�� ����) �������� �̵�
 --%>
	<a href="update.deco?id=${user.id }">[ȸ����������]</a>&nbsp;
<%-- 	<c:if test="${loginUser.userId != 'admin' }"> --%>
		<a href="delete.deco?id=${user.id }">[ȸ��Ż��]</a>&nbsp;
<%-- 	</c:if> --%>
	<c:if test="${loginUser.id == 'admin' }">
		<a href="../admin/list.deco">[ȸ�����]</a>&nbsp;
	</c:if>
</div>
</body>
</html>