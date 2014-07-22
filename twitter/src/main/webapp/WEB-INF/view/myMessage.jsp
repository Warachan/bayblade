<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset = "utf-8">
	<title>My Messages</title>
	<link rel="stylesheet" type="text/css" href="${f:url('/css/twitterHome.css')}" />
	<link href='http://fonts.googleapis.com/css?family=Libre+Baskerville' rel='stylesheet' type='text/css'>
</head>
	<jsp:include page="/WEB-INF/view/glonavi.jsp"/>
		<div class ="header">
			<p>Pocketer</p>
		</div>
<div class = "wrapper">
	<div class = "myMessages">
			<h3>☆My Messages☆</h3>
		<div class = "myMessage-main">
				<ul>
					<span id="messageComment">${f:h(messageComment)}</span>
					<c:forEach items="${receiveMessageList}" var="message" varStatus="status">
					<s:form action ="/home/">
						<dl>
							<dt id="info">${f:h(message.messageTime)}  <s:link href="/message/${f:h(message.username)}">${f:h(message.accountName)}</s:link>@${f:h(message.username)}</dt>
							<dd id="message">${f:h(message.message)}</dd>
						</dl>
					</s:form>
					</c:forEach>
				</ul>
		</div>
	</div>
	<div class="footer">
		<p>©2014 AnnieWaraPocket All Rights Reserved</p>
	</div>
</div>
</html>