package login.controller;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.userlogin.UserloginDAO;
import login.util.DBHelper;

@WebServlet(name = "DeleteServlet", urlPatterns = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
     private final String deleteErrPage = "deleteErr.html";
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException, ClassNotFoundException{

          PrintWriter out = response.getWriter();
          String url = deleteErrPage;
          try {
               String username = request.getParameter("pk");
               String searchValue = request.getParameter("lastSearchValue");
               String urlRewriting =  "DispatchServlet" + "?btAction=Search" + "&txtSearchValue=" + searchValue;
               System.out.println("username: **********" + username + "searchValue:*************** " + searchValue);
               // 1. Call Model/Dao and Create Obj
               UserloginDAO dao = new UserloginDAO();
               // 2. Call function of Dao
               boolean result = dao.deleteRecord(username);
               if(result){
                    url = urlRewriting;
               }
          }catch (SQLException e){
               log("DeleteServlet_SQL" + e.getMessage());
          }finally {
               response.sendRedirect(url);
               out.close();
          }

     }

     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          try {
               this.processRequest(request, response);
          } catch (ClassNotFoundException e) {
               e.printStackTrace();
          } catch (ServletException e) {
               e.printStackTrace();
          } catch (IOException e) {
               e.printStackTrace();
          }
     }

     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          try {
               this.processRequest(request, response);
          } catch (ClassNotFoundException e) {
               e.printStackTrace();
          } catch (ServletException e) {
               e.printStackTrace();
          } catch (IOException e) {
               e.printStackTrace();
          }
     }

}
