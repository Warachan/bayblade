<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset = "utf-8">
	<title>SearchResults</title>
	<link rel="stylesheet" type="text/css" href="${f:url('/css/twitterHome.css')}" />
	<link href='http://fonts.googleapis.com/css?family=Libre+Baskerville' rel='stylesheet' type='text/css'>
</head>
<div class = "wrapper">
			<jsp:include page="/WEB-INF/view/glonavi.jsp"/>
	<div class ="header">
		<p>Pocketer</p>
	</div>
<body>
	<div class = "searchResultPage">
		<div class="searchResultBox">
	<div class = "member-main">
			<s:form action="/home/" styleClass="searchResult">
			<div class = "userList">
				<h3>Users</h3>
					${f:h(noMatchUsers)}
					<c:forEach items="${candidateList}" var="items" varStatus="status">
						<dl>
							<dt id="name"><s:link href="/member/${f:h(items.userName)}">${f:h(items.accountName)}</s:link>@${f:h(items.userName)}</dt>
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
					<li id="tweetList">
					<dl id="icon">
						<c:choose>
							<c:when test="${items.status}">
							<img src="/twitter/img/syuukatu.jpg">
							</c:when>
						    <c:otherwise>
							<img src="/twitter/img/kigyou.jpg">
							</c:otherwise>
					    </c:choose>
					</dl>
					<dl>
						<dt id="tweetInf">${f:h(items.tweetTime)}  <s:link href = "/member/${f:h(items.username)}">${f:h(items.accountName)}@${f:h(items.username)} </s:link></dt>
						<dd id="tweet">${f:h(items.tweet)}</dd>
					</dl>
					</li>
					<div class ="fixBlock"></div>
						</c:forEach>
				</s:form>
			</div>
	</div>
	<div class ="fixBlock"></div>
	</s:form>
	</div>
	</div>
	</div>
	<div class="footer">
			<p>©2014 AnnieWaraPocket All Rights Reserved</p>
	</div>
</body>
</div>
</html>