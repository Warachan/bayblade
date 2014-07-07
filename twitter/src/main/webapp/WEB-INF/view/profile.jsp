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
			<li><a href= "http:/twitter/profile/">Profile</a></li>
			<li><a href= "http:/twitter/home/">Home</a></li>
			<span><s:form action="/home/" styleClass = "searchForm">
				<html:text property="searchWord" size ="30" value="" styleClass = "searchBox"/>
				<s:submit property="search" value="Search" styleClass = "searchButton"/>
			</s:form></span>
			<span class><s:form action="/logout/"  styleClass = "logoutForm">
				<s:submit property="index" value="Logout" styleClass = "logoutButton"/>
			</s:form></span>
		</ul>
<body>
	<div class="profile-main">
		<div class="profile-box">
		<h2>Edit your profile</h2>
		<s:form action="/profile/editProfile/" styleClass="profileForm">
			<div class="email">
				<h4>Email</h4>
				<html:text property ="updateEmail" size="60" styleClass="textBox"/>
					<div class = "emailError">
						<html:errors property="updateEmail"/>
					</div>
			</div>
			<div class="name">
				<h4>Name</h4>
				<html:text property="updateName"  size="60" styleClass = "textBox"/>
					<div class="nameError">
					<html:errors property="updateName"/>
					</div>
			</div>
			<div class="profile">
			<div class="status">
				<h4>School or Company</h4>
				<html:select property="updateStatus">
    　							<html:option value=""></html:option>
    　							<html:option value="student">Student</html:option>
    　							<html:option value="company">Company</html:option>
						</html:select>
						</div>
			<div class = "group">
				<h4>School/Company Name</h4>
					<html:text property="updateGroup"  size="60" styleClass = "textBox"/><br>
			</div>
			<div class = "recrutingNumber">
					<c:choose>
						<c:when test="status">
								<div class = "graduationYear">
									<h4>Graduating Year</h4>
									<html:select property="graduationYear">
    　										<dl><html:option value=""></html:option><dl>
    　										<dl><html:option value="2014">2014</html:option><dl>
    　										<dl><html:option value="2015">2015</html:option><dl>
    　										<dl><html:option value="2016">2016</html:option><dl>
    　										<dl><html:option value="2017">2017</html:option><dl>
    　										<dl><html:option value="2018">2018</html:option><dl>
    　										<dl><html:option value="2019">2019</html:option><dl>
    　										<dl><html:option value="2020">2020</html:option><dl>
    　										<dl><html:option value="2021">2021</html:option><dl>
									</html:select>
								</div>
								<div class ="industry">
								<h4>Interested Industry</h4>
								<html:text property="interestedIndustry" size="60"/>
								<html:errors property="interestedIndustry"/>
								</div>
						</c:when>
						<c:otherwise>
							<div class ="recruit">
							<h4>Recruiting Number</h4>
							<html:text property="recruitingNumber" size ="60"/>
							<html:errors property="recruitingNumber"/>
							</div>
						</c:otherwise>
					</c:choose>
			</div>
			</div>
			<div class="password">
				<h4>Password</h4>
				*8文字以上、20文字以内で入力してください。<br>
					<html:password property="updatePassword"  size="60" styleClass="textBox"/><br>
					Confirm password: <html:password property="confirmPass" size="60" styleClass="textBox"/><br>
					<div class ="passwordError">
						<html:errors property="updatePassword"/>
					</div>
			</div>
				<s:submit property="editProfile" styleClass="register"/><br>
	</div>
	</s:form>
	</div>
</body>
</div>
</html>
