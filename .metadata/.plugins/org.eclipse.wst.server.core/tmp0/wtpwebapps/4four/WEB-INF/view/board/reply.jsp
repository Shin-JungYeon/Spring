<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<%--
   1. 파라미터로 해당 글에 대한 num 값을 받아옴.
   2. 원글의 num,ref,ref_level,ref_step 정보를 저장
   3. 입력 화면을 띄워줌
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판 답글 쓰기</title>

</head>
<body>
<form:form modelAttribute="board" action="reply.shop" method="post" name="f">
<%-- 원글 정보 : num, ref reflevel refstep : 순서를 지정.(어디에 들어가야하는지, 기준은 원글의 step) --%>
   <form:hidden path="num"/>
   <form:hidden path="ref"/>
   <form:hidden path="ref_level"/>
   <form:hidden path="ref_step"/>
<table id="list">
   <caption>MODEL2 게시판 답글 등록</caption>
   <tr>
      <td>글쓴이</td>
      <td><form:input path="name" value="&nbsp;"/><font color="red"><form:errors path="name"/></font></td></tr>
   <tr>
      <td>비밀번호</td>
      <td><form:password path="pass"/><font color="red"><form:errors path="pass"/></font></td></tr>
   <tr>
      <td>제목</td>
      <td><form:input path="subject" value="RE:${board.subject }"/><font color="red"><form:errors path="subject"/></font></td></tr>
   <tr>
      <td>내용</td>
      <td><textarea name="content" rows="15" cols="80"></textarea>
      <script>CKEDITOR.replace("content",{filebrowserImageUploadUrl:"imgupload.shop?CKEditorFuncNum=1"})</script>
      <font color="red"><form:errors path="content"/></font></td></tr>
   <tr>
      <td colspan="2"><a href="javascript:document.f.submit()">[게시물 등록]</a></td></tr>   
</table>
   
</form:form>
</body>
</html>