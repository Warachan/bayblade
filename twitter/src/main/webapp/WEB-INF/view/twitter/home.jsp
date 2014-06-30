<!DOCTYPE html>
<html lang="ja">
<body>

<h1>Tweet!</h1>

	<s:form action="/logout/">
		<s:submit property="index" value="logout"/>
	</s:form>
			<h2>Hello ${sessionDto.username}</h2>
	<s:form action="/home/">
			Follow your friends!<br>
			<html:text property="searchName" size="30" value=""/><br>
			<s:submit property="search" value="search"/><br>
	</s:form>
			<c:forEach items="${followList}" var="items" varStatus="status">
	<s:form action="/home/">
			<input type="hidden" name="toFollowMember" value="${f:h(followList[status.index])}"/>
			<s:link href="/member/${f:h(followList[status.index])}">${f:h(followList[status.index])}</s:link>
	</s:form>
       	 	</c:forEach>
	    ==================================================================================<br>
	<s:form action="/home/">
			<h4>Tweets</h4>
			<html:text property ="inputTweet" size="100" maxlength="140" value=""/><br>
			<s:submit property="tweet" value="tweet"/><br>
	</s:form>
		==================================================================================<br>
	<s:form action = "/home/">
			<c:forEach items="${timeLine}" var="items" varStatus="status">
			${f:h (timeLine[status.index])}<br>
       	 </c:forEach>
	</s:form>
</body>
</html>

