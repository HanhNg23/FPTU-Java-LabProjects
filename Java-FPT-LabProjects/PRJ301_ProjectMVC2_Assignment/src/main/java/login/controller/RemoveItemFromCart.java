/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import login.userlogin.CartObj;

/**
 *
 * @author HOANGANH
 */
@WebServlet(name = "RemoveItemFromCart", urlPatterns = {"/RemoveItemFromCart"})
public class RemoveItemFromCart extends HttpServlet {
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
          String urlRewriting =  "DispatchServlet" + "?btAction=View Your Cart";
          System.out.println("HELLO REMOVE HERE");

          try {
               //we have set the cart into the session so we do not need to create new session obj but we have to check
               HttpSession session = request.getSession(false); //vi session time out o phia server se mat ma du session do van hien voi nguoi dung
               //the place contain cart  exists ?
                System.out.println("SESSION IS NULL: " + session);
               if (session != null) {
                    //get cart
                    CartObj cart = (CartObj) session.getAttribute("CART");
                    //check cart exists in session
                    System.out.println("CART IS NULL: " + cart);
                    if (cart != null) {
                         //get item from cart
                         Map<String, Integer> items = cart.getItems();
                       System.out.println("ITEMS IS NULL: " + items);
                         if (items != null) {
                              String[] selectedItems = request.getParameterValues("chkItem");
                              System.out.println("SELECTEDITEM IS NULL: " + items);
                              if (selectedItems != null) {
                                   for (String item : selectedItems) {
                                        System.out.println("item : " + item);
                                        cart.removeItemFromCart(item, 1); //remove each one
                                         System.out.println("item quantity now : " + items.get(item));
                                   }
                                   session.setAttribute("CART", cart);
                              }
                         }

                    }
               }

          } finally {
               response.sendRedirect(urlRewriting); //cart is already saved in Implicit obj session
               out.close();
          }
     }

     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
     /**
      * Handles the HTTP <code>GET</code> method.
      *
      * @param request servlet request
      * @param response servlet response
      * @throws ServletException if a servlet-specific error occurs
      * @throws IOException if an I/O error occurs
      */
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          processRequest(request, response);
     }

     /**
      * Handles the HTTP <code>POST</code> method.
      *
      * @param request servlet request
      * @param response servlet response
      * @throws ServletException if a servlet-specific error occurs
      * @throws IOException if an I/O error occurs
      */
     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          processRequest(request, response);
     }

     /**
      * Returns a short description of the servlet.
      *
      * @return a String containing servlet description
      */
     @Override
     public String getServletInfo() {
          return "Short description";
     }// </editor-fold>

}
