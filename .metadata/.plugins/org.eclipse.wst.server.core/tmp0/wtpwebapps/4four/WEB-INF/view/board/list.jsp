<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<fmt:formatDate value="${today }" var="today" pattern="yyyy-MM-dd"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ��� ���</title>
</head>
<body>
<table>
	<tr>
		<td colspan="5">
		<form action="list.shop" method="post" name="searchform">
			<input type="hidden" name="pageNum" value="1">
			<select name="searchType">
				<option value="" >�����ϼ���</option>
				<option value="subject" <c:if test="${param.searchType=='subject'}">selected="selected"</c:if>>����</option>
				<option value="name"    <c:if test="${param.searchType=='name'}">selected="selected"</c:if>>�ۼ���</option>
				<option value="content" <c:if test="${param.searchType=='content'}">selected="selected"</c:if>>����</option>
			</select>
			<input type="text" name="searchcontent" value="${param.searchcontent }" style="width:250px;">
			<input type="submit" value="�˻�">
		</form></td></tr>
	<c:if test="${listcount>0 }">
	<tr>
		<td colspan="4">Spring �Խ���</td><td>�۰���:${listcount }</td></tr>
	<tr>
		<td>��ȣ</td><td>����</td><td>�۾���</td><td>��¥</td><td>��ȸ��</td></tr>
	<c:forEach items="${boardlist }" var="b" varStatus="stat">
	<fmt:formatDate value="${b.regdate }" var="boardDate" pattern="yyyy-MM-dd"/>
	<tr>
		<td>${boardno-stat.index }</td>
		<td align="left">
			<c:if test="${!empty b.fileurl}"><a href="../file/${b.fileurl }">@</a></c:if>
			<c:if test="${empty b.fileurl }">&nbsp;&nbsp;&nbsp;</c:if>
			<c:forEach begin="1" end="${b.ref_level }">&nbsp;&nbsp;</c:forEach>
			<c:if test="${b.ref_level > 0 }">��</c:if>
			<a href="detail.shop?num=${b.num}">${b.subject }</a></td>
		<td>${b.name }</td>
		<td>
			<c:if test="${boardDate == today }"><fmt:formatDate value="${b.regdate }" pattern="yyyy-MM-dd HH:mm:ss"/></c:if>
			<c:if test="${boardDate != today }"><fmt:formatDate value="${b.regdate }" pattern="yyyy-MM-dd"/></c:if>
		</td>
		<td>${b.readcnt }</td></tr>
	</c:forEach>
	<tr>
		<td colspan="5">
		<c:if test="${param.searchType!=null && param.searchcontent!=null }">
			<c:set var="search" value="${&searchType=${param.searchType }&searchcontent=${param.searchcontent } }"/>
		</c:if>
		<c:if test="${pageNum>1 }"><a href="list.shop?pageNum=${pageNum - 1 }${search}">[����]</a></c:if>
		<c:if test="${pageNum<=1 }">[����]</c:if>
		<c:forEach var="a" begin="${startpage }" end="${endpage }">
			<c:if test="${a == pageNum }">[${a }]</c:if>
			<c:if test="${a != pageNum }"><a href="list.shop?pageNum=${a }${search}">[${a }]</a></c:if>
		</c:forEach>
		<c:if test="${pageNum<maxpage }"><a href="list.shop?pageNum=${pageNum + 1 }${search}">[����]</a></c:if>
		<c:if test="${pageNum>=1 }">[����]</c:if>
	</c:if>
	<c:if test="${listcount == 0 }">
		<tr>
			<td colspan="5">��ϵ� �Խù��� �����ϴ�.</td></tr>
	</c:if>
	<tr>
		<td colspan="5" align="right"><a href="write.shop">[�۾���]</a></td></tr>
</table>
</body>
</html>