<!DOCTYPE html>
<html lang="ja">
<body>

<h2>Signup on Twitter!</h2>
<s:form action="/signup/regester/">
			<h4>Email</h4>
			<html:text property ="newEmail"/><br>
			<html:errors property="newEmail"/>
			<h4>Username</h4>
			<html:text property="username"/><br>
			<html:errors property="username"/>
			<h4>Password</h4>
			<html:text property="password"/><br>
			confirm password: <html:text property="confirmPass"/><br>
			<html:errors property="password"/>
			<s:submit property="Regester"/><br>
				${characterError}
				${missingError}
	</s:form>
</body>
</html>
