<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset = "utf-8">
	<title>Member</title>
	<link rel="stylesheet" type="text/css" href="${f:url('/css/twitterHome.css')}" />
	<link href='http://fonts.googleapis.com/css?family=Libre+Baskerville' rel='stylesheet' type='text/css'>
</head>
<div class = "wrapper">
		<jsp:include page="/WEB-INF/view/glonavi.jsp"/>
	<div class ="header">
		<p>Pocketer</p>
	</div>
<body>
	<div class = "member-main">
			<div class = "member-top">
					<div class = "member-top-profile">
						<s:form action="/member/" styleClass="followOrUnfollow">
						<h2> ${(account)}'s Page</h2>
							<span class="followStatus">${f:h(relationship)}</span>
								<c:choose>
									<c:when test="${f:h(followStatus)}">
										<input type="hidden" name="yourName" value="${f:h(yourName)}"/>
										<s:link href="/member/${f:h(yourName)}/follow" styleClass = "followLink">follow?</s:link>
									</c:when>
									<c:otherwise>
										<input type="hidden" name="yourName" value="${f:h(yourName)}"/>
										<s:link href="/member/${f:h(yourName)}/unfollow" styleClass = "followLink">unfollow?</s:link>
									</c:otherwise>
								</c:choose>
						</s:form>
						<s:form action="/member/" styleClass="followOrUnfollow">
								<div class = "myProfile">
									<s:link href="/member/${f:h(yourName)}/followingMember" styleClass="memberFollowStatus">Following and Followers</s:link>
									<s:link href="/message/${f:h(yourName)}" styleClass="contactLink">Contact?</s:link>
						</s:form>
						<s:form action="/member/" styleClass="followOrUnfollow">
										<div class ="recruitStatus">
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
								</div>
						</s:form>
					</div>
					<figure class ="member-top-eyecatch">
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
				<div class="member-bottom">
					<div class="main-bottom-timeline">
						<s:form action="/member/" styleClass="memberTimeline">
							<h3>Tweets</h3>
								<ul>
									<c:forEach items="${timeLine}" var="items" varStatus="status">
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
											<dt id="tweetInf">${f:h(items.tweetTime)} ${f:h(items.accountName)}@${f:h(items.username)}</dt>
											<dd id="tweet">${f:h(items.tweet)}</dd>
										</dl>
										</li>
										<div class ="fixBlock"></div>
									</c:forEach>
								</ul>
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
