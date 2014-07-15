<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset = "utf-8">
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="${f:url('/css/twitterHome.css')}" />
	<link href='http://fonts.googleapis.com/css?family=Libre+Baskerville' rel='stylesheet' type='text/css'>
</head>
<div class = "wrapper">
	<ul class = "global-navigation">
			<li id="loginButton"><a id ="signupToLogin" href= "http:/twitter/">Login</a></li>
	</ul>
	<div class ="header">
		<p>Pocketer</p>
	</div>
<body>
	<div class="signup-main">
		<div class="signup-box">
		<h2>Signup on Twitter!</h2>
		<s:form action="/signup/regester/" styleClass="signupForm">
			<div class="name">
				<h4>Name</h4>
				<html:text property="accountName"  size="60" styleClass = "nameBox"/>
					<div class="nameError">
					<html:errors property="accountName"/>
					</div>
			</div>
			<div class="username">
				<h4>Username</h4>
				*5文字以上・100文字以内で、英数字を入力してください。
				<html:text property="username"  size="60" styleClass = "usernameBox"/><br>
					<div class = "usernameError">
						<html:errors property="username"/>
					</div>
			</div>
			<div class="profile">
				<div class ="status">
					<h4>Student or Company?</h4>
					<p id="comment">あなたは学生？それとも会社の方？</p>
						<html:select property="status">
							<html:option value=""></html:option>
    　							<html:option value="student">Student</html:option>
    　							<html:option value="company">Company</html:option>
						</html:select>
						<p id="warning">*この項目は後で変更できません！
						<html:errors property="status"/>
				</div>
				<div class = "group">
					<h4>School/Company Name</h4>
						<html:text property="groupName"/>
						<html:errors property="groupName"/>
				</div>
			</div>
			<div class="password">
				<h4>Password</h4>
				*8文字以上、20文字以内で入力してください。<br>
					<html:password property="password"  size="60" styleClass="passwordBox"/><br>
					Confirm password: <html:password property="confirmPass" size="60" styleClass="confirmBox"/><br>
					<div class ="passwordError">
						<html:errors property="password"/>
					</div>
			</div>
				<s:submit property="Regester" styleClass="register"/><br>
	</div>
	</s:form>
	</div>
	<div class="footer">
			<p>©2014 Annie Wara Pocket</p>
	</div>
</body>
</div>
</html>
