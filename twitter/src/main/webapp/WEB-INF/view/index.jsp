<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset = "utf-8">
	<title>Pocketer</title>
	<link rel="stylesheet" type="text/css" href="${f:url('/css/twitterHome.css')}" />
	<link href='http://fonts.googleapis.com/css?family=Libre+Baskerville' rel='stylesheet' type='text/css'>
</head>
<div class="wrapper">
	<div class ="header">
		<p>Pocketer</p>
	</div>
<body>
	<div class ="top-background">
	<div class ="top-main">
		<p class ="intro">就活ツィッターPocketerをようこそ</p>
			<div class="loginForm">
				<s:form method="post">
					<div class = "login">
						<h3>Login</h3>
							<div class ="loginId">
								<h4>Username</h4>
								<html:text property ="loginKey" styleClass="inputBox"/><br>
							</div>
							<div class="loginPass">
								<h4>Password</h4>
								<html:password property="loginPassword" styleClass="inputBox"/><br>
							</div>
						<s:submit property="gotoLogin" value="Login" styleClass="loginButton"/><br>
							<div class="loginError">
								<html:errors />
							</div>
					</div>
				</s:form>
				<s:form method="post">
					<div class = "signup">
						<h3>Signup now!</h3>
							<s:submit property="gotoSignup" value = "Go!" styleClass="signupButton"/>
					</div>
				</s:form>
			</div>
	</div>
	</div>
</body>
	<div class="footer">
		<p>©2014 AnnieWaraPocket All Rights Reserved</p>
	</div>
</div>
</html>

