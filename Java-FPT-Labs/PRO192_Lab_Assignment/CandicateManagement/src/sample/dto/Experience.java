

package sample.dto;

import sample.utils.Utils;

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

    public Experience() {
    }
    
    public Experience(String id) {
        super.setId(id);
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
 
    @Override
    public void createCandidate(){
        super.createCandidate();
        type = Utils.getString("Input Type: ");
        yearInExperience = Utils.getInt("Year of Experience", 1999, 2022);
        skill = Utils.getString("Input Skill: ");
    }
    
    @Override
    public void updateCandidate(){
        super.updateCandidate();
        type = Utils.getString("Update Type: ", type);
        yearInExperience = Utils.getInt("Year of Experience", 1999, 2022, yearInExperience);
        skill = Utils.getString("Update Skill: ", skill);
    }

    @Override
        public void displayCandidate(){
        System.out.print("Experience: ");
        super.displayCandidate();
        System.out.println(", type=" + type +", yearInExperience=" + yearInExperience + ", skill=" + skill + "]");                              
    
        }

    @Override
    public String toString() {
        return "[ Experience" + super.toString() + "type=" + type + ", yearInExperience=" + yearInExperience + ", skill=" + skill + '}';
    }
        
    

    
    
    
     
    
}
