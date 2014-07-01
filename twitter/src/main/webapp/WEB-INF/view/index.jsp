<!DOCTYPE html>
<html lang="ja">
<body>

<h1>Twitter Top</h1>
	<s:form method="post">
		<h2>Login</h2>
			<h3>E-mail address or username</h3>
			e-mail:<html:text property ="loginEmail"/><br>
			password:<html:text property="loginPassword"/><br>
			<s:submit property="gotoLogin"/><br>
				${error}
	</s:form>

	<s:form method="post">
		<h2>Signup now!</h2>
			<s:submit property="gotoSignup" value = "Go!"/>

	</s:form>
</body>
</html>

