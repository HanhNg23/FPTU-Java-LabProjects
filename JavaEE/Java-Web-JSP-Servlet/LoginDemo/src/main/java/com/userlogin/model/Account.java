/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.userlogin.model;

/**
 *
 * @author HOANGANH
 */
public class Account {
     private String username ;
     private String password;

     public Account() {
     }
     public Account(String uname, String pass){
          this.username = uname;
          this.password = pass;
     }

     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }
     
     
     
}

