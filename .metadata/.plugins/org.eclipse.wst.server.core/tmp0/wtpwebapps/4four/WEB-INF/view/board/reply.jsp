<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<%--
   1. �Ķ���ͷ� �ش� �ۿ� ���� num ���� �޾ƿ�.
   2. ������ num,ref,ref_level,ref_step ������ ����
   3. �Է� ȭ���� �����
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ��� ��� ����</title>

</head>
<body>
<form:form modelAttribute="board" action="reply.shop" method="post" name="f">
<%-- ���� ���� : num, ref reflevel refstep : ������ ����.(��� �����ϴ���, ������ ������ step) --%>
   <form:hidden path="num"/>
   <form:hidden path="ref"/>
   <form:hidden path="ref_level"/>
   <form:hidden path="ref_step"/>
<table id="list">
   <caption>MODEL2 �Խ��� ��� ���</caption>
   <tr>
      <td>�۾���</td>
      <td><form:input path="name" value="&nbsp;"/><font color="red"><form:errors path="name"/></font></td></tr>
   <tr>
      <td>��й�ȣ</td>
      <td><form:password path="pass"/><font color="red"><form:errors path="pass"/></font></td></tr>
   <tr>
      <td>����</td>
      <td><form:input path="subject" value="RE:${board.subject }"/><font color="red"><form:errors path="subject"/></font></td></tr>
   <tr>
      <td>����</td>
      <td><textarea name="content" rows="15" cols="80"></textarea>
      <script>CKEDITOR.replace("content",{filebrowserImageUploadUrl:"imgupload.shop?CKEditorFuncNum=1"})</script>
      <font color="red"><form:errors path="content"/></font></td></tr>
   <tr>
      <td colspan="2"><a href="javascript:document.f.submit()">[�Խù� ���]</a></td></tr>   
</table>
   
</form:form>
</body>
</html>