<!DOCTYPE html>
<html lang="ja">
<body>

<h2>Tweet!</h2>

	<s:form action="/logout/">
		<s:submit property="index" value="logout"/>
	</s:form>
				こんにちはidさん：${sessionDto.myId}
	<s:form>
			<html:text property="searchName" size="80" value=""/><br>
			<s:submit property="search" value="search"/><br>
	</s:form>
			<c:forEach items="${followList}" var="items" varStatus="status">
			${f:h (followList[status.index])}
	<s:form>
			<input type="hidden" name="name" value="${f:h (followList[status.index])}">
			<s:submit property="goFollow" value="go"/><br>
	</s:form>
       	 	</c:forEach>
	    ==================================================================================<br>
	<s:form>
			<h4>Tweets</h4>
			<html:text property ="inputTweet" size="100" maxlength="140" value=""/><br>
			<s:submit property="tweet" value="tweet"/><br>
	</s:form>
		==================================================================================<br>
	<s:form>
			<c:forEach items="${timeLine}" var="items" varStatus="status">
			${f:h (timeLine[status.index])}<br>
       	 </c:forEach>
	</s:form>
</body>
</html>

