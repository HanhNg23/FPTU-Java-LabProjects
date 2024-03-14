package sample.dto;

import java.util.Scanner;
import sample.utils.Utils;

public class Intern extends Candidate {

    private String majors;
    private String semester;
    private String nameUniversity;

    public Intern(String majors, String semester, String nameUniversity, String id, String firstName, String lastName, String birthDay, String address, String phone, String email) {
        super(id, firstName, lastName, birthDay, address, phone, email);
        this.majors = majors;
        this.semester = semester;
        this.nameUniversity = nameUniversity;
    }

    public Intern() {

    }
    
    public Intern(String id){
        super.setId(id);
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getNameUniversity() {
        return nameUniversity;
    }

    public void setNameUniversity(String nameUniversity) {
        this.nameUniversity = nameUniversity;
    }

    public void updateCandidate() {
        super.updateCandidate();
        majors = Utils.getString("Update Majors: ", majors);
        semester = Utils.getString("Update Semester: ", semester);
        nameUniversity = Utils.getString("Update University name: ", nameUniversity);
    }

    public void createCandidate() {
        super.createCandidate();
        majors = Utils.getString("Input Majors: ");
        semester = Utils.getString("Input Semester: ");
        nameUniversity = Utils.getString("Input University name: ");
    }

    @Override
    public void displayCandidate() {
        System.out.print("Intern: ");
        super.displayCandidate();
        System.out.println(", majors=" + majors + ", semester=" + semester + ", nameUniversity=" + nameUniversity + ']');
        
    }
    
    

    @Override
    public String toString() {
        return "[ Intern" + super.toString() + "majors=" + majors + ", semester=" + semester + ", nameUniversity=" + nameUniversity + '}';
    }
    
}
