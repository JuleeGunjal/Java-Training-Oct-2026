//Write class Teacher and Student which extends class Person. Add properties Roll no, course,
// department in student class along with the constructor and getter, setters. Add properties department,
// specialization in Teacher class along with constructor and getter, setters. The constructor should accept
// all the properties of the person as well as the current class i.e Student or Teacher and set the properties.

public class Teacher extends Person {
    private String department;
    private String specialization;

    public Teacher(String name, int age, String department, String specialization) {
        super(name, age);
        this.department = department;
        this.specialization = specialization;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
