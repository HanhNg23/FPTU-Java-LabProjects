

package slot5;
import java.util.Scanner;


public class Experience extends Candidate{
    
    private String type;
    private int yearInExperience;
    private  String skill;
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
    
  
    public void createEperience(){

        Scanner scan = new Scanner(System.in);
        this.createCandidate();
        
        System.out.println("Input Type: ");
        type = scan.nextLine();
        System.out.println("Input Year Of Experience: ");
        yearInExperience = scan.nextInt();
        System.out.println("Input Skill: ");
        skill = scan.nextLine();
         
    }
    public void deleteExperience(){
        
    }
    public void updateExperiece(){
        
        Scanner scan = new Scanner(System.in);
        this.updateCandidate();
        
        System.out.println("Update Type: ");
        type = scan.nextLine();
        System.out.println("Update Year Of Experience: ");
        yearInExperience = scan.nextInt();
        System.out.println("Update Skill: ");
        skill = scan.nextLine();
        
    }
    
    public void searchExperience(){
        
    }
    public void displayExperience(){
        
        this.displayCandidate();
        
        System.out.println("Type: "+type);
        System.out.println("Year Of Experience: "+yearInExperience);
        System.out.println("Skill: "+skill);
    }
}
