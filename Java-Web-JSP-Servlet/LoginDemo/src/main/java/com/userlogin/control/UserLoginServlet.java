package com.userlogin.control;

import com.userlogin.dao.LoginDao;
import com.userlogin.model.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "loginservlet", urlPatterns = {"/UserLoginServlet"})
public class UserLoginServlet extends HttpServlet {

     private final String LOGIN_PAGE = "loginForm.jsp";
     private final String INDEX_PAGE = "index.jsp";

     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          //Cookie on browser is an array contain browser cookie and other cookie
          //B1: get User and pass from cookie if has
          Cookie arr[] = req.getCookies();
          if (arr != null) {
               for (Cookie o : arr) {
                    if (o.getName().equals("userC")) {
                         req.setAttribute("username", o.getValue());
                    } else if (o.getName().equals("passC")) {
                         req.setAttribute("password", o.getValue());

                    }
               }
          }

          //B2: set User and pass to loginForm.jsp
          req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);

     }

     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          //process request
          String button = req.getParameter("btAction");
          try {
               if (button.equals("Login")) {
                    String username = req.getParameter("username");
                    String password = req.getParameter("password");
                    String remember = req.getParameter("remember");
                    System.out.println("user: " + username + " pass: " + password + " remember: " + remember);

                    if (username.isBlank() || password.isBlank()) {
                         req.setAttribute("mess", " Enter your username and password !");
                         req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);  //login again and announce the user that pass or username is invalid               
                    } else {
                         //call model/dao and create Account obj
                         LoginDao dao = new LoginDao();
                         //check username and password is correct ?
                         Account acc = dao.checkAcc(username, password);
                         if (acc == null) {
                              req.setAttribute("mess", "Username or password is invalid !");
                              req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);  //login again and announce the user that pass or username is invalid        
                         } else {
                              //Now this acc has assigned user acc
                              //push this acc to the the storage of session
                              //HttpSession session = req.getSession();
                              //session.setAttribute("acc", acc);

                              //Save this acc to the cookie to save the login inform
                              Cookie u = new Cookie("userC", username);
                              Cookie p = new Cookie("passC", password);
                              //Set the timeout for the cookie 
                              //if the timeout is set for a long time so that in the next time you access the website you do not have to login a gain and go ahead to your acc on thei website              
                            
                              if (remember != null) {
                                   u.setMaxAge(60);
                                   p.setMaxAge(60);
                              } else {
                                  u.setMaxAge(0);
                                   p.setMaxAge(0);
                              }

                              //add cookie to your browser in use
                              resp.addCookie(u);
                              resp.addCookie(p);

                              resp.sendRedirect(INDEX_PAGE);
                         }
                    }
               }
          } catch (Exception e) {

          }
     }

}
