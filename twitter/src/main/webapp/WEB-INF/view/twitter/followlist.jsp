<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset = "utf-8">
	<title>Follow/Follower</title>
	<link rel="stylesheet" type="text/css" href="${f:url('/css/twitterHome.css')}" />
	<link href='http://fonts.googleapis.com/css?family=Libre+Baskerville' rel='stylesheet' type='text/css'>
</head>
<div class = "wrapper">
		<jsp:include page="/WEB-INF/view/glonavi.jsp"/>
	<div class ="header">
		<p>Pocketer</p>
	</div>
<body>
	<div class ="follow-main">
		<s:form action ="/home/" >
			<div class = "following">
			<h3>Following</h3>
				<div class ="followingList">
					<ul>
							<div class="error">${noFollow}</div>
						<c:forEach items="${followMemberList}" var="memberName" varStatus="status">
							<dl>
								<dt id="name"><s:link href="/member/${f:h(memberName.username)}">${f:h(memberName.accountName)}</s:link>@${f:h(memberName.userName)}</dt>
							<dl>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class ="follower">
			<h3>Follower</h3>
				<div class = "followerList">
					<ul>
							<div class="error">${noFollower}</div>
						<c:forEach items="${followerMemberList}" var="followerName" varStatus="status">
							<dl>
								<dt id="name"><s:link href="/member/${f:h(followerName.username)}">${f:h(followerName.accountName)}</s:link>@${f:h(followerName.userName)}</dt>
							</dl>
						</c:forEach>
					</ul>
				</div>
			</div>
		</s:form>
		<div class ="fixBlock"></div>
	</div>
</body>
	<div class="footer">
			<p>©2014 AnnieWaraPocket All Rights Reserved</p>
	</div>
</div>
</html>

