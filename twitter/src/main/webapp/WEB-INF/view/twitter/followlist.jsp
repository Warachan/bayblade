<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset = "utf-8">
	<title>Follow/Follower</title>
	<link rel="stylesheet" type="text/css" href="${f:url('/css/twitterHome.css')}" />
	<link href='http://fonts.googleapis.com/css?family=Libre+Baskerville' rel='stylesheet' type='text/css'>
</head>
<div class = "wrapper">
	<div class="header">
	</div>
	<ul class = "global-navigation">
		<li><a href= "http:/twitter/profile/">Profile</a></li>
		<li id="home"><a href= "http:/twitter/home/">Home</a></li>
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
	</div>
</body>
</div>
</html>

