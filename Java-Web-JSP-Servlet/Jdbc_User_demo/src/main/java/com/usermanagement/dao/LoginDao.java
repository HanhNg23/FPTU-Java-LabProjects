package com.usermanagement.dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author HOANGANH
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.usermanagement.model.Account;

public class LoginDao {

     Connection connect = null;
     PreparedStatement ps = null;
     ResultSet rs = null;
     private static final String USER_LOGIN = "SELECT * FROM demo.userlogin WHERE username= ? AND password = ?";

     public Account checkAcc(String username, String password) {
          try {
               connect = new DB_Context().getDBConnection();
               ps = connect.prepareStatement(USER_LOGIN);
               ps.setString(1, username);
               ps.setString(2, password);
               rs = ps.executeQuery();
               while (rs.next()) {
                    Account acc = new Account(rs.getString(1), rs.getString(2)); //column 1: username, column 2: password
                    return acc;
               }
          } catch (Exception e) {
          }
          return null;
     }
}
