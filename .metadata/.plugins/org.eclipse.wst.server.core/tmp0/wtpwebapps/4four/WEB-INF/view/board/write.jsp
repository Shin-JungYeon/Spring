<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խñ� �ۼ�</title>
<script type="text/javascript" src="http://cdn.ckeditor.com/4.5.7/full/ckeditor.js"></script>
</head>
<body>
<form:form modelAttribute="board" action="write.shop" enctype="multipart/form-data" name="f">
<table>
	<tr><td>�۾���</td><td><form:input path="name"/><font color="red"><form:errors path="name"/></font></td></tr>
	<tr><td>��й�ȣ</td><td><form:password path="pass"/><font color="red"><form:errors path="pass"/></font></td></tr>
	<tr><td>����</td><td><form:input path="subject"/><font color="red"><form:errors path="subject"/></font></td></tr>
	<tr><td>����</td><td><form:textarea path="content" rows="15" cols="80"/>
	<script>CKEDITOR.replace("content",{filebrowserImageUploadUrl:"imgupload.shop?CKEditorFuncNum=1"})</script>
	<font color="red"><form:errors path="content"/></font></td></tr>
	<tr><td>÷������</td><td><input type="file" name="file1"></td></tr>
	<tr><td colspan="2"><a href="javascript:document.f.submit()">[�Խñ� ���]</a>&nbsp;
						<a href="list.shop">[�Խñ� ���]</a></td></tr>
</table>
</form:form>
</body>
</html>