/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import login.userlogin.UserloginDAO;
import login.userlogin.UserloginDTO;

/**
 *
 * @author HOANGANH
 */
@WebServlet(name = "SearchServlet", urlPatterns = "/SearchServlet")
public class SearchServlet extends HttpServlet {

     private final String RESULT_PAGE = "search.jsp";

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException, ClassNotFoundException, SQLException{
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
          String url = RESULT_PAGE;
          
          try {
                   String searchValue = request.getParameter("txtSearchValue");
               if (!searchValue.trim().isEmpty()) {
                    System.out.println("THE SEARCH VALUE    " + searchValue);
                    //1. Call DAO and Create obj DAO
                    UserloginDAO dao = new UserloginDAO();
                    //2. Call funtion of dao      
                    dao.searchLastname(searchValue.trim());
                    //Save data rows in DTO List if             
                    List<UserloginDTO> result = dao.getAccountList();
                    System.out.println("The size: " + result.size());
                   for( UserloginDTO re : result){
                        System.out.println("username: " + re.getUsername());
                        System.out.println("pass: " + re.getPassword());
                        System.out.println("lastname: " + re.getFullName());
                        System.out.println("isAdimin: " + re.isRole());
                   }                
                     request.setAttribute("SEARCH_RESULT", result);    
               } 
          } finally {
               RequestDispatcher rd = request.getRequestDispatcher(url);
               rd.forward(request, response);
               out.close();
          }
     }

     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException{
              try {
				processRequest(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //muon vo duoc trang search phai login moi duoc
       
     }

     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          try {
			processRequest(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }


}
