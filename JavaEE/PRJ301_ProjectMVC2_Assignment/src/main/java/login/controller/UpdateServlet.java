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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import login.userlogin.UserloginDAO;

/**
 *
 * @author HOANGANH
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {
        private final String updateErrPage = "updateErr.html";
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException, SQLException, ClassNotFoundException {
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
          String url = updateErrPage;
          
          try {
            //set up urlRewriting
            String searchValue = request.getParameter("lastSearchValue");
            String urlRewriting =  "DispatchServlet" + "?btAction=Search" + "&txtSearchValue=" + searchValue;
            //get parameter username, password, isAdmin
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String chkAdmin = request.getParameter("chkAdmin");            
            //check isAdmin = null
            String isAdmin = "false";
            if(chkAdmin != null){
                isAdmin = "true";
            }
            //Call Dao
            UserloginDAO dao = new UserloginDAO();
            //Call function Dao
            System.out.println("UPDATE " + " USER: " + username + " PASS: " + password + " CHKADMIN: " + isAdmin);
            boolean result = dao.updateRecord(username, password, isAdmin);
            
            //check result is true
            if(result){
                 url = urlRewriting;
            }
            //true -> turn back to searchjsp using urlRewriting with txtSearchvalue 
            //false errPage
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
             try {
                  processRequest(request, response);
             } catch (SQLException ex) {
                  Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ClassNotFoundException ex) {
                  Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
             }
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
             try {
                  processRequest(request, response);
             } catch (SQLException ex) {
                  Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ClassNotFoundException ex) {
                  Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
             }
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
