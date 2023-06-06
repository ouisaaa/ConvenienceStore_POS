<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POS</title>
</head>
<body>
	<h2>등록 상품 정보 수정</h2>
	<form action="/inventory/modify_success" method="post">
		<p> <label>상품 ID:<br>
			"${inventory.ID}"
			<input type="hidden" name="ID" id="ID" value="${inventory.ID}">
		</label> </p>
		<p> <label>상품 이름:<br>
			<input type="text" name="name" id="name" value="${inventory.name}">
		</label> </p>
		<p> <label>상품 가격:<br>
			<input type="text" name="price" id="price" value="${inventory.price}">
		</label> </p>
		<p> <label>상품 수량:<br>
			<input type="text" name="count" id="count" value="${inventory.count}">
		</label> </p>
		<p> <label>유통 기한(일자):<br>
			<input type="text" name="expiration_date" id="expiration_date" value="${inventory.expiration_date}">
		</label> </p>
			<input type="submit" value="수정 완료">
	</form>
</body>
</html>