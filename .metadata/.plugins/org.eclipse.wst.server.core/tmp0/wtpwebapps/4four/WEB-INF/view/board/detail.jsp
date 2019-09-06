<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시물 상세 보기</title>
</head>
<body>
<table>
	<tr><td>Spring 게시판</td><td>조회수:${board.readcnt }</td></tr>
	<tr><td width="15%">글쓴이</td><td width="85%">${board.name }</td></tr>
	<tr><td width="15%">제목</td><td width="85%">${board.subject }</td></tr>
	<tr><td width="15%">내용</td><td width="85%"><table><tr><td>${board.content }</td></tr></table></td></tr>
	<tr><td>첨부파일</td><td>&nbsp;<c:if test="${!empty board.fileurl }"><a href="../file/${board.fileurl }">${board.fileurl }</a></c:if></td></tr>
	<tr><td colspan="2">
	<a href="reply.shop?num=${board.num }">[답변]</a>&nbsp;
	<a href="update.shop?num=${board.num }">[수정]</a>&nbsp;
	<a href="delete.shop?num=${board.num }">[삭제]</a>&nbsp;
	<a href="list.shop?num=${board.num }">[게시물 목록]</a>
	</td></tr>
	
	
</table>
</body>
</html>