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
	<div class="profile-main">
		<div class="profile-box">
		<h3>Edit your profile</h3>
		<s:form action="/profile/" styleClass="profileForm">
			<div class="email">
				<h4>Email</h4>
				<html:text property ="updateEmail" size="50" styleClass="textBox"/>
					<div class = "emailError">
						<html:errors property="updateEmail"/>
					</div>
			</div>
			<div class="name">
				<h4>Name</h4>
				<html:text property="updateName"  size="50" styleClass = "textBox"/>
					<div class="nameError">
					<html:errors property="updateName"/>
					</div>
			</div>
			<div class="username">
				<h4>Username</h4>
				<html:text property="updateProfile"  size="50" styleClass = "textBox"/><br>
					<div class = "profileError">
					<html:errors property="updateProfile"/>
					</div>
			</div>
			<div class="password">
				<h4>Password</h4>
				*8文字以上、20文字以内で入力してください。<br>
					<html:password property="updatePassword"  size="50" styleClass="textBox"/><br>
					Confirm password: <html:password property="confirmPass" size="50" styleClass="textBox"/><br>
					<div class ="passwordError">
						<html:errors property="updatePassword"/>
					</div>
			</div>
				<s:submit property="Regester" styleClass="register"/><br>
	</div>
	</s:form>
	</div>
</body>
</div>
</html>
