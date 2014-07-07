<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset = "utf-8">
	<title>Member</title>
	<link rel="stylesheet" type="text/css" href="${f:url('/css/twitterHome.css')}" />
	<link href='http://fonts.googleapis.com/css?family=Libre+Baskerville' rel='stylesheet' type='text/css'>
</head>
<body>
<div class = "wrapper">
	<div class="header">
	</div>
		<s:form action="/logout/">
			<s:submit property="index" value="Logout"/>
		</s:form>
		<s:form action="/returnHome/">
			<s:submit property="index" value="Home"/>
		</s:form>
	<div class = "member-main">
		<div class = "main-top">
			<div class = "main-top-profile">
				<s:form action="/member/" styleClass="followOrUnfollow">
					<h2> ${(account)}'s Page</h2>
					<!--<h3>Follow</h3>-->
								<span class="followStatus">
								${f:h(relationship)}
								</span>
					<c:choose>
						<c:when test="${f:h(followStatus)}">
							<input type="hidden" name="yourName" value="${f:h(yourName)}"/>
							<s:link href="/member/${f:h(yourName)}/follow" styleClass = "followLink">follow?</s:link>
						</c:when>
						<c:otherwise>
							<input type="hidden" name="yourName" value="${f:h(yourName)}"/>
							<s:link href="/member/${f:h(yourName)}/unfollow"styleClass = "followLink">unfollow?</s:link>
						</c:otherwise>
					</c:choose>
					<div class = "myProfile">
						<s:link href="/member/${f:h(yourName)}/followingMember" styleClass="memberFollowStatus">Following and Followers</s:link>
					</div>
				</s:form>
			</div>
			<figure class ="main-top-eyecatch">
				<img src="../img/hana.jpg">
			</figure>
		</div>
		<div class="main-bottom">
			<div class="main-bottom-timeline">
				<s:form action="/member/" styleClass="memberTimeline">
					<h3>Tweets</h3>
					<ul>
						<c:forEach items="${timeLine}" var="items" varStatus="status">
							<dl>
								<dt>${f:h(items.tweetTime)} ${f:h(items.accountName)}@${f:h(items.username)}</dt>
								<dd>${f:h(items.tweet)}</dd>
							</dl>
						</c:forEach>
					</ul>
				</s:form>
			</div>
		</div>
	</div>
</div>
</body>
</html>
