<%-- 
    Document   : createAcc
    Created on : Mar 15, 2023, 10:27:06 PM
    Author     : HOANGANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
     <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <title>Sign Up</title>
     </head>
     <body>
          <c:set var="err" value="${requestScope.insertErr}"></c:set>
               <div>
                    <form action="DispatchServlet" method="POST">
                    <c:if test="${not empty err.usernameLengthOrExistsErr}">
                         <font color="red">
                         ${err.usernameLengthOrExistsErr}
                         </font><br>
                    </c:if>                   
                    Username * <input type="text" name="txtUsername" value="${param.txtUsername}" /> (6 - 20 characters)<br><br>

                    <c:if test="${not empty err.passwordLengthErr}">
                         <font color="red">
                         ${err.passwordLengthErr}
                         </font><br>
                    </c:if>        
                    Password * <input type="password" name="txtPassword" value="${param.txtPassword}" />(5-20 characters)<br><br>

                    <c:if test="${not empty err.confirmErr}">
                         <font color="red">
                         ${err.confirmErr}
                         </font><br>
                    </c:if>       

                    Confirm * <input type="password" name="txtConfirm" value="${param.txtConfirm}" /><br><br>
                    <c:if test="${not empty err.fullnameLengthErr}">
                         <font color="red">
                         ${err.fullnameLengthErr}
                         </font><br>
                    </c:if>  
                    Full Name * <input type="text" name="txtFullname" value="${param.txtFullname}" />(2-50 characters)<br><br>
                    <input type="reset" value="Reset" />
                    <input type="submit"  name= "btAction" value="Create Account" />     
               </form>

          </div>
     </body>
</html>
