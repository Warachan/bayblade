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
		<p>BEYBLADE</p>
		
	</div>
<body>
	<div class ="top-background">
	<div class ="top-main">
		<p class ="intro">BEYBLADE</p>
			<div class="player1">
				<img src="/img/max.jpg">
			</div>
			<img src="/img/vs.jpeg">
			<c:if test="${fightFLg}" >
			<div class="player2">
				<img src="/img/kai.jpg">
			</div>
			<a href="${winUrl}" target="_blank">result</a>
			</c:if>
	</div>
	</div>
</body>
	<div class="footer">
		<p>201７ AnnieWaraPocket All Rights Reserved</p>
	</div>
</div>
</html>

