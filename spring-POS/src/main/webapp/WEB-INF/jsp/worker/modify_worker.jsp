<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POS</title>
</head>
<body>
	<h2>직원 정보 수정</h2>
	<form action="/worker/modify_success" method="post">
		<p> <label>직원 ID:<br>
			"${worker.ID}"
			<input type="hidden" name="ID" id="ID" value="${worker.ID}">
		</label> </p>
		<p> <label>이름:<br>
			<input type="text" name="name" id="name" value="${worker.name}">
		</label> </p>
		<p> <label>비밀번호:<br>
			<input type="password" name="password" id="password">
		</label> </p>
		<p> <label>비밀번호 확인:<br>
			<input type="password" name="confirmPassword" id="confirmPassword">
		</label> </p>
		<p> <label>직급:<br>
			<select type="title" name="title" id="title" value="${worker.title}">
				<option value=''>-----</option>
				<option value='manager'>manager</option>
				<option value='worker'>worker</option>
			</select>
		</label> </p>
			<input type="submit" value="수정 완료">
	</form>
</body>
</html>