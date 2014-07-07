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
				<s:submit property="index" value="Logout" styleClass = "logout"/>
			</s:form></span>
		</ul>
	<body>
			<div class = "member-main">
				<div class = "main-top">
					<s:form action="/member/" styleClass="followOrUnfollow">
					<div class = "member-top-profile">
						<h2> ${(account)}'s Page</h2>
							<span class="followStatus">
							${f:h(relationship)}</span>
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
									<s:link href="/member/${f:h(yourName)}/followingMember" styleClass="memberFollowStatus">Following and Followers</s:link><br>
										<div class ="recruitStatus">
										<c:choose>
											<c:when test="${recruitStatus}">
												所属大学：  ${f:h(groupName)}　（卒業年：${f:h(graduationYear)}年）<br>
												希望業界: ${f:h(interestedIndustry)}
											</c:when>
											<c:otherwise>
												所属企業:${f:h(groupName)}<br>
												採用予定人数:${f:h(recruitingNumber)}
											</c:otherwise>
										</c:choose>
										</div>
								</div>
						</s:form>
					</div>
					<figure class ="main-top-eyecatch">
						<img src="../img/hana.jpg">
					</figure>
				</div>
					<div class ="fixBlock"></div>
				<div class="main-bottom">
					<div class="main-bottom-timeline">
						<s:form action="/member/" styleClass="memberTimeline">
							<h3>Tweets</h3>
								<ul>
									<c:forEach items="${timeLine}" var="items" varStatus="status">
										<li>
										<dl>
											<dt>${f:h(items.tweetTime)} ${f:h(items.accountName)}@${f:h(items.username)}</dt>
											<dd id="tweet">${f:h(items.tweet)}</dd>
										</dl>
										</li>
									</c:forEach>
								</ul>
						</s:form>
					</div>
				</div>
			</div>
	</body>
</div>
</html>
