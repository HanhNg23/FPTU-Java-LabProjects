<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<style>
.insertForm {
	width: 300px;
	border: 1px solid black;
	height: 150px;
	font-size: 15px;
	margin: 0 auto;
	padding-left: 20px;
}

.field {
	margin-top: 20px;
}

</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Form</title>
</head>
<body>
	<h1>User Form</h1>
	<h2 style="color: black; font-weight: bold; text-align: center;">Add New User</h2>
	<div class="form">
		<form class="insertForm" action="<%=request.getContextPath()%>/insert" method="POST">
			<div class="field">
				<label for="name">Username: </label>
				<input type="text" placeholder="name" name="name" id="name">
			</div>
			<div class="field">
				<label for="email">Email: </label> 
				<input type="email" placeholder="example@example.com" name="email" id="email">
			</div>
			<div class="field">
				<label for="country">Country: </label> 
				<input type="text" placeholder="country" name="country" id="country">
			</div>
			<div style="text-align: center;">
				<button id="submit" style="margin-top: 50px; color: black; font-weight: bold;">Save</button>
			</div>
		</form>
	</div>
</body>
</html>