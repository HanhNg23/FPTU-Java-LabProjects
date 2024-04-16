/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package login.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AddItemToCartServlet", urlPatterns = {"/AddItemToCartServlet"})
public class AddItemToCartServlet extends HttpServlet {
     private final String SHOPPING_PAGE = "shopping.html";


     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
          String url = SHOPPING_PAGE;
          PrintWriter out = response.getWriter();
          try {
               //1. Customer goes to cart place that is session
               //Session contain the cart for customer
               HttpSession session = request.getSession(); 
               //get true vi sieu thi  mac dinh la phai  cung cap noi lay gio cho customer chua co session thi server/sieuthi tu build
               //2. Customer takes his/her cart in the session
               CartObj cart = (CartObj) session.getAttribute("CART");
               if(cart == null){
                    cart = new CartObj();
               }//end cart has not exist
               //3. Customer drops item to cart
               String item = request.getParameter("choBook");
               //Do not check item is empty because choBook are checkbox
               cart.addItemToCart(item, 1);
               //update scope
               session.setAttribute("CART", cart);

          } finally {
               response.sendRedirect(url);
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
