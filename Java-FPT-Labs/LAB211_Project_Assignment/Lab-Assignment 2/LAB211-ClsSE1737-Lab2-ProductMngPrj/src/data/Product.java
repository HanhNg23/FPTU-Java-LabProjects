/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.Comparator;

/**
 *
 * @author HOANGANH
 */
public class Product implements Comparator<Product>{

    public static final char SEPARATOR = ',';
    public static final String ID_FORMAT = "[D|d]\\d{3}";
    private String productID;
    private String productName;
    private float unitprice;
    private int quantity;
    private String status;

    public Product(String productID, String productName, float unitprice, int quantity, String status) {
        this.productID = productID;
        this.productName = productName;
        this.unitprice = unitprice;
        this.quantity = quantity;
        this.status = status;

    }

    public Product(String line) {
        String parts[] = line.split(SEPARATOR + "");
        for (int i = 0; i < parts.length; ++i) {
            this.productID = parts[0].trim();
            this.productName = parts[1].trim();
            this.unitprice = Float.parseFloat(parts[2].trim());
            this.quantity = Integer.parseInt(parts[3].trim());
            this.status = parts[4].trim();          
        }

    }

    public Product() {
    }
    

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(float unitprice) {
        this.unitprice = unitprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAll(Product product) {
        this.setProductName(product.getProductName());
        this.setUnitprice(product.getUnitprice());
        this.setQuantity(product.getQuantity());
        this.setStatus(product.getStatus());
    }

    @Override
    public String toString() {
        return productID + SEPARATOR + productName + SEPARATOR + unitprice + SEPARATOR + quantity + SEPARATOR + status + "\n";
        
    }


    @Override
    public int compare(Product o1, Product o2) {
        return o1.productID.compareTo(o2.productID);
    }
}
