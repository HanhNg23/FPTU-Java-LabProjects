<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java In HTML</title>
</head>
<body>
	<%@ page import="java.util.Random,java.text.*"%>
	<%
        Random random = new Random();
        // Returns a random number (0, 1 or 2)
        int randomInt = random.nextInt(3); 
        if (randomInt == 0) {
    %>
	<h1>
		Random value =<%=randomInt%></h1>
	<%
        } else if (randomInt == 1) {
     %>
	<h2>
		Random value =
		<%=randomInt%></h2>
	<% } else{ %>
	<h3>
		Random value =
		<%=randomInt%></h3>
	<% } %>

	<a href="<%= request.getRequestURI() %>">Try Again</a>


</body>
</html>