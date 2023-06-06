<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POS</title>
</head>
<body>
	<p>${inventory.ID} 제품의 정보를 삭제하시겠습니까?</p>
	<form action="/inventory/delete_success" method="post">
		<input Type="hidden" name="ID" value="${inventory.ID}">
		<input Type="hidden" name="price" value="${inventory.price}">
		<input Type="hidden" name="count" value="${inventory.count}">
		<input Type="hidden" name="expiration_date" value="${inventory.expiration_date}">
		<input type="submit" value="예">
	</form>
	<form action="/inventory/inventory_management" method="post">
		<input type="submit" value="취소">
	</form>
</body>
</html>