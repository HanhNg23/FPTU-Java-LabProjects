package sample.dto;

import java.util.Scanner;
import sample.utils.Utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class Candidate implements Comparable<Object>{ //implement de override compareto

    private String id;
    private String firstName;
    private String lastName;
    private String birthDay;
    private String address;
    private String phone;
    private String email;

    public Candidate(String id, String firstName, String lastName, String birthDay, String address, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Candidate(String id) {
        this.id = id;
    }

    public Candidate() {
    }
    
    

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
        //id = Utils.getString("Input Id: ");
        firstName = Utils.getString("Firstname: ");
        lastName = Utils.getString("Lastname: ");
        birthDay = Utils.getString("Birthday: ");
        address = Utils.getString("Address: ");
        phone = Utils.getString("Phone: ");
        email = Utils.getString("Email: ");
    }
     
    public void displayCandidate(){
        System.out.print("[ id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDay=" + birthDay + ", address=" + address + ", phone=" + phone + ", email=" + email);
    }
    
    public void updateCandidate(){
        //id = Utils.getString("Input Id: ", id);
        firstName = Utils.getString("Firstname: ", firstName);
        lastName = Utils.getString("Lastname: ", lastName);
        birthDay = Utils.getString("Birthday: ", birthDay);
        address = Utils.getString("Address: ",address);
        phone = Utils.getString("Phone: ", phone);
        email = Utils.getString("Email: ", email);
    }

    @Override
    public boolean equals(Object obj) { // thong qua id
        Candidate p = (Candidate) obj;
        return this.id.equals(p.getId()); 
    }

    @Override
    public String toString() {
        return  "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDay=" + birthDay + ", address=" + address + ", phone=" + phone + ", email=" + email ;
    }
    
    //public String 
      //      display compare create
    
    @Override
    public int compareTo(Object obj){ //muc dich sap xep name
        Candidate p = (Candidate) obj;
        return this.id.compareToIgnoreCase(p.id);
        
    }
}
