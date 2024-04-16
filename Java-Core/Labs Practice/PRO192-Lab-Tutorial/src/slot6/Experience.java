

package slot6;
import slot5.*;
import java.util.Scanner;


public class Experience {
    private String id;
    private String firstName;
    private String lastName;
    private String birthDay;
    private String address;
    private String phone;
    private String email;
    private String type;
    private int yearInExperience;
    private  String skill;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYearInExperience() {
        return yearInExperience;
    }

    public void setYearInExperience(int yearInExperience) {
        this.yearInExperience = yearInExperience;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    
    
  
    void createEperience(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Input Id: ");
        id = scan.nextLine();
        System.out.println("Input Firstname: ");
        firstName = scan.nextLine();
        System.out.println("Input Lastname: ");
        lastName = scan.nextLine();
        System.out.println("Input Birthday: ");
        birthDay = scan.nextLine();
        System.out.println("Input Address: ");
        address = scan.nextLine();
        System.out.println("Input Phone: ");
        phone = scan.nextLine();
        System.out.println("Input Email: ");
        email = scan.nextLine();
        System.out.println("Input Type: ");
        type = scan.nextLine();
        System.out.println("Input Year Of Experience: ");
        yearInExperience = scan.nextInt();
        System.out.println("Input Skill: ");
        skill = scan.nextLine();
         
    }
    void deleteExperience(){
        
    }
    void updateExperiece(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Update Id: ");
        id = scan.nextLine();
        System.out.println("Update Firstname: ");
        firstName = scan.nextLine();
        System.out.println("Update Lastname: ");
        lastName = scan.nextLine();
        System.out.println("Update Birthday: ");
        birthDay = scan.nextLine();
        System.out.println("Update Address: ");
        address = scan.nextLine();
        System.out.println("Update Phone: ");
        phone = scan.nextLine();
        System.out.println("Update Email: ");
        email = scan.nextLine();
        System.out.println("Update Type: ");
        type = scan.nextLine();
        System.out.println("Update Year Of Experience: ");
        yearInExperience = scan.nextInt();
        System.out.println("Update Skill: ");
        skill = scan.nextLine();
        
    }
    
    void searchExperience(){
        
    }
    void displayExperience(){
           
        System.out.println("Id: "+id);
        
        System.out.println("Firstname: "+firstName);
        
        System.out.println("Lastname: "+lastName);
        
        System.out.println("Birthday: "+birthDay);
       
        System.out.println("Address: "+address);
      
        System.out.println("Phone: "+phone);
       
        System.out.println("Email: "+email);
       
        System.out.println("Type: "+type);
      
        System.out.println("Year Of Experience: "+yearInExperience);
   
        System.out.println("Skill: "+skill);
    }
}
