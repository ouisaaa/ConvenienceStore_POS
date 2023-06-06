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
	<h1> Wish List </h1>
	<div>

	</div>
	<p class="clear"></p>
	<table>
	    <thead>
	        <tr>
	            <th class="table_head" colspan="6">구매 물품 리스트</th>
	        </tr>
	    </thead>
    <tbody>

	    		<tr>
					<form action="/sell/sell_search" method="post">
			            <td colspan="2">
				           	<input Type="Text" name="search" value="">
						</td>
			            <td colspan="1">
							<input Type="submit" value="물품 추가">
						</td>
					</form>
					<td></td>
					<td colspan="1">
						<form action="/sell/sell_agreement" method="post">
							<input class="input_size" Type="submit" value="물품 구매">
						</form>
					</td>
					<td colspan="1">
			            <form action="/sell/reset" method="post">
							<input class="input_size" Type="submit" value="초기화">
						</form>
					</td>
				</tr>
	        	<tr>
					<td>index</td>
					<td>상품 ID</td>
					<td>상품 이름</td>
					<td>상품 가격</td>
					<td>  수량  </td>
					<td>추가/삭제</td>
				</tr>
	            <c:forEach var="item" items="${items}" varStatus="status">
					<tr>
						<td>${status.index+1}</td>
						<td>${item.ID}<input Type="hidden" name="ID" value="${item.ID}"></td>
						<td>${item.name}<input Type="hidden" name="name" value="${item.name}"></td>
						<td>${item.price}<input Type="hidden" name="price" value="${item.price}"></td>
						<td colspan="1">${item.count}</td>	
						<td colspan="1">
							<form action="/sell/sell_countModifyPlus">
								<input Type="hidden" name="clone_index" value="${status.index+1}">
								<input Type="submit" name="plus" value="+">
							</form>
							<form action="/sell/sell_countModifyMinus">
								<input Type="hidden" name="clone_index" value="${status.index+1}">
								<input Type="submit" name="minus" value="-">
							</form>
						</td>
					</tr>
				</c:forEach>
    </tbody>
</table>
</body>
</html>