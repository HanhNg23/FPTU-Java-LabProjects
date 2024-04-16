/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import login.userlogin.UserloginDAO;
import login.userlogin.UserloginDTO;
import login.util.DBHelper;

/**
 *
 * @author HOANGANH
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet") 
public class LoginServlet extends HttpServlet {
     //Always declare url for page;

     private final String INVALID_PAGE = "invalid.html";
     private final String SEARCH_PAGE = "search.jsp";

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
          String url = INVALID_PAGE;
          //We have check btAction is login -> do not need check btAction null ?

          String username = request.getParameter("txtUsername");
          String password = request.getParameter("txtPassword");

          System.out.println("User" + username + "Pass" + password);

          try {
               //1. Call Model/Dao + create New Object Dao
               UserloginDAO dao = new UserloginDAO();
               //2. Call DAO' s method
               UserloginDTO result = dao.checkLogin(username, password); //set checkLogin la object dto
               System.out.println("Result: " + result);
               //3. Send to View 
               if (result != null) {
                    url = SEARCH_PAGE;
                    HttpSession session = request.getSession(); //Each time user login/the first time user login/the cookie has expired -> have to create new session
                    //save the account to the session
                    session.setAttribute("USER", result);
                    
                    //-------------------------------//
                    //save this account to the cookie in client side                               
                    //set cookie
                    Cookie cookie = new Cookie(username, password); //password dang ra phai duoc hashcode 
                    cookie.setMaxAge(60*2);        
                    response.addCookie(cookie);
               }
          } catch (ClassNotFoundException e) {
               e.printStackTrace();
          } catch (SQLException e) {
               e.printStackTrace();
          } finally {
               RequestDispatcher rq = request.getRequestDispatcher(url);
               rq.forward(request, response);
               out.close();
          }

     }

     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          this.processRequest(request, response);

     }

     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          this.processRequest(request, response);

     }

}
