/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DispatchServlet", urlPatterns = "/DispatchServlet")
public class DispatchServlet extends HttpServlet {

     private final String LOGIN_PAGE = "login.jsp";
     private final String LOGIN_CONTROLLER = "LoginServlet";
     private final String SEARCH_CONTROLLER = "SearchServlet";
     private final String DELETE_CONTROLLER = "DeleteServlet";
     private final String UPDATE_CONTROLLER = "UpdateServlet";
     private final String START_CONTROLLER = "StartTimeServlet";
     private final String ADD_ITEM_TO_CART_CONTROLLER = "AddItemToCartServlet";
     private final String VIEW_ITEM_IN_CART_CONTROLLER = "viewcart.jsp";
     private final String REMOVE_ITEMS_FROM_CART_CONTROLLER = "RemoveItemFromCart";
     private final String CREATE_ACCOUNT_CONTROLLER = "CreateAccServlet";
     private final String LOGOUT_CONTROLLER = "LogoutServlet";
     private final String CHECKOUT_CONTROLLER = "CheckoutBookStore";
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
          String url = START_CONTROLLER;
          //1.Which button did user click ?
          String button = request.getParameter("btAction");
          System.out.println("BUTTOONNNNNNNNN: " + button);

          try {
               if (button == null) {//user has just access the web app
                    //default forward to login page
               } else if (button.equals("Login")) {
                    url = LOGIN_CONTROLLER;
               } else if (button.equals("Search")) {
                    url = SEARCH_CONTROLLER;
               } else if (button.equals("Delete")) {
                    url = DELETE_CONTROLLER;
               } else if (button.equals("Update")) {
                    url = UPDATE_CONTROLLER;
               } else if (button.equals("Add Book to Your Cart")) {
                    url = ADD_ITEM_TO_CART_CONTROLLER;
               } else if (button.equals("View Your Cart")) {
                    url = VIEW_ITEM_IN_CART_CONTROLLER;
               } else if (button.equals("Remove Selected Items")) {
                    url = REMOVE_ITEMS_FROM_CART_CONTROLLER;
               } else if (button.equals("Create Account")) {
                    url = CREATE_ACCOUNT_CONTROLLER;
               }else if (button.equals("Logout")) {
                    url = LOGOUT_CONTROLLER;
               }else if (button.equals("Checkout")) {
                    url = CHECKOUT_CONTROLLER;

               }
          } finally {
               System.out.println("The URL: " + url);
               System.out.println("AND URI" + request.getServletPath());
               RequestDispatcher rq = request.getRequestDispatcher(url);
               rq.forward(request, response);
          }
     }

     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          processRequest(request, response);
     }

     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          processRequest(request, response);
     }

     @Override
     public String getServletInfo() {
          return "Short description";
     }// </editor-fold>

}
