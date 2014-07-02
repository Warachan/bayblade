<!DOCTYPE html>
<html lang="ja">
<body>

<h1>Tweet your everyday life!</h1>

	<s:form action="/logout/">
		<s:submit property="index" value="logout"/>
	</s:form>
		<h2>About me</h2>
	<s:form action="/home/">
			<html:text property="searchWord" size="30" value=""/><br>
				<s:submit property="search" value="search"/><br>
				<s:submit property="goFollow" value="follow"/><br>
		<h3>Profile</h3>
			${profile}<br>
			<html:text property="profile" size="30"/><br>
				<s:submit property="editProfile"/><br>

		<h3>Follow?</h3>
			<c:forEach items="${followSuggestions}" var="suggestMember" varStatus="status">
				<s:link href="/member/${suggestMember}">${f:h(suggestMember)}</s:link><br>
			</c:forEach>
		<br>
	    ==================================================================================<br>
			<h4>Tweets</h4>
				<html:text property ="inputTweet" size="100" maxlength="140" value=""/><br>
					<s:submit property="tweet" value="tweet"/><br>
		==================================================================================<br>
			<c:forEach items="${timeLine}" var="items" varStatus="status">
				${items.memberName} ${items.tweetTime}<br>
					${items.tweet}<br>
					<br>
       	 	</c:forEach>
	</s:form>
</body>
</html>
