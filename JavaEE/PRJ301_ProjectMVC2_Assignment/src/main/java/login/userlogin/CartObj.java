/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login.userlogin;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HOANGANH
 */
public class CartObj implements Serializable {

     private Map<String, Integer> items; //ngan chua do each item contain only one the item

     public Map<String, Integer> getItems() {
          return items;
     }

     public boolean addItemToCart(String id, int quatity) {
          boolean result = false;
          //1. Check data is valid
          if (id == null) {
               return result;
          }
          if (id.trim().isEmpty()) {
               return result;
          }
          if (quatity <= 0) {
               return result;
          }
          //2. check existed items 
          if (this.items == null) {
               this.items = new HashMap<String, Integer>();
          }
          //3. Drop item to items
          if (this.items.containsKey(id)) {
               int addNumQuan = items.get(id);
               quatity = quatity + addNumQuan;

          }//end item has existed
          //4. update items
          items.put(id, quatity);
          result = true;

          return result;
     }

     public boolean updateItemQuantity(String id, int quatity) {
          boolean result = false;
          //1. Check data is valid
          if (id == null) {
               return result;
          }
          if (id.trim().isEmpty()) {
               return result;
          }
          if (quatity <= 0) {
               return result;
          }
          //2. check existed items 
          if (this.items == null) {
               this.items = new HashMap<String, Integer>();
          }
          //4. update items
          items.put(id, quatity);
          result = true;

          return result;
     }

     public boolean removeItemFromCart(String id, int delquatity) {
          boolean result = false;
          //1. Check data is valid
          if (id == null) {
               return result;
          }
          if (id.trim().isEmpty()) {
               return result;
          }
          if (delquatity <= 0) {
               return result;
          }
          //2. check existed items
          if (this.items == null) {
               return result;
          }
          //3. check existed item 
          if (this.items.containsKey(id)) {
               //4. compare quantity
               int availableQuan = this.items.get(id);

               if (availableQuan < delquatity) {
                    return result;
               }//the first quantity is smaller than remove quantity
               //true
               int newquan = availableQuan - delquatity;
               if (newquan == 0) {
                    this.items.remove(id);
                    if (this.items.isEmpty()) {
                         this.items = null;
                    }//empty cart when items has not existed}
               } else {
                    this.items.put(id, newquan);//update cart items
               }
               result = true;

          }
          return result;
     }

     public boolean removeOutOfCart(String id) {
          boolean result = false;
          //1. Check data is valid
          if (id == null) {
               return result;
          }
          if (id.trim().isEmpty()) {
               return result;
          }
          //2. check existed items
          if (this.items == null) {
               return result;
          }
          //3. check existed item 
          if (this.items.containsKey(id)) {
               //remove Item
               this.items.remove(id);
               if (this.items.isEmpty()) {
                    this.items = null;
               }//empty cart when items has not existed}
               result = true;
          }
          return result;
     }

}
