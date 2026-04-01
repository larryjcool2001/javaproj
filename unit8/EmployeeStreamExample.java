package unit8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    String name;
    int age;
    String department;
    double salary;

    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

public class EmployeeStreamExample {

    public static void main(String[] args) {

        // Step 1: Store dataset
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 28, "IT", 5000),
            new Employee("Bob", 35, "HR", 6000),
            new Employee("Charlie", 40, "Finance", 7000),
            new Employee("Diana", 25, "IT", 4500),
            new Employee("Edward", 50, "Management", 9000)
        );

        // Step 2: Function Interface
        Function<Employee, String> empFunction =
                emp -> emp.getName() + " - " + emp.getDepartment();

        // Step 3: Stream transformation
        List<String> nameDeptList = employees.stream()
                .map(empFunction)
                .collect(Collectors.toList());

        System.out.println("Employee Name & Department:");
        nameDeptList.forEach(System.out::println);

        // Step 4: Average salary
        double avgSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        System.out.println("\nAverage Salary: " + avgSalary);

        // Step 5: Filter employees above age 30
        List<Employee> filteredEmployees = employees.stream()
                .filter(emp -> emp.getAge() > 30)
                .collect(Collectors.toList());

        System.out.println("\nEmployees above age 30:");
        filteredEmployees.forEach(emp ->
                System.out.println(emp.getName() + " (" + emp.getAge() + ")"));

        // BONUS: Highest salary employee
        Optional<Employee> highestPaid = employees.stream()
                .max(Comparator.comparing(Employee::getSalary));

        highestPaid.ifPresent(emp ->
                System.out.println("\nHighest Paid: " + emp.getName()));
    }
}
