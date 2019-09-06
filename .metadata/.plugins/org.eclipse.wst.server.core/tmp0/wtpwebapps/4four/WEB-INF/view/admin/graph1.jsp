<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.3.0/Chart.bundle.js">
	
</script>
</head>
<body>

<div id="canvas-holder" style="width:50%">
		<canvas id="chart-area" width="200" height="200">
		</canvas>
	</div>
	<script type="text/javascript">
		var randomColorFactor = function(){
			return Math.round(Math.random()*255);
		}
		var randomColor = function(opacity){
			return "rgba("+randomColorFactor()+","
						+randomColorFactor() + ","
						+randomColorFactor() + ","
						+ (opacity|'.3') + ")";
		}
		var config = {
				type : 'bar',
				data : {
					datasets : [{
						label : '아이디별 게시물 작성 건수',
						data:[<c:forEach items="${map}" var="m">"${m.value}",</c:forEach>],
						backgroundColor:[<c:forEach items="${map}" var="m">randomColor(1),</c:forEach>],
						}],
					labels:[<c:forEach items="${map}" var="m">"${m.key}",</c:forEach>]},
					options: {
						responsive:true,
				        scales: {
				            yAxes: [{
				                ticks: {
				                    beginAtZero:true
				                }
				            }]
				        }
				    }
				};
		window.onload = function() {
			var ctx = document.getElementById("chart-area").getContext("2d");
			window.myPid = new Chart(ctx,config);
		}
	</script>
</body>
</html>