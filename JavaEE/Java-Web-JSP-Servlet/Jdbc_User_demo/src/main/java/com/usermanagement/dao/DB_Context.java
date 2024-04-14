/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usermanagement.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author HOANGANH
 */
public class DB_Context {

     // Database inform login
     private String url = "jdbc:mysql://localhost:3306/demo";
     private String uname = "root";
     private String password = "hanh3533.";

     public Connection getDBConnection() {
          Connection connect = null;
          try {
               Class.forName("com.mysql.jdbc.Driver");
               System.out.println("FOUND !!!!");
               connect = DriverManager.getConnection(url, uname, password);
               System.out.println("Connected! " + connect);
               return connect;
          } catch (ClassNotFoundException | SQLException e) {
          }
          return connect;
     }

}
