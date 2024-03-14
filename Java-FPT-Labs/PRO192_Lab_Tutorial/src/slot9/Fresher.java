/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot9;

import slot5.*;
import java.util.Scanner;

public class Fresher extends Candidate{
    private String dateGraduation;
    private String rankGraduation;
    private String schoolGraduation;

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
        
    public void createFresher(){
        
        Scanner scan = new Scanner(System.in);
        this.createCandidate();
        
        System.out.println("Input Date of Graduation: ");
        dateGraduation = scan.nextLine();
        System.out.println("Input rank of Graduation: ");
        rankGraduation = scan.nextLine();
        System.out.println("Input your school of Graduation: ");
        schoolGraduation = scan.nextLine();
        
    }
    public void deleteFresher(){
        
    }
    public void updateFresher(){
        
        Scanner scan = new Scanner(System.in);
        this.updateCandidate();
        
        System.out.println("Update Date of Graduation: ");
        dateGraduation = scan.nextLine();
        System.out.println("Update rank of Graduation: ");
        rankGraduation = scan.nextLine();
        System.out.println("Update your school of Graduation: ");
        schoolGraduation = scan.nextLine();
        
    }
    
    public void searchFresher(){
        
    }
    public void displayFresher() {
        this.displayCandidate();
        System.out.println(", Date of Graduation: " + dateGraduation + ", Rank of Graduation: " + rankGraduation + ", Your school of Graduation: " + schoolGraduation);

    }
}
