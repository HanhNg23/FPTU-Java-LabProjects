
package slot5;
import java.util.Scanner;


public class Intern extends Candidate{
    private String majors;
    private String semester;
    private String nameUniversity;
 
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
    
    
    
  
    void createIntern(){
        Scanner scan = new Scanner(System.in);
        this.createCandidate();
        System.out.println("Input Majors: ");
        majors = scan.nextLine();
        System.out.println("Input Semester: ");
        semester = scan.nextLine();
        System.out.println("Input Universityname: ");
        nameUniversity = scan.nextLine();
         
    }
    void deleteIntern(){
        
    }
    void updateExperiece(){
        Scanner scan = new Scanner(System.in);
        this.updateCandidate();
        System.out.println("Update Majors: ");
        majors = scan.nextLine();
        System.out.println("Update Semester: ");
        semester = scan.nextLine();
        System.out.println("Update Universityname: ");
        nameUniversity = scan.nextLine();
        
    }
    
    void searchIntern(){
        
    }
    void displayIntern(){
        this.displayCandidate();
        System.out.println("Majors: "+majors);
        System.out.println("Semester: "+semester);
        System.out.println("Universityname: "+nameUniversity);  
    }
}
