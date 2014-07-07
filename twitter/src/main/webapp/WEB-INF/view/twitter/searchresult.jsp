<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset = "utf-8">
	<title>Member</title>
	<link rel="stylesheet" type="text/css" href="${f:url('/css/twitterHome.css')}" />
	<link href='http://fonts.googleapis.com/css?family=Libre+Baskerville' rel='stylesheet' type='text/css'>
</head>
<div class = "wrapper">
	<div class="header">
	</div>
	<ul class = "global-navigation">
			<li><a href= "http:/twitter/profile/">Profile</a></li>
			<li><a href= "http:/twitter/home/">Home</a></li>
			<span><s:form action="/home/" styleClass = "searchForm">
				<html:text property="searchWord" size ="30" value="" styleClass = "searchBox"/>
				<s:submit property="search" value="Search" styleClass = "searchButton"/>
			</s:form></span>
			<span class><s:form action="/logout/"  styleClass = "logoutForm">
				<s:submit property="index" value="Logout" styleClass = "logoutButton"/>
			</s:form></span>
	</ul>
<body>
	<div class = "member-main">
			<s:form action="/home/" styleClass="searchResult">
			<div class = "userList">
				<h3>Users</h3>
					${f:h(noMatchUsers)}
					<c:forEach items="${candidateList}" var="items" varStatus="status">
						<dl>
							<dt><s:link href="/member/${f:h(items.userName)}">${f:h(items.accountName)}</s:link>@${f:h(items.userName)}</dt>
						</dl>
       				</c:forEach>
			</div>
	<div class = "main-bottom">
		<h3>Tweets</h3>
		<div class ="errorMessage">
				${f:h(noMatchTweets)}
		</div>
			<div class = "main-bottom-timeline>
				<s:form action="/member/" styleClass="memberTimeline">
						<c:forEach items="${resultList}" var="items" varStatus="status">
					<dl>
						<dt>${f:h(items.tweetTime)}  <s:link href = "/member/${f:h(items.username)}">${f:h(items.accountName)}@${f:h(items.username)} </s:link></dt>
						<dd>${f:h(items.tweet)}</dd>
					</dl>
						</c:forEach>
				</s:form>
			</div>
	</div>
	</s:form>
	</div>
</body>
</div>
</html>