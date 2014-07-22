<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset = "utf-8">
	<title>Profile</title>
	<link rel="stylesheet" type="text/css" href="${f:url('/css/twitterHome.css')}" />
	<link href='http://fonts.googleapis.com/css?family=Libre+Baskerville' rel='stylesheet' type='text/css'>
</head>
<div class = "wrapper">
		<jsp:include page="/WEB-INF/view/glonavi.jsp"/>
	<div class ="header">
		<p>Pocketer</p>
	</div>
<body>
	<div class="profile-main">
		<div class = "profile-main-top">
		<h1>My current Profile</h1>
		<div class = "profile-top">
				<h2>${f:h(account)}</h2>
				<s:form action = "/profile/">
					<div class = "currentStatus">
						<c:choose>
							<c:when test="${recruitStatus}">
								<ul>
									<li id="tweetList">
										<dt id="status">所属大学:${f:h(groupName)} （卒業年：${f:h(graduationYear)}年）</dt>
										<dt id="status">希望業界:${f:h(interestedIndustry)}</dt>
									</li>
								</ul>
							</c:when>
							<c:otherwise>
								<ul>
									<li id="tweetList">
										<dt id="status">所属企業：  ${f:h(groupName)}</dt>
										<dt id="status">予定採用人数: ${f:h(recruitingNumber)}</dt>
									</li>
								</ul>
							</c:otherwise>
						</c:choose>
					</div>
				</s:form>
		</div>
		</div>
		<div class="profile-box">
			<h3>Edit your profile</h3>
			<p id="comment">☆編集したい項目に入力してください☆</p>
			<s:form action="/profile/editProfile/" styleClass="profileForm">
				<div class="name">
					<h4>Name</h4>
						<html:text property="updateName"  size="60" value="${f:h(currentName)}" styleClass = "textBox"/>
					<div class="nameError">
						<html:errors property="updateName"/>
					</div>
				</div>
			<div class="profile">
				<div class = "group">
					<h4>School/Company Name</h4>
					<html:text property="updateGroup"  size="60" value="${f:h(groupName)}" styleClass = "textBox"/><br>
					<html:errors property ="updateGroup"/>
				</div>
				<div class = "recrutingNumber">
					<c:choose>
						<c:when test="${status}">
							<div class = "graduationYear">
								<h4>Graduating Year</h4>
								<html:select property="graduationYear">
    　								 <!--<dl><html:option value="graduationYear">${f:h(graduationYear)}</html:option><dl>-->
    　								 <dl><html:option value=""></html:option><dl>
				                 <c:forEach items="${yearList}" var="items" varStatus="status">
						            <dl><html:option value="${f:h(items.graduationNumber)}">${f:h(items.graduationNumber)}</html:option></dl>
				                 </c:forEach>
    　									<!--<dl><html:option value="2014">${f:h(2014)}</html:option><dl>
    　									<dl><html:option value="2015">${f:h(2015)}</html:option><dl>
    　									<dl><html:option value="2016">${f:h(2016)}</html:option><dl>
    　									<dl><html:option value="2017">${f:h(2017)}</html:option><dl>
    　									<dl><html:option value="2019">${f:h(2019)}</html:option><dl>
    　									<dl><html:option value="2020">${f:h(2020)}</html:option><dl>
    　									<dl><html:option value="2021">${f:h(2021)}</html:option><dl>
    　									<dl><html:option value="2022">${f:h(2022)}</html:option><dl>
    　									<dl><html:option value="2023">${f:h(2023)}</html:option><dl>-->
								</html:select>
							</div>

							<div class ="industry">
								<h4>Interested Industry</h4>
								<html:text property="interestedIndustry" value="${f:h(interestedIndustry)}" size="60"/>
								<html:errors property="interestedIndustry"/>
							</div>
						</c:when>
						<c:otherwise>
							<div class ="recruit">
							<h4>Recruiting Number</h4>
							<html:select property="recruitingNumber">
    　									<!--<dl><html:option value="recruitingNumber">${f:h(recruitingNumber)}</html:option><dl>-->
    　									<dl><html:option value=""></html:option><dl>
    　									<dl><html:option value="10人未満">${f:h("10人未満")}</html:option><dl>
    　									<dl><html:option value="10～29人">${f:h("10~29人")}</html:option><dl>
    　									<dl><html:option value="30~49人">${f:h("30~49人")}</html:option><dl>
    　									<dl><html:option value="50~99人">${f:h("50~99人")}</html:option><dl>
    　									<dl><html:option value="100~299人">${f:h("100~299人")}</html:option><dl>
    　									<dl><html:option value="300~499人">${f:h("300~499人")}</html:option><dl>
    　									<dl><html:option value="500人以上">${f:h("500人以上")}</html:option><dl>
							</html:select>
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
				<s:submit property="editProfile" value="Finish editing" styleClass="register"/><br>
			</s:form>
		</div>
	</div>
	<div class="footer">
			<p>©2014 AnnieWaraPocket All Rights Reserved</p>
	</div>
</body>
</div>
</html>
