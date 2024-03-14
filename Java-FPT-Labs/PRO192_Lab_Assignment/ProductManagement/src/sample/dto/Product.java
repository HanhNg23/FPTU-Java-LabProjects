package sample.dto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class Product implements Comparable<Object>{ //implement de override compareto

     private String code="", name="" ;
     private int size=0 , price=0 ;
     
     
    // change properties to private.
    // create getter, setter, 
    // Create constructor have parameters( need remove init value of properties
     // override toString

    public Product(String code, String name, int size, int price) {
        this.code = code;
        this.name = name;
        this.size = size;
        this.price = price;
        
        
    }
     
    public Product(String code){
        this.code = code;
    }
    
    public Product(){
        
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product[" + "code=" + code + ", name=" + name + ", size=" + size + ", price=" + price + ']' + "\n";
    }

    @Override
    public boolean equals(Object obj) { // thong qua id
        Product p = (Product) obj;
        return this.code.equals(p.getCode()); 
    }
    
    @Override
    public int compareTo(Object obj){ //muc dich sap xep name
        Product p = (Product) obj;
        //return this.name.compareToIgnoreCase(p.getName());
        return p.name.compareToIgnoreCase(this.getName());
    }
}
