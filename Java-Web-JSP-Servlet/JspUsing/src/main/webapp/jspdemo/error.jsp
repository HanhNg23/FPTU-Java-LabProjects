<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page isErrorPage="true" import="java.io.*" %>  
<!-- isErrorPage Indicates if this JSP page is a URL 
specified by another JSP page's errorPage attribute --> 
<html>
<head>
<meta charset="ISO-8859-1">
<title>Some Error In Page</title>
</head>
<body>
Message:
<%=exception.getMessage()%> 
<h3>StackTrace:</h3>
<%
  StringWriter stringWriter = new StringWriter();
  PrintWriter printWriter = new PrintWriter(stringWriter);
  exception.printStackTrace(printWriter);
  out.println("<pre>");
  out.println(stringWriter);
  out.println("</pre>");
  printWriter.close();
  stringWriter.close();
%>
</body>
</html>