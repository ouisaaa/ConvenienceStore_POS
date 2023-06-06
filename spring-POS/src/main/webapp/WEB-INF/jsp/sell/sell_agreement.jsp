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
		<p>총 금액은 ${totalPrice} 입니다.</p>
		<p>계산 하시겠습니까?</p>
		<input Type="submit" Value="계산">
		<input Type="button" Value="취소" onclick="window.history.back()">
		<!--자바스크립트로 뒤로가기 버튼 -->
	</form>
</body>
</html>