package com.userlogin.control;

import com.userlogin.dao.LoginDao;
import com.userlogin.model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Signup", urlPatterns = {"/UserSignupServlet"})
public class UserSignupServlet extends HttpServlet {

     private final String LOGIN_PAGE = "loginForm.jsp";
     private final String SIGNUP_PAGE = "signupForm.jsp";

     protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

          String url = SIGNUP_PAGE;
          String button = request.getParameter("btAction");
          PrintWriter out = response.getWriter();
          //1. check button = "Create"
          //2. get username and password
          //3. call model/dao
          //4. check if user or pass is empty String , username has existed in DB
          //5. create obj dao
          //6. create new Accout obj
          //7. Send to view via the url of view
          try {
               if (button.equals("Create")) {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    LoginDao dao = new LoginDao();
                    if (username.isBlank() || password.isBlank()) {
                         request.setAttribute("mess", "Enter your username and password !");
                    } else if (dao.isExisted(username)) {
                         request.setAttribute("mess", "This username has existed !");
                    } else {
                         Account acc = new Account(username, password);
                         dao.createAcc(acc.getUsername(), acc.getPassword());
                         System.out.println("new user: " + username + "password: " + password);
                         request.setAttribute("mess", "Create Successfully");
                         request.getRequestDispatcher(url).forward(request, response);
                    }
               }
          } finally {
               request.getRequestDispatcher(url).forward(request, response);
               out.close();
          }

     }

     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp)
             throws ServletException, IOException {
          resp.sendRedirect("signupForm.jsp");
     }

     protected void doPost(HttpServletRequest req, HttpServletResponse resp)
             throws ServletException, IOException {
          this.processRequest(req, resp);
     }

}
