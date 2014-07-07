<!DOCTYPE html>
<html lang="ja">
<body>
	<h1>Follow/Follower</h1>
		<s:form action="/logout/">
		<s:submit property="index" value="Logout"/>
	</s:form>

	<s:form action ="/home/">
		<h3>Following</h3>
		================================================================================================<br>
		${noFollow}
			<c:forEach items="${followMemberList}" var="memberName" varStatus="status">
				<s:link href="/member/${f:h(memberName.username)}">${f:h(memberName.accountName)}</s:link>@${f:h(memberName.userName)}<br>
			</c:forEach>
		<h3>Follower</h3>
		================================================================================================<br>
		${noFollower}
			<c:forEach items="${followerMemberList}" var="followerName" varStatus="status">
				<s:link href="/member/${f:h(followerName.username)}">${f:h(followerName.accountName)}</s:link>@${f:h(memberName.userName)}<br>
			</c:forEach>
	</s:form>
		</body>
</html>