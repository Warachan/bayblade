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
	<s:form action="/logout/">
		<s:submit property="index" value="Logout"/>
	</s:form>
	<s:form action="/returnHome/">
		<s:submit property="index" value="Home"/>
	</s:form>
	</div>
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