<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset = "utf-8">
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="${f:url('/css/twitterHome.css')}" />
	<link href='http://fonts.googleapis.com/css?family=Libre+Baskerville' rel='stylesheet' type='text/css'>
</head>
<body>
	<div class="wrapper">
		<ul class = "global-navigation">
			<li><a id="profile" href= "http:/twitter/profile/">Profile</a></li>
			<li id="home"><a id="homeButton" href= "http:/twitter/home/">Home</a></li>
			<li id="search"><s:form action="/home/">
				<html:text property="searchWord" size ="30" value="" styleClass = "searchBox"/>
				<s:submit property="search" value="Search" styleClass = "searchButton"/>
			</s:form></li>
			<li id="logout"><s:form action="/logout/"  styleClass = "logoutForm">
				<s:submit property="index" value="Logout" styleClass = "logoutButton"/>
			</s:form></li>
		</ul>
		<div class ="header">
			<p>Pocketer</p>
		</div>
		<div class ="message-main">
			<s:form action="/message/" method="post">
				<div class="messageForm">
					<div class = "editMessage">
							<div class ="address">
								<h3>To:@${f:h(receiver)}</h3>
							</div>
							<div class="message">
								<html:textarea property ="message"  cols="100" rows="15" styleClass="messageBox" value=""/><br>
							</div>
								<input type="hidden" name="receiver" value="${receiver}"/>
								<s:submit property="editMessage" value="Send" styleClass="sendButton"/><br>
									<div class="messageError">
										<html:errors />
									</div>
					</div>
					<div class ="messageList">
						<h3>Messages with:@${f:h(receiver)}</h3>
					<div class ="receive">
						<h4>From @${f:h(receiver)}</h4>
						<ul>
							${f:h(noSentMessages)}
						<c:forEach items="${sentMessageList}" var="items" varStatus="status">
							<dl>
								<dt id="info">${f:h(items.messageTime)}</dt>
								<dd id="message">${f:h(items.message)}</dd>
							</dl>
						</c:forEach>
						</ul>
					</div>
					<div class ="sent">
						<h4>To @${f:h(receiver)}</h4>
						<ul>
							${f:h(noMessages)}
						<c:forEach items="${receiveMessageList}" var="items" varStatus="status">
							<dl>
								<dt id="info">${f:h(items.messageTime)}</dt>
								<dd id="message">${f:h(items.message)}</dd>
							</dl>
						</c:forEach>
						</ul>
					</div>
					<div class ="fixBlock"></div>
					</div>
				</div>
					<div class ="fixBlock"></div>
			</s:form>
		</div>
	</div>
	<div class="footer">
		<p>©2014 Annie Wara Pocket</p>
	</div>
</body>
</html>