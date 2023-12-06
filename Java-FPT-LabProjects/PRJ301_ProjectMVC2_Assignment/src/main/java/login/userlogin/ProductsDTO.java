/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login.userlogin;

import java.io.Serializable;

/**
 *
 * @author HOANGANH
 */
public class ProductsDTO implements Serializable {

     private String sku;
     private String name;
     private int quantityStock;
     private int quantityBuy;
     private float price;
     private boolean status;
     private String imglink;

     public ProductsDTO() {
     }

     public ProductsDTO(String sku, String name, int quantity, float price, boolean status, String imglink) {
          this.sku = sku;
          this.name = name;
          this.quantityStock = quantity;
          this.price = price;
          this.status = status;
          this.imglink = imglink;
     }

     public ProductsDTO(String sku, String name, float price, int quantityBuy, int quantityStock, String imglink) {
          this.sku = sku;
          this.name = name;
          this.price = price;
          this.imglink = imglink;
          this.quantityStock = quantityStock;
          this.quantityBuy = quantityBuy;
     }

     public String getSku() {
          return sku;
     }

     public void setSku(String sku) {
          this.sku = sku;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public int getQuantityStock() {
          return quantityStock;
     }

     public void setQuantityStock(int quantityStock) {
          this.quantityStock = quantityStock;
     }

     public int getQuantityBuy() {
          return quantityBuy;
     }

     public void setQuantityBuy(int quantityBuy) {
          this.quantityBuy = quantityBuy;
     }

     public float getPrice() {
          return price;
     }

     public void setPrice(float price) {
          this.price = price;
     }

     public boolean isStatus() {
          return status;
     }

     public void setStatus(boolean status) {
          this.status = status;
     }

     public String getImglink() {
          return imglink;
     }

     public void setImglink(String imglink) {
          this.imglink = imglink;
     }

}
