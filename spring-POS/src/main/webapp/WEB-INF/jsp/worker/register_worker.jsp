<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head> 
<title>POS</title> 
<style>
</style>
</head>
<body>
	<h2>직원 등록</h2>
	<form action="/worker/register_success" method="post">
		<p> <label>직원 ID:<br>
			<input type="text" name="ID" id="ID" value="${registerRequest.ID}">
		</label> </p>
		<p> <label>이름:<br>
			<input type="text" name="name" id="name" value="${registerRequest.name}">
		</label> </p>
		<p> <label>비밀번호:<br>
			<input type="password" name="password" id="password">
		</label> </p>
		<p> <label>비밀번호 확인:<br>
			<input type="password" name="confirmPassword" id="confirmPassword">
		</label> </p>
		<p> <label>직급:<br>
			<select type="title" name="title" id="title" value="${registerRequest.title}">
				<option value='' selected>-----</option>
				<option value='manager'>manager</option>
				<option value='worker'>worker</option>
			</select>
		</label> </p>
			<input type="submit" value="가입 완료">
	</form>
</body>
</html>