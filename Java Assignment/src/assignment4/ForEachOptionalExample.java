import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Same program rewritten with for-each loop,
 * using Optional, static methods, and default methods.
 *
 * Run: java ForEachOptionalExample.java
 */
public class ForEachOptionalExample implements EmployeeOperations {

    @Override
    public void process(List<Employee> employees) {
        System.out.println("=== High-salary IT employees (for-each) ===");

        List<String> upperNames = new ArrayList<>();

        // for-each instead of Stream API
        for (Employee employee : employees) {
            if (employee.getSalary() > 50000
                    && employee.getDepartment().equalsIgnoreCase("IT")) {
                upperNames.add(employee.getName().toUpperCase());
                printEmployee(employee); // default method from interface
            }
        }

        System.out.println("Uppercase names:");
        for (String name : upperNames) {
            System.out.println(name);
        }

        // static method for average salary
        double avg = EmployeeOperations.averageSalary(employees);
        System.out.println("Average salary (all): " + avg);

        // Optional — safe lookup when value may be missing
        Optional<Employee> found = EmployeeOperations.findByName(employees, "Neha");
        found.ifPresent(emp -> System.out.println("Found: " + emp));

        Optional<Employee> missing = EmployeeOperations.findByName(employees, "Unknown");
        System.out.println("Missing employee: " + missing.orElse(new Employee("N/A", "N/A", 0)));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Asha", "IT", 60000),
                new Employee("Ravi", "HR", 45000),
                new Employee("Neha", "IT", 72000),
                new Employee("Kiran", "Finance", 55000),
                new Employee("Meera", "IT", 48000)
        );

        ForEachOptionalExample example = new ForEachOptionalExample();
        example.process(employees);
    }
}

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " | " + department + " | " + salary;
    }
}

interface EmployeeOperations {

    void process(List<Employee> employees);

    // default method
    default void printEmployee(Employee employee) {
        System.out.println(employee);
    }

    // static method
    static Optional<Employee> findByName(List<Employee> employees, String name) {
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                return Optional.of(employee);
            }
        }
        return Optional.empty();
    }

    static double averageSalary(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            return 0.0;
        }
        double total = 0;
        for (Employee employee : employees) {
            total += employee.getSalary();
        }
        return total / employees.size();
    }
}
