<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset = "utf-8">
	<link rel="stylesheet" type="text/css" href="${f:url('/css/twitterHome.css')}" />
	<link href='http://fonts.googleapis.com/css?family=Libre+Baskerville' rel='stylesheet' type='text/css'>
</head>
<body>
		<ul class = "global-navigation">
			<li id="home"><a id="homeButton" href= "http:/twitter/home/">Home</a></li>
			<li><a id="profile" href= "http:/twitter/profile/">Profile</a></li>
			<li id="messages"><a id="messageButton" href="http:/twitter/home/myMessage/">Messages</a></li>
			<li id="search"><s:form action="/home/">
				<html:text property="searchWord" size ="30" styleClass = "searchBox"/>
				<s:submit property="search" value="Search" styleClass = "searchButton"/>
			</s:form></li>
			<li id="logout"><s:form action="/logout/"  styleClass = "logoutForm">
				<s:submit property="index" value="Logout" styleClass = "logoutButton"/>
			</s:form></li>
		</ul>
</body>
</html>