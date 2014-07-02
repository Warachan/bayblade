<!DOCTYPE html>
<html lang="ja">
<body>

<h1>Tweet!</h1>

	<s:form action="/logout/">
		<s:submit property="index" value="logout"/>
	</s:form>

	<s:form action="/home/">
			<h4>Users</h4>
			${noMatchUsers}</br>
		<c:forEach items="${candidateList}" var="items" varStatus="status">
			<input type="hidden" name="nameResult" value="${f:h(candidateList[status.index])}"/>
			<s:link href="/member/${f:h(candidateList[status.index])}">${f:h(candidateList[status.index])}</s:link><br>
       	</c:forEach>
	    ==================================================================================<br>
			<h4>Tweets</h4>
		==================================================================================<br>
			${noMatchTweets}
			<c:forEach items="${resultList}" var="items" varStatus="status">
			${items.memberName} ${items.tweetTime}<br>
			${items.tweet}<br>
			<br>
       	 	</c:forEach>
	</s:form>
</body>
</html>