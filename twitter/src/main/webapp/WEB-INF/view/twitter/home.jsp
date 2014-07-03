<!DOCTYPE html>
<html lang="ja">
<body>

<h1>Tweet your everyday life!</h1>

	<s:form action="/logout/">
		<s:submit property="index" value="logout"/>
	</s:form>
	<s:form action="/returnHome/">
		<s:submit property="index" value="home"/>
	</s:form>

		<h2>${account}</h2>
	<s:form action="/home/">
			<html:text property="searchWord" size="30" value=""/><br>
				<s:submit property="search" value="search"/><br>
				<s:submit property="goFollow" value="follow"/><br>
		</s:form>

		<h3>Follow?</h3>
			<c:forEach items="${followSuggestionList}" var="suggest" varStatus="status">
		 <s:form action ="/home/">
					<s:link href="/member/${suggest.memberName}">${f:h(suggest.memberName)}</s:link>
					<input type="hidden" name="suggestFollowId" value="${suggest.memberId}"/>
					<s:submit property="addFollow" value="Follow?"/>
	 	</s:form>
			</c:forEach>
	    ==================================================================================<br>
			<h4>Tweets</h4>
		<s:form action ="/home/">
				<html:text property ="inputTweet" size="100" maxlength="140" value=""/><br>
					<s:submit property="tweet" value="tweet"/><br>
					<html:errors property="inputTweet"/>
		==================================================================================<br>
			<c:forEach items="${timeLine}" var="items" varStatus="status">
				${items.memberName} ${items.tweetTime}<br>
					${items.tweet}<br>
		==================================================================================<br>
       	 	</c:forEach>
		</s:form>
</body>
</html>
