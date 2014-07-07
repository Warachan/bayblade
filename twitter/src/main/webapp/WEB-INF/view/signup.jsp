<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset = "utf-8">
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="${f:url('/css/twitterHome.css')}" />
	<link href='http://fonts.googleapis.com/css?family=Libre+Baskerville' rel='stylesheet' type='text/css'>
</head>
<div class = "wrapper">
<body>
	<div class="signup-main">
		<div class="signup-box">
		<h2>Signup on Twitter!</h2>
		<s:form action="/signup/regester/" styleClass="signupForm">
			<div class="email">
				<h4>Email</h4>
				<html:text property ="newEmail" size="50" styleClass="emailBox"/>
					<div class = "emailError">
						<html:errors property="newEmail"/>
					</div>
			</div>
			<div class="name">
				<h4>Name</h4>
				<html:text property="accountName"  size="50" styleClass = "nameBox"/>
					<div class="nameError">
					<html:errors property="accountName"/>
					</div>
			</div>
			<div class="username">
				<h4>Username</h4>
				<html:text property="username"  size="50" styleClass = "usernameBox"/><br>
					<div class = "usernameError">
					<html:errors property="username"/>
					</div>
			</div>
			<div class="password">
				<h4>Password</h4>
				*8文字以上、20文字以内で入力してください。<br>
					<html:password property="password"  size="50" styleClass="passwordBox"/><br>
					Confirm password: <html:password property="confirmPass" size="50" styleClass="confirmBox"/><br>
					<div class ="passwordError">
						<html:errors property="password"/>
					</div>
			</div>
				<s:submit property="Regester" styleClass="register"/><br>
	</div>
	</s:form>
	</div>
</body>
</div>
</html>
