<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ������</title>
<script type="text/javascript" src="http://cdn.ckeditor.com/4.5.7/full/ckeditor.js"></script>
<script>
	function idinputchk(f){
		if(f.naverid.value == ""){
			alert("���̹� ���̵� �Է��ϼ���");
			f.naverid.focus();
			return false;
		}
		if(f.naverpw.value == ""){
			alert("���̹� ��й�ȣ�� �Է��ϼ���");
			f.naverpw.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<h2>���Ϻ�����</h2>
<form name="mailform" method="post" action="mail.shop" enctype="multipart/form-data" onsubmit="return idinputchk(this)"> 
	���� ���̹� ���̵� : <input type="text" name="naverid"><br>
	���� ���̹� ��й�ȣ : <input type="password" name="naverpw">
	<table>
		<tr><td>������ ���</td><td>${loginUser.email }</td></tr>
		<tr><td>�޴� ���</td>
		<td><input type="text" name="recipient" size="100" value='<c:forEach items="${userList }" var="user">${user.userName } &lt;${user.email }&gt;,</c:forEach>'></td></tr>
		<tr><td>����</td><td><input type="text" name="title" size="100"></td></tr>
		<tr><td>�޽�������</td>
			<td>
				<select name="mtype">
					<option value="text/html; charset=euc-kr">HTML</option>
					<option value="text/plain; charset=euc-kr">TEXT</option>
				</select></td></tr>
		<tr><td>÷������1</td><td><input type="file" name="file1"></td></tr>
		<tr><td>÷������2</td><td><input type="file" name="file1"></td></tr>
		<tr>
			<td colspan="2"><textarea name="contents" cols="120" rows="10"></textarea>
			<script>CKEDITOR.replace("contents")</script></td></tr>
		<tr>
			<td colspan="2"><input type="submit" value="���Ϻ�����"></td></tr>
	</table>
</form>
</body>
</html>