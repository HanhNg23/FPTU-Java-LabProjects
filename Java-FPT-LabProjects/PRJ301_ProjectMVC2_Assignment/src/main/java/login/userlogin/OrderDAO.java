/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login.userlogin;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import login.util.DBHelper;

/**
 *
 * @author HOANGANH
 */
public class OrderDAO implements  Serializable  {

     public boolean savetoDB(String orderID, String orderDate, String customerName, float sum) throws ClassNotFoundException, SQLException{
             Connection con = null; //Set null to backup database shutdown we willl closse
          PreparedStatement stm = null; // Set null to check 
          boolean rs = false; //Thang nao mo cuoi cung thang do close

          try {
               //1.Connect DB
               con = DBHelper.makeConnection();
               //2.Write SQL String
               if (con != null) {
                    String sql = "INSERT INTO dbo.order(orderID, orderDate, [customer name], total VALUES (?,?,?,?)";
                    //3. Create Statement obj
                    stm = con.prepareStatement(sql);
                    stm.setString(1, orderID);
                     stm.setString(2,  orderDate);
                      stm.setString(3, customerName);
                       stm.setFloat(4, sum);
                      
                    //4. Execute Satetemnet  to get result
                    if(stm.execute()){
                         rs = true;
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
