
//Write class Teacher and Student which extends class Person. Add properties Roll no, course, department in student class along with the constructor and getter, setters. Add properties department, specialization in Teacher class along with constructor and getter, setters. The constructor should accept all the properties of the person as well as the current class i.e Student or Teacher and set the properties.

public class Student extends Person {
    private String department;
    private  int rollNo;
    private String course;

    public Student(String name, int age, String course, String department, int rollNo) {
        super(name, age);
        this.department = department;
        this.rollNo = rollNo;
        this.course = course;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }

}
