package com.usermanagement.controller;

import com.usermanagement.dao.LoginDao;
import com.usermanagement.model.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author HOANGANH
 */
@WebServlet(name = "loginservlet", urlPatterns = {"/UserLoginServlet"})
public class UserLoginServlet extends HttpServlet {

     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          //Cookie on browser is an array contain browser cookie and other cookie
          //B1: get User and pass from cookie
          
          Cookie arr[] = req.getCookies();
          if(arr != null){
                for (Cookie o : arr) {
               if (o.getName().equals("userC")) {
                    req.setAttribute("username", o.getValue());
               } else if (o.getName().equals("passC")) {
                    req.setAttribute("password", o.getValue());
               }

          }
               
          }
         

          //B2: set User and pass to login form
          req.getRequestDispatcher("loginForm.jsp").forward(req, resp);

     }

     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          //process request
          String username;
          String password;
          String remember;
          try {
               username = req.getParameter("username");
               password = req.getParameter("password");
               remember = req.getParameter("remember");
               //check username and password
               Account acc = new LoginDao().checkAcc(username, password);
               if (acc == null) {
                    req.setAttribute("mess", "Username or password is invalid !");
                    resp.sendRedirect("view\\loginForm.html");     //login again and announce the user that pass or username is invalid               
               } else {//Now this acc has assigned user acc
                    //push this acc to the the storage of session
                    HttpSession session = req.getSession();
                    session.setAttribute("acc", acc);

                    //Save this acc to the cookie to save the login inform
                    Cookie u = new Cookie("userC", username);
                    Cookie p = new Cookie("passC", password);
                    //Set the timeout for the cookie 
                    //if the timeout is set for a long time so that in the next time you access the website you do not have to login a gain and go ahead to your acc on thei website              
                    u.setMaxAge(60);
                    if (remember != null) {
                         p.setMaxAge(60);
                    } else {
                         p.setMaxAge(0);
                    }

                    //add cookie to your browser in use
                    resp.addCookie(u);
                    resp.addCookie(p);

                    resp.sendRedirect("index.jsp");
               }
          } catch (Exception e) {

          }

     }

}
