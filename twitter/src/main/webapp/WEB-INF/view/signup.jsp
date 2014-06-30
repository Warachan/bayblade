<!DOCTYPE html>
<html lang="ja">
<body>

<h2>Signup on Twitter!</h2>
<s:form action="/signup/regester/">
			<h4>Email</h4>
			<html:text property ="newEmail"/><br>
				${overlapsError}
			<h4>Username</h4>
			<html:text property="username"/><br>
				${userError}
			<h4>Password</h4>
			<html:text property="newPassword"/><br>
			confirm password: <html:text property="confirmPass"/><br>
				${matchError}
			<s:submit property="Regester"/><br>
				${characterError}
				${missingError}
	</s:form>
</body>
</html>
