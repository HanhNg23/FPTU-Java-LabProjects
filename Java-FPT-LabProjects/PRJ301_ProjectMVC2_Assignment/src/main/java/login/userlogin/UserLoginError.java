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
public class UserLoginError implements Serializable{
     private String usernameLengthOrExistsErr;
     private String passwordLengthErr;
     private String confirmErr;
     private String fullnameLengthErr;

     public UserLoginError() {
     }

     public String getUsernameLengthOrExistsErr() {
          return usernameLengthOrExistsErr;
     }

     public void setUsernameLengthOrExistsErr(String usernameLengthOrExistsErr) {
          this.usernameLengthOrExistsErr = usernameLengthOrExistsErr;
     }
     

     public String getPasswordLengthErr() {
          return passwordLengthErr;
     }

     public void setPasswordLengthErr(String passwordLengthErr) {
          this.passwordLengthErr = passwordLengthErr;
     }

     public String getConfirmErr() {
          return confirmErr;
     }

     public void setConfirmErr(String confirmErr) {
          this.confirmErr = confirmErr;
     }

     public String getFullnameLengthErr() {
          return fullnameLengthErr;
     }

     public void setFullnameLengthErr(String fullnameLengthErr) {
          this.fullnameLengthErr = fullnameLengthErr;
     }
     
     
}
