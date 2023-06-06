<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
	<head>
	<title>POS-메인</title>
	</head>
<body>
	<h2>POS 웹</h2>
	<p>환영합니다.</p>
	<form Action="/worker/worker_option" method="post">
		<input Type="Submit" Value="계정 기능">
	</form>
	<br>
	<form Action="/inventory/inventory_management" method="post">
		<input Type="Submit" Value="재고 관리">
	</form>
	<br>
	<form Action="/sell/sell_management" method="post">
		<input Type="Submit" Value="판매 기능">
	</form>
	<br>
	<form Action="/statistics/statistics" method="post">
		<input Type="Submit" Value="통계 기능">
	</form>
</body>
</html>