<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	.wordcloud{
		border : 1px solid #036;
		width : 6in;
		height : 6in;
		margin : 0.5in auto;
		padding:0;
		page-break-fter : always;
		page-break-inside: avoid;
	}
</style>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.3.0/Chart.bundle.js">
	
</script>
<link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery.awesomeCloud-0.2.js"></script>
</head>
<body>
<header style="margin-top:50px;"></header>
	<div role="main">
		<div id="wordcloud1" class="wordcloud">
			<c:forEach items="${map }" var="m">
				<span data-weight="${m.value*20 }">${m.key}</span>
			</c:forEach>
		</div>
	</div>0
	<script type="text/javascript">
		$(document).ready(function(){
			$("#wordcloud1").awesomeCloud({
				"size" : {"grid":9,"factor":1},
				"options" : {"color":"random-dark","rotationRatio":0.35},
				"font":"'Times New Roman',Times,serif",
				"shape":"circle"
			})
		})
	</script>
</body>
</html>