/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author HOANGANH
 */
public class DBHelper implements Serializable {

     public static Connection makeConnection() throws ClassNotFoundException, SQLException{

//          //1: find Context
//          Context context = new InitialContext();
//          //2.find tomcat context
//          Context tomcatContext = (Context) context.lookup("java:comp/env");
//          //3 find data source
//          DataSource ds = (DataSource) tomcatContext.lookup("HADataSrc");
//          //4 Open connection
//          Connection con = ds.getConnection();
//          if(con != null){
//               System.out.println("CONNECT SUCCESSFULLY");
//          }
//          return con;

          //TRADITIONAL
          //1. Load Driver 
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          //2. Create connection String

//          String url
//                  = "jdbc:sqlserver://localhost:1433;"
//                  + "databaseName=master;"
//                  + "encrypt=true;trustServerCertificate=true";
          String url = "jdbc:sqlserver://localhost:1433;databaseName=master;encrypt=true;trustServerCertificate=true;";

          //3. Open Connection
          Connection con = DriverManager.getConnection(url, "sa", "hanh3533.");
           System.out.println("CONNNNNNN: " + con);
          return con;
     }

}
