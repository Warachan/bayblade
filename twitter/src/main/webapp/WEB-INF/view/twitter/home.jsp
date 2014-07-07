<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset = "utf-8">
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="${f:url('/css/twitterHome.css')}" />
	<link href='http://fonts.googleapis.com/css?family=Libre+Baskerville' rel='stylesheet' type='text/css'>
</head>
<body>
<div class = "wrapper">
	<div class="header">
		<!--<h1>Tweet your everyday life!</h1>-->
	</div>
		<ul class = "global-navigation">
			<li><a href= "#">Profile</a></li>
			<li><a href= "#">Home</a></li>
			<span><s:form action="/home/" styleClass = "searchForm">
				<html:text property="searchWord" size ="30" value="" styleClass = "searchBox"/>
				<s:submit property="search" value="Search" styleClass = "searchButton"/>
			</s:form></span>
			<span class><s:form action="/logout/"  styleClass = "logoutForm">
				<s:submit property="index" value="Logout" styleClass = "logout"/>
			</s:form></span>
	</ul>
	<div class = "main">
		<div class = "main-top">
			<div class = "main-top-profile">
				<h2>${account}</h2>
					<s:form action = "/home/">
					<s:submit property="goFollow" value="Following / Follower" styleClass ="followCheck"/>
					<div class = "myProfile">
					</div>
					</s:form>
			</div>
			<figure class ="main-top-eyecatch">
				<img src="../img/hana.jpg">
			</figure>
		</div>
	<!--<s:form action="/returnHome/">
		<s:submit property="index" value="Home"/>
	</s:form>-->
	<!--<s:link href="/home/"><img src= "../img/hana.jpg"></s:link>-->
		<div class = "main-bottom">
			<h4>Tweets</h4>
			<s:form action ="/home/">
				<div class = "main-bottom-tweetBox">
					<html:text property ="inputTweet" maxlength="140" value="" styleClass="tweetBox"/><br>
					<html:errors property="inputTweet"/>
				</div>
					<s:submit property="tweet" value="Tweet" styleClass="tweetButton"/>
				<div class = "main-bottom-timeline">
					<ul>
						<c:forEach items="${timeLine}" var="items" varStatus="status">
				<!--${f:h (items.accountName)}@${f:h(items.username)} ${items.tweetTime}<br>-->
					<dl>
						<dt>${f:h(items.tweetTime)}  <s:link href="/member/${f:h(items.userName)}">${f:h(items.accountName)}@${f:h(items.username)}</s:link></dt>
						<dd>${items.tweet}</dd>
					</dl>
						</c:forEach>
					</ul>
				</div>
			</s:form>
		</div>
		<div class = "main-right">
			<h3>Follow?</h3>
				<ul>
					<c:forEach items="${followSuggestionList}" var="suggest" varStatus="status">
					<s:form action ="/home/">
						<dl>
							<dt><s:link href="/member/${f:h(suggest.userName)}">${f:h(suggest.accountName)}</s:link>@${f:h(suggest.username)}</dt>
								<input type="hidden" name="suggestFollowId" value="${f:h(suggest.memberId)}"/>
							<dt><s:submit property="addFollow" value="Follow?" styleClass = "suggestFollow"/></dt>
						</dl>
					</s:form>
					</c:forEach>
				</ul>
		</div>
	</div>
</div>
</body>
</html>
