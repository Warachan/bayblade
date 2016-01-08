<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset = "utf-8">
	<title>BEYBLADE</title>
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
			<div class="player1">
				<img src="/img/max.jpg">
				<FONT size="20" color="#000000">戦駒力:${power}</FONT>
			</div>
			<img src="/img/vs.jpeg">
			<c:if test="${fightFLg}" >
			<div class="player2">
				<img src="/img/kai.jpg">
				<FONT size="20" color="#000000">戦駒力:??????</FONT>
			</div>
			<a href="${winUrl}" target="_blank">result</a>
			</c:if>
	</div>
	</div>
</body>
	<div class="footer">
		<p>2016 tanakatomy All Rights Reserved</p>
	</div>
</div>
</html>

