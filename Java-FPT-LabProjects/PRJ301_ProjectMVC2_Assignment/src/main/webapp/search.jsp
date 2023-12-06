<%-- r
    Document   : search
    Created on : Feb 16, 2023, 8:11:00 AM
    Author     : HOANGANH
--%>

<%--<%@page import="login.userlogin.UserloginDAO"%>
<%@page import="login.userlogin.UserloginDTO"%>
<%@page import="java.util.List"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Search Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<!-- Welcome -->
	<font color="red"> Welcome, ${sessionScope.USER.fullName}<br>
	<br> <!-- coppy tu properties cua thang OBJECT DTO -->
	</font>
	<div style="margin-bottom: 20px;">
		<form action="DispatchServlet">
			<input type="submit" value="Logout" name="btAction" />
		</form>
	</div>


	<form action="DispatchServlet" method="POST">
		Search Value <input type="text" name="txtSearchValue"
			value="${param.txtSearchValue}">
		<!-- coppy o trang searchservlet -->
		<input type="submit" value="Search" name="btAction"><br>
	</form>
	<!--che dau duong truyen thi dung post-->

	<!-- SHOW RESULT SEARCH -->
	<c:set var="searchValue" value="${param.txtSearchValue}" />
	<c:if test="${not empty searchValue}">
		<c:set var="result" value="${requestScope.SEARCH_RESULT}" />

		<c:if test="${not empty result}">
			<table border="1">
				<thead>
					<tr>
						<th>No.</th>
						<th>Username</th>
						<th>Password</th>
						<th>Full Name</th>
						<th>Role</th>
						<th>Delete</th>
						<th>Update</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dto" items="${result}" varStatus="counter">
						<form action="DispatchServlet">
							<tr>
								<td>${counter.count}</td>
								<td>${dto.username} <input type="hidden" name="txtUsername"
									value="${dto.username}">
								</td>
								<td>
									<!-- ${dto.password}--> <input type="text" name="txtPassword"
									value="${dto.password}">
								</td>
								<td>${dto.fullName}</td>
								<td>
									<!-- ${dto.role} --> <input type="checkbox" name="chkAdmin"
									value="Admin"
									<c:if test="${dto.role}"> 
                                                         checked="checked"                                                     
                                                    </c:if> />
								</td>
								<td><c:url var="urlRewriting" value="DispatchServlet">
										<c:param name="btAction" value="Delete" />
										<c:param name="pk" value="${dto.username}" />
										<c:param name="lastSearchValue" value="${searchValue}" />
									</c:url> <a href="${urlRewriting}">Delete</a></td>
								<td><input type="submit" value="Update" name="btAction" />
									<input type="hidden" name="lastSearchValue"
									value="${searchValue}"></td>
							</tr>
						</form>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty result}">
			<!--  null is set to string in test -->
			<h2>No Record Is Matched !!!!</h2>
		</c:if>
	</c:if>



</body>
</html>
