<!DOCTYPE html>
<html lang="ja">
	<body>
		<s:form action="/logout/">
			<s:submit property="index" value="logout"/>
		</s:form>
		<h1> ${account}'s Page</h1>

				===========================================================================
					<h3>Follow</h3>
					<s:form action="/member/">
						<input type="hidden" name="yourName" value="${yourName}"/>
						<s:link href="/member/${yourName}/follow">follow</s:link>
					</s:form>
				===========================================================================
					<h3>Tweets</h3>
					<s:form action="/member/">
								<c:forEach items="${timeLine}" var="items" varStatus="status">
									${f:h (timeLine[status.index])}<br>
								</c:forEach>
					</s:form>
	</body>
</html>
