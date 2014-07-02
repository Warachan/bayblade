<!DOCTYPE html>
<html lang="ja">
<body>

<h1>Follow/Follower</h1>

	<s:form action="/logout/">
		<s:submit property="index" value="logout"/>
	</s:form>
	<s:form action ="/home/">
		<h3>Following</h3>
		${noFollow}
			<c:forEach items="${followMemberList}" var="memberName" varStatus="status">
				<s:link href="/member/${memberName}">${f:h(memberName)}</s:link><br>
			</c:forEach>
		<h3>Follower</h3>
		${noFollower}
			<c:forEach items="${followerMemberList}" var="followerName" varStatus="status">
				<s:link href="/member/${followerName}">${f:h(followerName)}</s:link><br>
			</c:forEach>
	</s:form>
</body>
</html>

