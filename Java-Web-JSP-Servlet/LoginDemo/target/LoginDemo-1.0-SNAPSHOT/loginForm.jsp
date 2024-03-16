<%-- 
    Document   : loginForm
    Created on : Jan 28, 2023, 1:00:22 PM
    Author     : HOANGANH
--%>


<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%String username = (String) request.getAttribute("username");
     String password = (String) request.getAttribute("password");
     if (username == null && password == null) {
          username = "";
          password = "";
     }
%>


<style>
     body{
          text-align: center;
     }

     .main{
          width: 300px;
          padding: 30px;
          margin: 0 auto;
          border: 1px solid black;
     }

</style>
<!DOCTYPE html>
<html>
     <head>
          <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
          <title>Login Form</title>
     </head>
     <body>
          <h1>LOGIN</h1>
          <div class ="main">
               <div><strong><% String mess = (String) request.getAttribute("mess");
                    if (mess != null)
                         out.println(mess);%></strong></div><br>
               <form action= "<%=request.getContextPath()%>/UserLoginServlet" method="POST">
                    <div>Username <input type="text" name="username" value="<%=username%>" placeholder="username"></div><br>
                    <div>Password <input type="password" name="password" value="<%=password%>" placeholder="password"></div><br>
                    <div class = "forLog">
                         <input type="checkbox" name="remember" value="1"> Remember me <br>
                         <input style="font-size: 18px; margin-top: 30px; " type="submit" name="btAction" value="Login"><br>
                    </div>
               </form>
                    <form action="<%=request.getContextPath()%>/UserSignupServlet" method="GET">
                    <div class = "forSign">        
                         <input style="margin-top: 40px; background: none; " type="submit" value="Sign Up New Accout">
                         <!--                              <input style="font-size: 18px; margin-top: 0px; " type="submit" value="Create"><br>-->
                    </div>
               </form>
          </div>
     </body>
</html>
