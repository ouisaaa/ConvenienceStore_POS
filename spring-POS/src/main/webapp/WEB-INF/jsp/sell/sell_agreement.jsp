<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>POS</title>
</head>
<body>
	<form action="/sell/sell_success" method="post">
		<p>�� �ݾ��� ${totalPrice} �Դϴ�.</p>
		<p>��� �Ͻðڽ��ϱ�?</p>
		<input Type="submit" Value="���">
		<input Type="button" Value="���" onclick="window.history.back()">
		<!--�ڹٽ�ũ��Ʈ�� �ڷΰ��� ��ư -->
	</form>
</body>
</html>