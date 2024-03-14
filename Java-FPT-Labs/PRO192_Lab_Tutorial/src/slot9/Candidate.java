/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot9;
import utils.Utils;
import slot5.*;
import java.util.Scanner;

/**
 *
 * @author HOANGANH
 */
public class Candidate {
    private String id;
    private String firstName;
    private String lastName;
    private String birthDay;
    private String address;
    private String phone;
    private String email;

     public Candidate() {
        this.id = "";
        this.firstName = "";
        this.lastName = "";
        this.birthDay = "";
        this.address = "";
        this.phone = "";
        this.email = "";
    }
    public Candidate(String id, String firstName, String lastName, String birthDay, String address, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    
    

    public void createCandidate(){
        id = Utils.inputString("Input Id: ");
        firstName = Utils.inputString("Firstname: ");
        lastName = Utils.inputString("Lastname: ");
        birthDay = Utils.inputString("Birthday: ");
        address = Utils.inputString("Address: ");
        phone = Utils.inputPhone("Phone: ");
        email = Utils.inputString("Email: ");
    }
    public void deleteCandidate(){
        
    }
    public void updateCandidate(){
        id = Utils.updateString("Input Id: ", id);
        firstName = Utils.updateString("Firstname: ", firstName);
        lastName = Utils.updateString("Lastname: ", lastName);
        birthDay = Utils.updateString("Birthday: ", birthDay);
        address = Utils.updateString("Address: ",address);
        phone = Utils.updatePhone("Phone: ", phone);
        email = Utils.updateString("Email: ", email);
    }
    
    public void searchCandidate(){
        
    }
    public void displayCandidate(){
        System.out.println("");
        System.out.print("id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDay=" + birthDay + ", address=" + address + ", phone=" + phone + ", email=" + email);
    }
}



    

