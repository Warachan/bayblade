<!DOCTYPE html>
<html lang="ja">
<body>

<h2>Tweet!</h2>
	<s:form action="/logout/">
		<s:submit property="index" value="logout"/>
	</s:form>
				こんにちはidさん：${sessionDto.id}
	<s:form>
			<h4>Tweets</h4>
			<html:text property ="input" size="100" maxlength="140" value=""/><br>
			<s:submit property="tweet" value="tweet"/><br>
			<c:forEach items="${timeLine}" var="items" varStatus="status">
			${f:h (timeLine[status.index])}<br>
       	 </c:forEach>
	</s:form>
</body>
</html>

