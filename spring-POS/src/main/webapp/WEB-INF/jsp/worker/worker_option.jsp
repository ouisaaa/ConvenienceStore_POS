<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>POS</title>
	<style>
		table,
		td {
		    border: 1px solid #333;
		}
		
		.table_head {
		    background-color: #333;
		    color: #fff;
		}
		.input_size{
			width: 100%;
		}
	</style>
</head>
<body>
	<h1> Worker List </h1>
	<table>
	    <thead>
	        <tr>
	            <th class="table_head" colspan="6">직원 목록</th>
	            <td colspan="1">
		            <form action="/worker/register_worker" method="post">
						<input Type="submit" value="신규 등록">
					</form>
				</td>
	        </tr>
	    </thead>
    <tbody>
        	<tr>
				<td>index</td>
				<td>직원 ID</td>
				<td>직원 이름</td>
				<td>등록 날짜</td>
				<td>직급</td>
				<td>정보 수정</td>
				<td>정보 삭제</td>
			</tr>
            <c:forEach var="worker" items="${workers}" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
						<form action="/worker/modify_worker" method="post">
						<td>${worker.ID}<input Type="hidden" name="ID" value="${worker.ID}"></td>
						<td>${worker.name}<input Type="hidden" name="name" value="${worker.name}"></td>
						<td>${worker.start_date}</td>
						<td>${worker.title}<input Type="hidden" name="title" value="${worker.title}"></td>
						<td>
							<input class="input_size" Type="submit" value="수정">
						</form>
					</td>
					<td>
						<form action="/worker/delete_agreement" method="post">
							<input Type="hidden" name="ID" value="${worker.ID}">
							<input class="input_size" Type="submit" value="삭제">
						</form>
					</td>
				</tr>
			</c:forEach>
    </tbody>
</table>

</body>
</html>