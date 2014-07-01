<!DOCTYPE html>
<html lang="ja">
<body>

<h1>Tweet!</h1>

	<s:form action="/logout/">
		<s:submit property="index" value="logout"/>
	</s:form>
			<h2>Hello ${account}</h2>
		<h3>About me</h3>
	<s:form action="/home/">

			<h4>Profile</h4>
			${profile}<br>
			<html:text property="profile" size="30"/><br>
            <s:submit property="editProfile"/><br>

		<h3>Follow your friends!</h3>
			<html:text property="searchName" size="30" value=""/><br>
			<s:submit property="search" value="search"/><br>
		<c:forEach items="${candidateList}" var="items" varStatus="status">
			<input type="hidden" name="toFollowMember" value="${f:h(candidateList[status.index])}"/>
			<s:link href="/member/${f:h(candidateList[status.index])}">${f:h(candidateList[status.index])}</s:link>
       	</c:forEach>
	</s:form>
	    ==================================================================================<br>
	<s:form action="/home/">
			<h4>Tweets</h4>
			<html:text property ="inputTweet" size="100" maxlength="140" value=""/><br>
			<s:submit property="tweet" value="tweet"/><br>
		==================================================================================<br>
			<c:forEach items="${timeLine}" var="items" varStatus="status">
			${f:h (timeLine[status.index])}<br>
       	 </c:forEach>
	</s:form>
</body>
</html>

