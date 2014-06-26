<!DOCTYPE html>
<html lang="ja">
<body>

<h2>Tweet!</h2>
	<s:form>
			<h4>Tweets</h4>
			<html:text property ="input" size="100" maxlength="140" value=""/><br>
			<s:submit property="tweet" value="tweet"/><br>
				<c:forEach var="i" begin="0" end="5" step="1">
　<c:out value="${i}" /><br>
</c:forEach>
</s:form>
</body>
</html>

