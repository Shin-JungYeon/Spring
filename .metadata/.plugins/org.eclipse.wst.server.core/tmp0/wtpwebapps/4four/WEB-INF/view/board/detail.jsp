<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խù� �� ����</title>
</head>
<body>
<table>
	<tr><td>Spring �Խ���</td><td>��ȸ��:${board.readcnt }</td></tr>
	<tr><td width="15%">�۾���</td><td width="85%">${board.name }</td></tr>
	<tr><td width="15%">����</td><td width="85%">${board.subject }</td></tr>
	<tr><td width="15%">����</td><td width="85%"><table><tr><td>${board.content }</td></tr></table></td></tr>
	<tr><td>÷������</td><td>&nbsp;<c:if test="${!empty board.fileurl }"><a href="../file/${board.fileurl }">${board.fileurl }</a></c:if></td></tr>
	<tr><td colspan="2">
	<a href="reply.shop?num=${board.num }">[�亯]</a>&nbsp;
	<a href="update.shop?num=${board.num }">[����]</a>&nbsp;
	<a href="delete.shop?num=${board.num }">[����]</a>&nbsp;
	<a href="list.shop?num=${board.num }">[�Խù� ���]</a>
	</td></tr>
	
	
</table>
</body>
</html>