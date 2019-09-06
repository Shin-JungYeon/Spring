<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>websocket client</title>
<c:set var="port" value="${pageContext.request.localPort}"/>
<c:set var="server" value="${pageContext.request.serverName}"/>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<script>
	$(function(){
		var ws = new WebSocket("ws://${server}:${port}${path}/chatting.shop");
		ws.onopen = function(){
			$("#chatStatus").text("info:connection opened")
			$("input[name=chatInput]").on("keydown",function(evt){
				if(evt.keyCode == 13){
					var msg = $("input[name=chatInput]").val();
					ws.send(msg);
					$("input[name=chatInput]").val("");
				}
			})
		}
		ws.onmessage = function(event){
			$("textarea").eq(0).append(event.data+"\n");
		}
		ws.onclose = function(event){
			$("#chatStatus").text("info:connection close");
		}
	})
</script>
</head>
<body>
<p>
<div id="chatStatus"></div>
<textarea name="chatMsg" rows="15" cols="40"></textarea><br>
메세지 입력 : <input type="text" name="chatInput">

</body>
</html>