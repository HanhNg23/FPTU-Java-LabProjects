/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login.userlogin;

import com.sun.source.doctree.SerialDataTree;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import login.util.DBHelper;
import javax.naming.AuthenticationException;
import javax.naming.NamingException;
import sun.security.util.Password;

/**
 *
 * @author HOANGANH
 */
public class UserloginDAO implements Serializable {

     public UserloginDAO() {
     }

     public UserloginDTO checkLogin(String username, String password) throws SQLException, ClassNotFoundException{ //check thanh cong phai welcome lastname va logout last naame
          Connection con = null; //Set null to backup database shutdown we will close
          PreparedStatement stm = null; // Set null to check 
          ResultSet rs = null; //Thang nao mo cuoi cung thang do close
          UserloginDTO result = null;

          try {
               //1. Setting connection
               con = DBHelper.makeConnection();
               if (con != null) { //check connection is Exists
                    //2. Create SQL String
                    String sql = "SELECT username, lastname, isAdmin"
                                    + " From dbo.userlogin "
                                    + " WHERE username = ? AND password = ?";
                    //3. Create Statement obj to load sql string to the library
                    stm = con.prepareStatement(sql);
                    //4.1 setString for parameters in sql string
                    stm.setString(1, username);
                    stm.setString(2, password);
                    //4. Execute Satetemnet  to get result
                    rs = stm.executeQuery();
                    //5. Process Result
                    if (rs.next()) {
                         String fullname = rs.getString("lastname");
                         String role = rs.getString("isAdmin").trim();
                         System.out.println("ROLE in Check: " + role);
                         boolean isAdmin = false;
                         if(role.equals("true")){
                               isAdmin = true;
                         }
                         result = new UserloginDTO(username,fullname, isAdmin);
                    }
               }
          } finally {
               if (rs != null) {
                    rs.close();
               }
               if (stm != null) {
                    stm.close();
               }
               if (con != null) {
                    con.close();
               }
          }
          return result; //return to the controller where controller call this method
     }

     public void searchLastname(String searchValue) throws SQLException, ClassNotFoundException {
          Connection con = null; //Set null to backup database shutdown we willl closse
          PreparedStatement stm = null; // Set null to check 
          ResultSet rs = null; //Thang nao mo cuoi cung thang do close

          try {
               //1.Connect DB
               con = DBHelper.makeConnection();
               //2.Write SQL String
               if (con != null) {
                    String sql = " SELECT * " 
                                        +"  FROM dbo.userlogin  \n" 
                                        +"  WHERE lastname LIKE ? ";
                    //3. Create Statement obj
                    stm = con.prepareStatement(sql);
                    stm.setString(1, "%" + searchValue + "%");
                    //4. Execute Satetemnet  to get result
                    rs = stm.executeQuery();
                    //5. Process Result
                    while (rs.next()) {
                         String username = rs.getString("username");                         
                         String password = rs.getString("password");
                         String lastname = rs.getString("lastname");
                         boolean isAdmin = rs.getBoolean("isAdmin");                         
                         //add these propeties to obj dto
                         UserloginDTO dto = new UserloginDTO(username, password, lastname, isAdmin);
                         System.out.println("SEE: "+ dto.toString());
                         //check the List<UserloginDTO> obj exist
                         if (this.accountList == null) {
                              this.accountList = new ArrayList<UserloginDTO>();
                         }this.accountList.add(dto);
                         
                    }
               }
          } finally {
               if (rs != null) {
                    rs.close();
               }
               if (stm != null) {
                    stm.close();
               }
               if (con != null) {
                    con.close();
               }
          }
     }

     private List<UserloginDTO> accountList;

     public List<UserloginDTO> getAccountList() {
          return this.accountList;
     }
     
     public boolean deleteRecord(String username) throws SQLException, ClassNotFoundException {
         Connection con = null; //Set null to backup database shutdown we willl closse
         PreparedStatement stm = null; // Set null to check 
         System.out.println("DEEEEEEEEEEEEELETE VALUE: " + username);

         try {
              //1.Connect DB
              con = DBHelper.makeConnection();
              if (con != null) {
                    //2.Write SQL String
                   String sql = " DELETE FROM dbo.userlogin WHERE username = ? ";      
                   //3. Create Statement obj
                   stm = con.prepareStatement(sql);
                   stm.setString(1, username);
                   //4. Execute Satetemnet  to get result
                   int  row = stm.executeUpdate();
                   System.out.println("the number of row be affected ****************************** " + row) ;
                   //5. Process Result
                   if(row > 0) { //there is some row has ben deleted
                	   return true;
                   }
              }
         } finally {

              if (stm != null) {
                   stm.close();
              }
              if (con != null) {
                   con.close();
              }
         }
         return false;
    }
     
      public boolean updateRecord(String username, String password, String isAdmin) throws SQLException, ClassNotFoundException {
         Connection con = null; //Set null to backup database shutdown we willl closse
         PreparedStatement stm = null; // Set null to check 
         System.out.println("UPDATEEEEE VALUE: " + username);

         try {
              //1.Connect DB
              con = DBHelper.makeConnection();
              if (con != null) {
                    //2.Write SQL String
                   String sql = "UPDATE dbo.userlogin\n"
                                    + "SET password = ?, isAdmin = ? \n"
                                    + "WHERE username= ? ";
                   //3. Create Statement obj
                   stm = con.prepareStatement(sql);
                   stm.setString(1, password);   
                   stm.setString(2,isAdmin);
                   stm.setString(3, username);
                   //4. Execute Satetemnet  to get result
                   int  row = stm.executeUpdate();
                   System.out.println("the number of row be affected ****************************** " + row) ;
                   //5. Process Result
                   if(row > 0) { //there is some row has ben deleted
                	   return true;
                   }
              }
         } finally {

              if (stm != null) {
                   stm.close();
              }
              if (con != null) {
                   con.close();
              }
         }
         return false;
    }
         public boolean insertRecord(String username, String password, String lastname, boolean role) throws SQLException, ClassNotFoundException {
         Connection con = null; //Set null to backup database shutdown we willl closse
         PreparedStatement stm = null; // Set null to check 
         System.out.println("INSERT VALUE: " + username);

         try {
              //1.Connect DB
              con = DBHelper.makeConnection();
              if (con != null) {
                    //2.Write SQL String
                   String sql = "INSERT INTO dbo.userlogin(username, password, lastname, isAdmin)\n"
                                    + "VALUES (?,?,?,?) \n";
                   //3. Create Statement obj
                   stm = con.prepareStatement(sql);
                   stm.setString(1, username);   
                   stm.setString(2,password);
                   stm.setString(3, lastname);
                   if(role){
                    stm.setString(4, "true");
                   }else  stm.setString(4, "false");
                   //4. Execute Satetemnet  to get result
                   int  row = stm.executeUpdate();
                   System.out.println("INSERT ROW: " + row);
                   //5. Process Result
                   if(row > 0) { //there is some row has ben deleted
                	   return true;
                   }
              }
         } finally {
              if (stm != null) {
                   stm.close();
              }
              if (con != null) {
                   con.close();
              }
         }
         return false;
    }
     
     
}
