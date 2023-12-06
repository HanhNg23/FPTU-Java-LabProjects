/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot5;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    


 

    public void createCandidate(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Input Id: ");
        this.setId(scan.nextLine()); 
        System.out.println("Input Firstname: ");
        this.setFirstName(scan.nextLine());
        System.out.println("Input Lastname: ");
        this.setLastName(scan.nextLine());
        System.out.println("Input Birthday: ");
        this.setId(scan.nextLine());
        System.out.println("Input Address: ");
        this.setAddress(scan.nextLine());
        System.out.println("Input Phone: ");
        this.setPhone(scan.nextLine());
        System.out.println("Input Email: ");
        this.setEmail(scan.nextLine());

         
    }
    public void deleteCandidate(){
        
    }
    public void updateCandidate(){
        Scanner scan = new Scanner(System.in);
        //chinh thanh chu update
        System.out.println("Update Id: ");
        this.setId(scan.nextLine()); 
        System.out.println("Update Firstname: ");
        this.setFirstName(scan.nextLine());
        System.out.println("Update Lastname: ");
        this.setLastName(scan.nextLine());
        System.out.println("Update Birthday: ");
        this.setId(scan.nextLine());
        System.out.println("Update Address: ");
        this.setAddress(scan.nextLine());
        System.out.println("Update Phone: ");
        this.setPhone(scan.nextLine());
        System.out.println("Update Email: ");
        this.setEmail(scan.nextLine());
      
    
    }
    
    public void searchCandidate(){
        
    }
    public void displayCandidate(){
           
        System.out.println("Id: "+this.getId());
        
        System.out.println("Firstname: "+this.getFirstName());
        
        System.out.println("Lastname: "+this.getLastName());
        
        System.out.println("Birthday: "+this.getBirthDay());
       
        System.out.println("Address: "+this.getAddress());
      
        System.out.println("Phone: "+this.getPhone());
        System.out.println("Email: "+this.getEmail());
 
    }
}



    

