<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head> 
<title>POS</title> 
<style>
</style>
</head>
<body>
	<h2>상품 등록</h2>
	<form action="/inventory/register_success" method="post">
		<p> <label>상품 ID:<br>
			<input type="text" name="ID" id="ID" value="${registerRequest.ID}">
		</label> </p>
		<p> <label>상품 이름:<br>
			<input type="text" name="name" id="name" value="${registerRequest.name}">
		</label> </p>
		<p> <label>상품 가격:<br>
			<input type="text" name="price" id="price" value="${registerRequest.price}">
		</label> </p>
		<p> <label>유통 기한(일자):<br>
			<input type="text" name="expiration_date" id="expiration_date" value="${registerRequest.expiration_date}">
		</label> </p>
			<input type="submit" value="등록 완료">
	</form>
</body>
</html>