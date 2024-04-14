<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Import declaration -->
	<%@ page import="java.util.*, java.text.*"%>

	<%@ page import="java.util.List, java.text.*"%>

	<%@ page
		import="javax.servlet.http.HttpServletRequest,
                javax.servlet.http.HttpServletResponse,
                javax.servlet.jsp.JspWriter
                "%>
	<%
	// Using out variable:
	out.println("<h1>Now is " + new Date() + "</h1>");
	// Using request variable:
	String serverName = request.getServerName();
	System.out.print(serverName);
	// Using response variable:
	response.sendRedirect("http://eclipse.org");
	%>

</body>
</html>