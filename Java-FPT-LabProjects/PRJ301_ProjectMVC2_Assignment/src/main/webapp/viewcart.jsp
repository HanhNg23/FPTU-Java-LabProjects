<%-- 
    Document   : viewcart
    Created on : Feb 27, 2023, 8:34:54 AM
    Author     : HOANGANH
--%>

<%@page import="java.util.Map"%>
<%@page import="login.userlogin.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Store</title>
</head>
<body>

	<!-- Before view have to check the session, the cart, the items are exits the allow to show -->
	<%
               /* //1. Customer goes to his/her cart place
               if (session != null) { //gio co ton tai moi view
                    //2. Custmoer take his/her cart
                    CartObj cart = (CartObj) session.getAttribute("CART");
                    //check cart has to exist to view
                    if (cart != null) {
                         //3. Customer get all items
                         Map<String, Integer> items = cart.getItems();
                         if (items != null) {
                              //4. Show item*/
          %>
	<h1>BOOK STORE VIEW</h1>
	<c:if test="${not empty sessionScope}">
		<c:set var="cart" value="${sessionScope.CART}" />
		<c:if test="${not empty cart}">
			<c:set var="items" value="${cart.items}" />
			<c:if test="${not empty items}">
				<table border="1">
					<thead>
						<tr>
							<th>No.</th>
							<th>Name</th>
							<th>Quantity</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<form action="DispatchServlet">
							<c:forEach var="item" items="${cart.items}" varStatus="counter">
								<tr>
									<td>${counter.count}</td>
									<td>${item.key}</td>
									<td>${item.value}</td>
									<td><input type="checkbox" name="chkItem"
										value="${item.key}"></td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="3"><a href="shopping.html">Add More Items
										To Your Cart</a></td>
								<td><input type="submit" value="Remove Selected Items"
									name="btAction"></td>
							</tr>
						</form>
					</tbody>
				</table>
				<form action="DispatchServlet">
					<input type="submit" value="Checkout" name="btAction" />
				</form>
			</c:if>
		</c:if>
	</c:if>
	<c:set var="Check" value="Checkout" />
	<c:if test="${param.btAction != Check}">
		<c:if
			test="${empty sessionScope || empty sessionScope.CART || empty sessionScope.CART.items }">
			<h2>Empty Cart !!!</h2>
		</c:if>
	</c:if>
	<c:if test="${param.btAction == Check}">
		<h3>${requestScope.MSG}</h3>
		<a href="shopping.html">Turn Back To Shopping</a>
	</c:if>


</body>

</html>
