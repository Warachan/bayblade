<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset = "utf-8">
	<title>BEYBLADE</title>
	<link rel="stylesheet" type="text/css" href="${f:url('/css/twitterHome.css')}" />
	<link href='http://fonts.googleapis.com/css?family=Libre+Baskerville' rel='stylesheet' type='text/css'>
	<script type="text/javascript">
		
		function showResult() {
			document.getElementById('player1_result').innerHTML = '<fmt:formatNumber value="${power}" pattern="###,##0" />';
			document.getElementById('player2_result').innerHTML = '<fmt:formatNumber value="${power2}" pattern="###,##0" />';
			document.getElementById('youtube').setAttribute('style', 'display: block;');
			document.getElementById('battle_btn').setAttribute('style', 'display: none;');
		}
	</script>
	<style type="text/css">
		body {
			background-color: #000000;
		}
		.win {
			color: red;
			font-size: 40pt;
		}
		.lose {
			color: blue;
			font-size: 40pt;
		}
	</style>
</head>
<body>
<div class="wrapper" style="text-align: center; color: orange;">
	<div style="color: orange; font-size: 15pt; font-weight: bold; margin: 10px 0;">
		<p>PI BLADE</p>
	</div>
	<div class ="top-background">
	<div class ="top-main" style="padding: 30px 0;">
		<c:if test="${fightFLg}" >
			<div id="youtube" style="display: none;">
				<c:if test="${winner == 1}" >
					<span class="win">WIN</span>
					<iframe width="420" height="315" src="https://www.youtube.com/embed/aDI0tRMwiFI?autoplay=1" frameborder="0" allowfullscreen></iframe>
					<span class="lose">LOSE</span>
				</c:if>
				<c:if test="${winner == 2}" >
					<span class="lose">LOSE</span>
					<iframe width="420" height="315" src="https://www.youtube.com/embed/TSMIPxBWh0s?autoplay=1" frameborder="0" allowfullscreen></iframe>
					<span class="win">WIN</span>
				</c:if>
			</div>
		</c:if>
		<table style="margin-left: auto; margin-right: auto;">
			<tr>
				<td class="player1" style="width: 300px; ">
					<c:if test="${power > 0}" >
						<img src="/img/max.jpg"><br>
						<FONT size="20">戦駒力<br><span id="player1_result">??????</span></FONT>
					</c:if>
					<c:if test="${power == 0}" >
						NO PLAYER
					</c:if>
				</td>
				<td style="width: 250px; ">
					<img src="/img/vs.png">
				</td>
				<td class="player2" style="width: 300px; ">
					<c:if test="${fightFLg}" >
						<div class="player2">
							<img src="/img/kai.jpg"><br>
							<FONT size="20">戦駒力<br><span id="player2_result">??????</span></FONT>
						</div>
					</c:if>
					<c:if test="${!fightFLg}" >
						NO PLAYER
					</c:if>
				</td>
			</tr>
		</table>
		<c:if test="${fightFLg}" >
			<button onclick="showResult();" id="battle_btn" style="font-size: 30pt; height: 70px; width: 200px;">BATTLE!!</button>
		</c:if>
	</div>
	</div>
	<div class="footer" style="background-color: #999999;">
		<p>2016 tanakatomy All Rights Reserved</p>
	</div>
</div>
</body>
</html>

