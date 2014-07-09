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
	<!--<div class ="header">
		<p>Connect with your fellow job hunters!</p>
	</div>-->
		<ul class = "global-navigation">
			<li><a href= "http:/twitter/profile/">Profile</a></li>
			<li id="home"><a href= "http:/twitter/home/">Home</a></li>
			<!--<span class ="search"><s:form action="/home/" styleClass = "searchForm">-->
				<li id="search">
					<s:form action="/home/">
						<html:text property="searchWord" size ="30" value="" styleClass = "searchBox"/>
						<s:submit property="search" value="Search" styleClass = "searchButton"/>
					</s:form>
				</li>
				<li id="logout">
					<s:form action="/logout/"  styleClass = "logoutForm">
						<s:submit property="index" value="Logout" styleClass = "logoutButton"/>
					</s:form>
				</li>
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
								<ul>
									<li id="tweetList">
										<dt id="status">所属大学:${f:h(groupName)} （卒業年： ${f:h(graduationYear)}年）</dt>
										<dt id="status">希望業界:${f:h(interestedIndustry)}</dt>
									</li>
								</ul>
							</c:when>
							<c:otherwise>
								<ul>
									<li id="tweetList">
										<dt id="status">所属企業：  ${f:h(groupName)}</dt>
										<dt id="status">予定採用人数: ${f:h(recruitingNumber)}</dt>
									</li>
								</ul>
							</c:otherwise>
						</c:choose>
					</div>
				</s:form>
			</div>
			<figure class ="main-top-eyecatch">
			<c:choose>
				<c:when test="${recruitStatus}">
						<img src="/twitter/img/syuukatu.jpg">
				</c:when>
				<c:otherwise>
						<img src="/twitter/img/kigyou.jpg">
				</c:otherwise>
			</c:choose>
			</figure>
		</div>
		<div class ="fixBlock"></div>
		<div class = "main-bottom">
			<h4>Tweets</h4>
			<s:form action ="/home/">
				<div class ="main-bottom-tweetForm">
				<div class = "main-bottom-tweetBox">
					<html:textarea property ="inputTweet"  cols="50" rows="6" styleClass="tweetBox"/><br>
					<html:errors property="inputTweet"/>
				</div>
					<s:submit property="tweet" value="Tweet" styleClass="tweetButton"/>
				</div>
				<div class = "main-bottom-timeline">
					<ul>
						<c:forEach items="${timeLine}" var="items" varStatus="status">
				<!--${f:h (items.accountName)}@${f:h(items.username)} ${items.tweetTime}<br>-->
					<li id="tweetList">
					<dl>
						<dt id="name">${f:h(items.tweetTime)}  <s:link href="/member/${f:h(items.userName)}">${f:h(items.accountName)}@${f:h(items.username)}</s:link></dt>
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
							<dt id="name"><s:link href="/member/${f:h(suggest.userName)}">${f:h(suggest.accountName)}</s:link>@${f:h(suggest.username)}</dt>
								<input type="hidden" name="suggestFollowId" value="${f:h(suggest.memberId)}"/>
							<dt><s:submit property="addFollow" value="Follow?" styleClass = "suggestFollow"/></dt>
						</dl>
					</s:form>
					</c:forEach>
				</ul>
			</s:form>
		</div>
	</div>
</div>
</body>
</html>
