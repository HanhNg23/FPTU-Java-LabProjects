package com.userlogin.dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author HOANGANH
 */
import com.userlogin.model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {

     Connection connect = null;
     PreparedStatement ps = null;
     ResultSet rs = null;
     private static final String USER_SEARCH = "SELECT * FROM demo.userlogin WHERE username= ? AND password = ?";
     private static final String USERNAME_SEARCH = "SELECT * FROM demo.userlogin WHERE username= ? ";
     private static final String USER_CREATE_NEW = "INSERT INTO demo.userlogin(username, password) VALUES(?, ?)";

     public Account checkAcc(String username, String password) {
          try {
               connect = new DB_Context().getDBConnection();
               if (connect == null) {
                    System.out.println("connect database unsuccesfully");
               }
               ps = connect.prepareStatement(USER_SEARCH);
               ps.setString(1, username);
               ps.setString(2, password);
               rs = ps.executeQuery();
               while (rs.next()) {
                    Account acc = new Account(rs.getString(1), rs.getString(2)); //column 1: username, column 2: password
                    System.out.println("acc: " + acc.getUsername() + " pass: " + acc.getPassword());
                    return acc;
               }
          } catch (Exception e) {
          }
          return null;
     }

     public Boolean isExisted(String username) {
          try {
               connect = new DB_Context().getDBConnection();
               if (connect == null) {
                    System.out.println("connect database unsuccesfully");
               }
               ps = connect.prepareStatement(USERNAME_SEARCH);
               ps.setString(1, username);
               rs = ps.executeQuery();
               while (rs.next()) { //this username has existed
                    System.out.println("Duplicate with other user");
                    return true;
               }
          } catch (Exception e) {
          }
          return false;
     }

     public void createAcc(String username, String password) {
          try {
               connect = new DB_Context().getDBConnection();
               if (connect == null) {
                    System.out.println("connect database unsuccesfully");
               }
               ps = connect.prepareStatement(USER_CREATE_NEW);
               ps.setString(1, username);
               ps.setString(2, password);
               ps.execute();
               System.out.println("One acc is added successfully");
          } catch (Exception e) {
               e.printStackTrace();
          }
     }

}
