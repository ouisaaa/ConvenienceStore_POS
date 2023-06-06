<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POS</title>
</head>
<body>
	<p>${worker.ID} 님의 정보를 삭제하시겠습니까?</p>
	<form action="/worker/delete_success" method="post">
		<input Type="hidden" name="ID" value="${worker.ID}">
		<input type="submit" value="예">
	</form>
	<form action="/worker/worker_option" method="post">
		<input type="submit" value="취소">
	</form>
</body>
</html>