/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

 /*Class for Log In interface -- giao dien login*/
package mng;

import data.Account;
import data.AccountChecker;
import data.Config;
import data.DealerList;
import tools.MyTool;

public class LogIn {

    private Account acc = null;
    public static String permissonRole = "ACC-1";

    public LogIn(Account acc) {
        this.acc = acc;
    }
    public LogIn() {
    }

    public Account inputAccount() {
    	System.out.println();
        String accName = MyTool.readNonBlank("Your account's name: ");
        String pwd = MyTool.readNonBlank("Password: ");
        String role = MyTool.readNonBlank("Your role: ");
        Account acc = new Account(accName, pwd, role);
        return acc;
    }

    public Account getAcc() {
        return this.acc;
    }
    
    public LogIn RequireLogin() {
    	 Account acc = null;//account will login to system
         boolean cont; //check to login again
         boolean valid;//valid account or not
         //log in
         System.out.println("===============================");
         System.out.println("==== Please Login To System ===");
         System.out.println("===============================");
         
         do {
             AccountChecker accChk = new AccountChecker();
             acc = inputAccount();
             valid = accChk.check(acc);
             cont = false;
             if (!valid) //if above valid is false => !valid = true => execute
             {
                 cont = MyTool.readBool("This account does not exist - Try again ?");
             }
             if (!valid && !cont) { //valid == false, cont = false -> !valid = true && !cont = true => true => execute 
                 System.exit(0); // quit the program
             }
         } while (cont);

         LogIn loginObj = new LogIn(acc);
         return loginObj;
    }
}
