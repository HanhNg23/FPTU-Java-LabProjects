<%-- 
    Document   : signupForm
    Created on : Feb 3, 2023, 9:01:11 PM
    Author     : HOANGANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <title>Sign Up Form</title>
     </head>
     <body>
          <h1>SIGN UP</h1>
          <div class="main">
               <div><strong><% String mess = (String) request.getAttribute("mess");
                    if (mess != null) {
                         out.println(mess);
                    }%></strong></div><br>
               <form action= "<%=request.getContextPath()%>/UserSignupServlet" method="POST">
                    <div>Username <input type="text" name="username"  placeholder="username"></div><br>
                    <div>Password <input type="password" name="password"  placeholder="password"></div><br>
                    <div class = "forSign">        
                         <input style="font-size: 18px; margin-top: 0px; " type="submit" name="btAction" value="Create"><br>
                    </div>
               </form>
          </div>
          <a style =" color: blue;  " href="<%=request.getContextPath()%>/UserLoginServlet">Go To Login</a>
     </body>
</html>
