

package slot9;
import slot5.*;
import java.util.Scanner;
import utils.Utils;


public class Experience extends Candidate{
    
    private String type;
    private int yearInExperience;
    private  String skill;
    
    public Experience(String type, int yearInExperience, String skill, String id, String firstName, String lastName, String birthDay, String address, String phone, String email) {
        super(id, firstName, lastName, birthDay, address, phone, email);
        this.type = type;
        this.yearInExperience = yearInExperience;
        this.skill = skill;
    }
    
     public Experience(){
        super();
        this.type = "";
        this.yearInExperience = 0;
        this.skill = "";
    }
    
    public void createEperience(){
        this.createCandidate();
        type = Utils.inputString("Type: ");
        yearInExperience = Utils.inputInt("Year of Experience", 2022, 1999);
        skill = Utils.inputString("Skill: ");
    }
    public void deleteExperience(){
        
    }
    public void updateExperiece(){
        
        
        this.updateCandidate();       
        type = Utils.updateString("Type: ", type);
        yearInExperience = Utils.updateInt("Year of Experience", 2022, 1999,yearInExperience);
        skill = Utils.updateString("Skill: ", skill);
        
        
        
    }
    
    public void searchExperience(){
        
    }
    public void displayExperience(){
        System.out.println("Experience: ");
        this.displayCandidate();
        System.out.println(", type=" + type +", yearInExperience=" + yearInExperience + ", skill=" + skill);                              
        
    }
    
}
