<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����� ���</title>
</head>
<body>
<h2>����� ���</h2>
<form:form modelAttribute="user" method="post" action="userEntry.deco">
   <spring:hasBindErrors name="user">
      <font color="red">
         <c:forEach items="${errors.globalErrors }" var="error">
            <spring:message code="${error.code }"/>
         </c:forEach>
      </font>
   </spring:hasBindErrors>
   <table border="1" style= "border-collapse: collapse;">
      <tr height="40px">
         <td>���̵�</td>
         <td><form:input path="id"/><font color="red"><form:errors path="id"/></font></td></tr>
      <tr height="40px">
         <td>��й�ȣ</td>
         <td><form:password path="password"/><font color="red"><form:errors path="password"/></font></td></tr>
      <tr height="40px">
         <td>�̸���</td>
         <td><form:input path="email"/><font color="red"><form:errors path="email"/></font></td></tr>
      <tr height="40px">
         <td>����</td>
         <td><form:input path="gender"/><font color="red"><form:errors path="gender"/></font></td></tr>
      <tr height="40px">
         <td>����</td>
         <td><form:input path="prefer_loc"/><font color="red"><form:errors path="prefer_loc"/></font></td></tr>
      <tr height="40px">
         <td>����</td>
         <td><form:input path="age"/><font color="red"><form:errors path="age"/></font></td></tr>      
      <tr height="40px">
         <td colspan="2" align="center">
            <input type="submit" value="���">
            <input type="reset" value="�ʱ�ȭ">
         </td></tr>
   </table>
</form:form>
</body>
</html>