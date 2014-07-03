<!DOCTYPE html>
<html lang="ja">
	<body>
		<s:form action="/logout/">
			<s:submit property="index" value="logout"/>
		</s:form>
		<s:form action="/returnHome/">
			<s:submit property="index" value="home"/>
		</s:form>
		<h1> ${account}'s Page</h1>
				===========================================================================
					<h3>Follow</h3>
					<s:form action="/member/">
						<c:choose>
							<c:when test="${followStatus}">
								<input type="hidden" name="yourName" value="${yourName}"/>
								<s:link href="/member/${yourName}/follow">follow?</s:link>
							</c:when>
							<c:otherwise>
								<input type="hidden" name="yourName" value="${yourName}"/>
								${relationship}
								<s:link href="/member/${yourName}/unfollow">unfollow?</s:link>
							</c:otherwise>
						</c:choose>
					</s:form>
				===========================================================================
					<h3>Tweets</h3>
					<s:form action="/member/">
								<c:forEach items="${timeLine}" var="items" varStatus="status">
									${f:h (items.memberName)} ${f:h(items.tweetTime)}<br>
									${f:h(items.tweet)}<br>
		        ==========================================================================<br>
								</c:forEach>
					</s:form>
	</body>
</html>
