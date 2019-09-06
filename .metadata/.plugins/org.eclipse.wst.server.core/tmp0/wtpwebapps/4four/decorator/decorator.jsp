<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<c:set var="login" value="${sessionScope.login }"/>
<!DOCTYPE html>
<html>

<meta charset="EUC-KR">
<title><decorator:title/></title>
<script type="text/javascript" src="http://cdn.ckeditor.com/4.5.7/full/ckeditor.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<decorator:head/>
<link rel="stylesheet" href="${path }/css/main.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<style>
body,h1 {font-family: "Raleway", Arial, sans-serif}
h1 {letter-spacing: 6px}
</style>
<header class="w3-panel w3-center " style="padding:60px 16px; background-color:#1368a1; opacity: 0.8;" >
  <h1 align="center">Model2</h1>
  <h1 class="w3-xlarge" align="center">community</h1>
  <div class='ribbon'>
		<a href='/jsp_study_2/model2/member/main.me'><span>Member</span></a>
		<a href='/jsp_study_2/model2/board/list.do'><span>Board</span></a>
		<c:if test="${loginUser==null}">
			<a href="/jsp_study_2/model2/member/login.jsp"><span><font style="color:red;">로그인</font>이 필요합니다.</span></a>
		</c:if>
		<c:if test="${loginUser!=null}">
			<a href="/jsp_study_2/model2/member/info.me?id=${login}"><span><font style="color:#1368a1; ">${loginUser.userName }</font>님 반갑습니다.</span></a>
		</c:if>
	</div>
</header>

<body>

<table class="deco" id="deco">
	<tr>
		<td colspan="3" align="right">
		<c:if test="${empty sessionScope.loginUser }">
			<a href="${path }/user/login.shop">로그인</a>
			<a href="${path }/user/userEntry.shop">회원가입</a>
		</c:if>
		<c:if test="${!empty sessionScope.loginUser }">
			<a href="${path }/user/logout.shop">로그아웃</a>
		</c:if></td></tr>
	<tr>
		<td width="15%" valign="top"><br><br><hr>
		<a href="${path }/user/mypage.shop?id=${sessionScope.loginUser.userId}">회원관리</a><br><br><hr>
		<a href="${path }/item/list.shop">상품관리</a><br><br><hr>
		<a href="${path }/board/list.shop">게시판</a><br><br><hr>
		<a href="${path }/chat/chat.shop">채팅</a><br></td>
		<td colspan="2" style="text-align: left; vertical-align: top;">
			<decorator:body/></td></tr>
	<tr>
		<td colspan="3">구디아카데미 Since 2016</td></tr>
</table>
</body>
</html>