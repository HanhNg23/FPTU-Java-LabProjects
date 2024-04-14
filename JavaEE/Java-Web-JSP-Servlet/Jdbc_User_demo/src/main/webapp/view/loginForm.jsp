<%-- 
    Document   : loginForm
    Created on : Jan 28, 2023, 1:00:22 PM
    Author     : HOANGANH
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
     <head>
          <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
          <title>Login</title>
     </head>
     <body>
           <h1>Login form</h1>
           <div> <%=request.getAttribute("mess")%></div>
          <form action="UserLoginServlet" method="POST">
               Username <input type="text" name="username" value=${"username"}><br>
               Password <input type="password" name="password" value=${"password"}<br>
               <input type="checkbox" name="remember" value="1"> Remember me
               <input type="submit" value="login">
          </form>
     </body>
</html>
