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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import login.util.DBHelper;

/**
 *
 * @author HOANGANH
 */
public class ProductsDAO implements Serializable {

     public ProductsDAO() {
     }

     public void showBookOnSale() throws SQLException, ClassNotFoundException {
          Connection con = null; //Set null to backup database shutdown we willl closse
          PreparedStatement stm = null; // Set null to check 
          ResultSet rs = null; //Thang nao mo cuoi cung thang do close

          try {
               //1.Connect DB
               con = DBHelper.makeConnection();
               //2.Write SQL String
               if (con != null) {
                    String sql = "SELECT * FROM products  ";
                    //3. Create Statement obj
                    stm = con.prepareStatement(sql);
                    //4. Execute Satetemnet  to get result
                    rs = stm.executeQuery();
                    //5. Process Result
                    while (rs.next()) {
                         String sku = rs.getString("sku");
                         String name = rs.getString("name");
                         int quanity = rs.getInt("quantiy");
                         float price = rs.getFloat("price");
                         boolean status = rs.getBoolean("status");
                         String imglink = rs.getString("imglink");
                         ProductsDTO dto = new ProductsDTO(sku, name, quanity, price, status, imglink);
                         //check the List<UserloginDTO> obj exist
                         if (this.itemsOnSaleList == null) { //if list does not exists
                              this.itemsOnSaleList = new ArrayList<ProductsDTO>();
                         }
                         this.itemsOnSaleList.add(dto);

//                         }
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

     private List<ProductsDTO> itemsOnSaleList;

     public List<ProductsDTO> getItemsOnSaleList() {
          return this.itemsOnSaleList;
     }
     private List<ProductsDTO> viewBookCart;

     public List<ProductsDTO> getViewBookCart() {
          return viewBookCart;
     }

     public void viewBookCart(Map<String, Integer> items) throws SQLException, ClassNotFoundException {
          Connection con = null; //Set null to backup database shutdown we willl closse
          PreparedStatement stm = null; // Set null to check 
          ResultSet rs = null; //Thang nao mo cuoi cung thang do close

          try {
               //1.Connect DB
               con = DBHelper.makeConnection();
               //2.Write SQL String
               if (con != null) {
                    String sql = "SELECT * FROM products WHERE sku = ? ";
                    //3. Create Statement obj
                    stm = con.prepareStatement(sql);
                    //4. Execute Satetemnet  to get result
                    for (Map.Entry<String, Integer> item : items.entrySet()) {
                         stm.setString(1, item.getKey());
                         rs = stm.executeQuery();
                         if (rs.next()) {
                              String sku = rs.getString("sku");
                              String name = rs.getString("name");
                              float price = rs.getFloat("price");
                              int quanityStock = rs.getInt("quantiy");
                              String imglink = rs.getString("imglink");
                              ProductsDTO dto = new ProductsDTO(sku, name, price, item.getValue(), quanityStock, imglink);
                              //check the List<UserloginDTO> obj exist
                              if (this.viewBookCart == null) { //if list does not exists
                                   this.viewBookCart = new ArrayList<ProductsDTO>();
                              }
                              this.viewBookCart.add(dto);
                         }
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

}
