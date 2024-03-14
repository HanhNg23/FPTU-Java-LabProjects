/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.dto;
import java.util.Scanner;
import sample.utils.Utils;

public class Fresher extends Candidate{
    private String dateGraduation;
    private String rankGraduation;
    private String schoolGraduation;

    public Fresher(String dateGraduation, String rankGraduation, String schoolGraduation, String id, String firstName, String lastName, String birthDay, String address, String phone, String email) {
        super(id, firstName, lastName, birthDay, address, phone, email);
        this.dateGraduation = dateGraduation;
        this.rankGraduation = rankGraduation;
        this.schoolGraduation = schoolGraduation;
    }

    public Fresher(){
        
    }
    
    public Fresher(String id){
        super.setId(id);
    }
    
    public String getDateGraduation() {
        return dateGraduation;
    }

    public void setDateGraduation(String dateGraduation) {
        this.dateGraduation = dateGraduation;
    }

    public String getRankGraduation() {
        return rankGraduation;
    }

    public void setRankGraduation(String rankGraduation) {
        this.rankGraduation = rankGraduation;
    }

    public String getSchoolGraduation() {
        return schoolGraduation;
    }

    public void setSchoolGraduation(String schoolGraduation) {
        this.schoolGraduation = schoolGraduation;
    }
    
    
    @Override
     public void createCandidate(){        
        super.createCandidate();
        dateGraduation = Utils.getString("Input Date of Graduation: ");
        rankGraduation = Utils.getString("Input rank of Graduation: ");
        schoolGraduation = Utils.getString("Input your school of Graduation: ");
    }
     
    @Override
    public void updateCandidate(){ 
        super.updateCandidate();
        dateGraduation = Utils.getString("Update Date of Graduation: ", dateGraduation);
        rankGraduation = Utils.getString("Update rank of Graduation: ", rankGraduation);
        schoolGraduation = Utils.getString("Update your school of Graduation: ", schoolGraduation);
    }
    
    @Override    
        public void displayCandidate() {
        System.out.print("Fresher: ");
        super.displayCandidate();
        System.out.println(", Date of Graduation: " + dateGraduation + ", Rank of Graduation: " + rankGraduation + ", Your school of Graduation: " + schoolGraduation + "]");
    }

    @Override
    public String toString() {
        return "[ Fresher " + super.toString() + "dateGraduation=" + dateGraduation + ", rankGraduation=" + rankGraduation + ", schoolGraduation=" + schoolGraduation + '}';
    }
                               
        
   
}
