<!DOCTYPE html>
<html lang="ja">
	<body>
		<s:form action="/logout/">
			<s:submit property="index" value="logout"/>
		</s:form>
		<h1> ${account}'s Page</h1>

				===========================================================================
					<h3>Follow</h3>
					<s:form action="/profile/">
						<s:submit property="follow" value="follow"/><br>
					</s:form>
				===========================================================================
					<h3>Tweets</h3>
					<s:form action="/profile/">
								<c:forEach items="${timeLine}" var="items" varStatus="status">
									${f:h (timeLine[status.index])}<br>
								</c:forEach>
					</s:form>
	</body>
</html>
