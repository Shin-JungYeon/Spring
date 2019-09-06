<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시글 수정</title>
<script type="text/javascript" src="http://cdn.ckeditor.com/4.5.7/full/ckeditor.js"></script>
<script>
	function file_delete(){
		document.f.fileurl.value="";
		file_desc.style.display = "none";
	}
</script>
</head>
<body>
<form:form modelAttribute="board" action="update.shop" enctype="multipart/form-data" name="f">
<form:hidden path="num"/>
<table>
	<tr><td>글쓴이</td><td><form:input path="name"/><font color="red"><form:errors path="name"/></font></td></tr>
	<tr><td>비밀번호</td><td><form:password path="pass"/><font color="red"><form:errors path="pass"/></font></td></tr>
	<tr><td>제목</td><td><form:input path="subject"/><font color="red"><form:errors path="subject"/></font></td></tr>
	<tr><td>내용</td><td><form:textarea path="content" rows="15" cols="80"/>
	<script>CKEDITOR.replace("content",{filebrowserImageUploadUrl:"imgupload.shop?CKEditorFuncNum=1"})</script>
	<font color="red"><form:errors path="content"/></font></td></tr>
	<tr><td>첨부파일</td>
		<td>
			<c:if test="${!empty board.fileurl }">
				<div id="file_desc">
					<a href="../file/${board.fileurl }">${board.fileurl }</a>
					<a href="javascript:file_delete()">[첨부파일삭제]</a>
				</div>
			</c:if>
			<form:hidden path="fileurl"/>
		<input type="file" name="file1" value="${board.fileurl }"></td></tr>
	<tr><td colspan="2"><a href="javascript:document.f.submit()">[게시글 등록]</a>&nbsp;
						<a href="list.shop">[게시글 목록]</a></td></tr>
</table>
</form:form>
</body>
</html>