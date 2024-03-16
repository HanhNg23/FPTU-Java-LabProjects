<%@page import="com.userlogin.control.UserLoginServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello World</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a style = "padding: 8px;  border: 1px solid black; font-size: 20px;" href="<%=request.getContextPath()%>/UserLoginServlet">Log Out</a>
    </body>
</html>
