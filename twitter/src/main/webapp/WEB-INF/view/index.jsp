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
				<img src="/twitter/img/syuukatu.jpg">
			</div>
			<span>vs</span>
			<c:if test="${fightFLg}" >
			<div class="player2">
				<img src="/twitter/img/kigyou.jpg">
			</div>
			<a href="${winUrl}">結果</a>
			</c:if>
	</div>
	</div>
</body>
	<div class="footer">
		<p>Â©201７ AnnieWaraPocket All Rights Reserved</p>
	</div>
</div>
</html>

