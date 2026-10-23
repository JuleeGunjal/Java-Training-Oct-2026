import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Program using Stream API along with lambda expressions and functional interfaces.
 *
 * Run: java StreamApiExample.java
 */
public class StreamApiExample {

    public static void main(String[] args) {
        List<Emp> employees = Arrays.asList(
                new Emp("Asha", "IT", 60000),
                new Emp("Ravi", "HR", 45000),
                new Emp("Neha", "IT", 72000),
                new Emp("Kiran", "Finance", 55000),
                new Emp("Meera", "IT", 48000)
        );

        // Built-in functional interfaces used with lambdas
        Predicate<Emp> highSalary = emp -> emp.getSalary() > 50000;
        Predicate<Emp> itDept = emp -> emp.getDepartment().equalsIgnoreCase("IT");
        Function<Emp, String> toUpperName = emp -> emp.getName().toUpperCase();
        Consumer<String> printer = name -> System.out.println(name);

        // Custom functional interface with lambda
        EmpFilter customFilter = emp -> emp.getSalary() > 50000
                && emp.getDepartment().equalsIgnoreCase("IT");

        System.out.println("=== Using Stream API + lambdas + functional interfaces ===");

        List<String> result = employees.stream()
                .filter(highSalary.and(itDept))   // Predicate
                .filter(customFilter::test)       // custom functional interface
                .map(toUpperName)                 // Function
                .collect(Collectors.toList());

        result.forEach(printer);                  // Consumer

        double avgItSalary = employees.stream()
                .filter(itDept)
                .mapToDouble(Emp::getSalary)
                .average()
                .orElse(0.0);

        System.out.println("Average IT salary: " + avgItSalary);
    }
}

class Emp {
    private String name;
    private String department;
    private double salary;

    public Emp(String name, String department, double salary) {
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
}

@FunctionalInterface
interface EmpFilter {
    boolean test(Emp employee);
}
