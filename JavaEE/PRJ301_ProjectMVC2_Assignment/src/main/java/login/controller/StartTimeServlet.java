/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.lang.model.element.ModuleElement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import login.userlogin.UserloginDAO;
import login.userlogin.UserloginDTO;
import sun.awt.image.ImageWatched.Link;

/**
 *
 * @author HOANGANH Use this servlet to check whether the user account cookie is
 * still exists not expired
 */
@WebServlet(name = "StartTimeServlet", urlPatterns = {"/StartTimeServlet"})
public class StartTimeServlet extends HttpServlet {

     private final String LOGIN_PAGE = "login.jsp";

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException, SQLException, ClassNotFoundException {
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
          String url = LOGIN_PAGE;
          Cookie[] cookies = null;
          try {
               //1. Get all Cookies
               cookies = request.getCookies();
               if (cookies != null) {
                    //2. Get the cookie contain user account
                    System.out.println("The numbers of Cookies: " + cookies.length);
                    //lastcookie is not sure the cookie we want so we have check each cookie
                    /*    Cookie lastCookie = cookies[cookies.length - 1]; 
                    String username = lastCookie.getName();
                    String password = lastCookie.getValue(); 
                   System.out.println("lastCookie obj: " + lastCookie + " username " + lastCookie.getName() + " password " + lastCookie.getValue()); */
                    //3.Call Model
                    UserloginDAO dao = new UserloginDAO();
                         for (Cookie cookie : cookies) {
                         String username = cookie.getName();
                         String password = cookie.getValue();
                        UserloginDTO result = dao.checkLogin(username, password);
                         if (result != null) {
                              //result true -> search page
                              //4.call Login features by using urlRewriting
                              url = "DispatchServlet"
                                      + "?btAction=Login"
                                      + "&txtUsername=" + username
                                      + "&txtPassword=" + password; //automatic go to search page

                         }
                    } 
//                    //check cookie has the cookie name "acc"
//                    for (Cookie cookie : cookies) {
//                         if (cookie.getName().equals("user")) {                              
//                              String accvalue = cookie.getValue(); //get cookie value from key accs                              
//                              System.out.println("The acc cookie:   " + accvalue);
//                              //the accvalue contain the address of the user acc in memory but type String ==> we have to convert back to the UserloginDTO
//                              ObjectMapper objectMapper = new ObjectMapper();
//                              UserloginDTO useracc = objectMapper.readValue(accvalue, UserloginDTO.class);
//                              //get username, password and transport to LoginServlet for Check account
//                              String username = useracc.getUsername();
//                              String password = useracc.getPassword();
//                              System.out.println("THE COOKIE ACC: " + " username: " + username + " password: " + password );
//                              // transport to LoginServlet by urlRewritting
//                              url = "DispatchServlet?btAction=Login"
//                                      + "&txtUsername=" + username
//                                      + "txtPassword" + password;
//                         }else if(cookie.getName().equals("pass")){
//                              
//                         }
//                    }
               }

          } finally {
               response.sendRedirect(url); //dung forward la duoc
               out.close();

          }
     }

     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          try {
               processRequest(request, response);
          } catch (SQLException ex) {
               Logger.getLogger(StartTimeServlet.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
               Logger.getLogger(StartTimeServlet.class.getName()).log(Level.SEVERE, null, ex);
          }
     }

     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          try {
               processRequest(request, response);
          } catch (SQLException ex) {
               Logger.getLogger(StartTimeServlet.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
               Logger.getLogger(StartTimeServlet.class.getName()).log(Level.SEVERE, null, ex);
          }
     }

     @Override
     public String getServletInfo() {
          return "Short description";
     }// </editor-fold>

}
