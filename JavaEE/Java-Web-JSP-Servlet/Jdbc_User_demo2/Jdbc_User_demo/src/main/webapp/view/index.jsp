<!-- index.jsp is used to show all data list from database -->
<%@ page import="java.util.*, com.usermanagement.model.User"%>
<%@ page
	import="javax.servlet.http.HttpServletRequest,
                javax.servlet.http.HttpServletResponse,
                javax.servlet.jsp.JspWriter
                "%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%! int id; String name, email, country;%>


<style>
.tableList {
	margin-top: 100px;
	/* background-color: aquamarine; */
	text-align: center;
}

table {
	margin: 0 auto;
}

thead th, td {
	width: 300px;
	height: 30px;
	text-align: center;
	padding: 0;
    border: 1px solid black;
	
}

thead th:first-child, td:first-child, th:nth-of-type(5), td:nth-of-type(5){
	width: 100px;
}
</style>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Form</title>
</head>
<body>
	<%
	List<User> list = (List) request.getAttribute("list");
	%>
	<h1 style="color: black; font-weight: bold; text-align: center;"><a style="text-decoration: none;" href="<%=request.getContextPath()%>/showall">User List</a></h1>
	<div class="tableList">
		<table>
			<thead>
				<th>id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Country</th>
			</thead>
			<%
			for (int i = 0; i < list.size(); i++) {
				id = list.get(i).getId();
				name = list.get(i).getName();
				email = list.get(i).getEmail();
				country = list.get(i).getCountry();
			%>
			<tr>
				<td><%=id%></td>
				<td><%=name%></td>
				<td><%=email%></td>
				<td><%=country%></td>
				<td style="border: none;" ><form action="<%=request.getContextPath()%>/delete"><input type="hidden" name="id" value="<%=id%>"><button style=" margin-bottom: 0px;  margin-top: 5px;">Delete</button></form></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<div>
		<form action="view/userForm.jsp"> <!-- Forward to page add new user -->
			<input type="submit" value="Add New User" style="color: black; font-weight: bold; margin-top:30px; margin-left: 300px;" >
		</form>
	</div>
</body>
</html>