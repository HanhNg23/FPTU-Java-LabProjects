package login.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import login.userlogin.UserLoginError;
import login.userlogin.UserloginDAO;

/**
 *
 * @author HOANGANH
 */
@WebServlet(urlPatterns = {"/CreateAccServlet"})
public class CreateAccServlet extends HttpServlet {

     private final String INSERT_ERROR_PAGE = "createAcc.jsp";
     private final String LOGIN_PAGE = "login.jsp";

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException, ClassNotFoundException {
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
          System.out.println("HAVE GO TO CREATE ACC SERVLET ");

          //get username, password, confirm password, fullname
          String username = request.getParameter("txtUsername");
          String password = request.getParameter("txtPassword");
          String confirm = request.getParameter("txtConfirm");
          String fullname = request.getParameter("txtFullname");

          String url = INSERT_ERROR_PAGE;
          UserLoginError error = new UserLoginError();
          boolean bErr = false;
          try {
               //check err if have
               //1 Check username: unique, no space, length enough
               if (username.trim().length() < 6 || username.trim().length() > 20) {
                    bErr = true;
                    error.setUsernameLengthOrExistsErr("User length requires 6-20 characters");
                    System.out.println(error.getUsernameLengthOrExistsErr());
               }
               if (password.trim().length() < 5 || password.trim().length() > 20) {
                    bErr = true;
                    error.setPasswordLengthErr("Password length requires 6-20 characters");
                    System.out.println(error.getPasswordLengthErr());
               } else if (!confirm.trim().equals(password)) {
                    bErr = true;
                    error.setConfirmErr("Cofirm must match to the password");
                    System.out.println(error.getConfirmErr());
               } 
               if (fullname.trim().length() < 2 || fullname.trim().length() > 50) {
                    bErr = true;
                    error.setFullnameLengthErr("Fullname length requires 2-50 characters");
                    System.out.println(error.getFullnameLengthErr());
               } 

               if (bErr) {
                    request.setAttribute("insertErr", error);
               } else {
                    UserloginDAO dao = new UserloginDAO();
                    boolean result = dao.insertRecord(username, password, fullname, false);
                    if (result) {
                         url = LOGIN_PAGE;
                    }
               }

               //call model/dao and save to DB
               //save success turn back to login page
          } catch (SQLException ex) {
               log("CreateAccountServlet _ SQL " + ex.getMessage());
               if (ex.getMessage().contains("duplicate")){
                   error.setUsernameLengthOrExistsErr(username + " has exists !!");                
               }
               request.setAttribute("insertErr", error);
          } finally {
               RequestDispatcher rq = request.getRequestDispatcher(url);
               rq.forward(request, response);
               out.close();
          }
     }

     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          try {
               processRequest(request, response);
          } catch (ClassNotFoundException ex) {
               Logger.getLogger(CreateAccServlet.class.getName()).log(Level.SEVERE, null, ex);
          }
     }

     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          try {
               processRequest(request, response);
          } catch (ClassNotFoundException ex) {
               Logger.getLogger(CreateAccServlet.class.getName()).log(Level.SEVERE, null, ex);
          }
     }

     @Override
     public String getServletInfo() {
          return "Short description";
     }// </editor-fold>

}
