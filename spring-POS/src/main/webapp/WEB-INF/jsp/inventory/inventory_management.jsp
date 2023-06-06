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
	<h1> Items List </h1>
	<div>

	</div>
	<p class="clear"></p>
	<table>
	    <thead>
	        <tr>
	            <th class="table_head" colspan="6">상품 목록</th>
	            <td colspan="1">
		            <form action="/inventory/register_item" method="post">
						<input Type="submit" value="신규 등록">
					</form>
				</td>
	        </tr>
	    </thead>
    <tbody>
        	<tr>
				<td>index</td>
				<td>상품 ID</td>
				<td>상품 이름</td>
				<td>상품 가격</td>
				<td>상품 갯수</td>
				<td>유통 기간</td>
				<td>정보 수정</td>
				<td>정보 삭제</td>
			</tr>
            <c:forEach var="item" items="${items}" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
						<form action="/inventory/modify_item" method="post">
						<td>${item.ID}<input Type="hidden" name="ID" value="${item.ID}"></td>
						<td>${item.name}<input Type="hidden" name="name" value="${item.name}"></td>
						<td>${item.price}<input Type="hidden" name="price" value="${item.price}"></td>
						<td>${item.count}<input Type="hidden" name="count" value="${item.count}"></td>	
						<td>${item.expiration_date}<input Type="hidden" name="expiration_date" value="${item.expiration_date}"></td>
						<td>
							<input class="input_size" Type="submit" value="수정">
						</form>
					</td>
					<td>
						<form action="/inventory/delete_agreement" method="post">
							<input Type="hidden" name="ID" value="${item.ID}">
							<input Type="hidden" name="price" value="${item.price}">
							<input Type="hidden" name="count" value="${item.count}">
							<input Type="hidden" name="expiration_date" value="${item.expiration_date}">
							<input class="input_size" Type="submit" value="삭제">
						</form>
					</td>
				</tr>
			</c:forEach>
    </tbody>
</table>

</body>
</html>