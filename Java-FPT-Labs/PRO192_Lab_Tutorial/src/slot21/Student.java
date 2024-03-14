
package slot21;
import utils.Utils;

public class Student {

    private String id;
    private String name;
    private String semester;
    private String course;

    public Student(String id, String name, String semester, String course) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.course = course;
    }
    public Student(String id) {
        this.id = id;
        
    }

    public Student() {
        this.id = "";
        this.name = "";
        this.semester = "";
        this.course = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
    

    public boolean create() {
        boolean result = false;
        try {
            this.id = Utils.inputString("Id: ");
            this.name = Utils.inputString("Name: ");
            this.semester = Utils.inputString("Semester: ");
            this.course = Utils.inputString("Course: ");
            return true;
        } catch (Exception e) {

        }
        return result;
    }
    

    public boolean update() {
        boolean result = false;
          try {
            this.id = Utils.updateString("Id: ",id);
            this.name = Utils.updateString("Name: ", name);
            this.semester = Utils.updateString("Semester: ", semester);
            this.course = Utils.updateString("Course: ", course);
            return true;
        } catch (Exception e) {

        }
        return result;

    }

    public void showInfor() {
        System.out.println("Student{" + "id=" + id + ", name=" + name + ", semester=" + semester + ", course=" + course + ']');

    }
    
    public boolean equals(Object obj){
        return this.id.equals(((Student)obj).getId()); 
    }

}
