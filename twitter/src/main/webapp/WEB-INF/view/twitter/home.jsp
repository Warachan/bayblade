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
			<li><a href= "http:/twitter/profile/">Profile</a></li>
			<li><a href= "http:/twitter/home/">Home</a></li>
			<span class ="search"><s:form action="/home/" styleClass = "searchForm">
				<html:text property="searchWord" size ="30" value="" styleClass = "searchBox"/>
				<s:submit property="search" value="Search" styleClass = "searchButton"/>
			</s:form></span>
			<span class ="logout"><s:form action="/logout/"  styleClass = "logoutForm">
				<s:submit property="index" value="Logout" styleClass = "logoutButton"/>
			</s:form></span>
		</ul>
	<div class = "main">
		<div class = "main-top">
			<div class = "main-top-profile">
				<h2>${f:h(account)}</h2>
				<s:form action = "/home/">
					<s:submit property="goFollow" value="Following / Follower" styleClass ="followCheck"/>
					<div class = "myProfile">
						<c:choose>
							<c:when test="${recruitStatus}">
								所属大学:${f:h(groupName)} （卒業年： ${f:h(graduationYear)}年）<br>
								希望業界:${f:h(interestedIndustry)}
							</c:when>
							<c:otherwise>
								所属企業：  ${f:h(groupName)}<br>
								予定採用人数: ${f:h(recruitingNumber)}
							</c:otherwise>
						</c:choose>
					</div>
				</s:form>
			</div>
			<figure class ="main-top-eyecatch">
				<img src="../img/hana.jpg">
			</figure>
		</div>
		<div class ="fixBlock"></div>
		<div class = "main-bottom">
			<h4>Tweets</h4>
			<s:form action ="/home/">
				<div class ="main-bottom-tweetForm">
				<div class = "main-bottom-tweetBox">
					<html:textarea property ="inputTweet"  cols="35" rows="4" styleClass="tweetBox"/><br>
					<html:errors property="inputTweet"/>
				</div>
					<s:submit property="tweet" value="Tweet" styleClass="tweetButton"/>
				</div>
				<div class = "main-bottom-timeline">
					<ul>
						<c:forEach items="${timeLine}" var="items" varStatus="status">
				<!--${f:h (items.accountName)}@${f:h(items.username)} ${items.tweetTime}<br>-->
					<li>
					<dl>
						<dt>${f:h(items.tweetTime)}  <s:link href="/member/${f:h(items.userName)}">${f:h(items.accountName)}@${f:h(items.username)}</s:link></dt>
						<dd id="tweet">${items.tweet}</dd>
					</dl>
					</li>
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
