package employee;

import java.util.Comparator;
import java.util.TreeSet;

// Employee class
class Employee {
    private int id;
    private String name;
    private double salary;
    private int age;

    public Employee(int id, String name, double salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
}

// EmpComparator class
class EmpComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        // Sort by ascending salary
        if (e1.getSalary() < e2.getSalary()) {
            return -1;
        } else if (e1.getSalary() > e2.getSalary()) {
            return 1;
        } else {
            // If salaries are equal, sort by alphabetic order of names
            int nameCompare = e1.getName().compareTo(e2.getName());
            if (nameCompare != 0) {
                return nameCompare;
            } else {
                // If salaries and names are equal, sort by descending order of age
                return Integer.compare(e2.getAge(), e1.getAge());
            }
        }
    }
}

class EmployeeSet {
    TreeSet<Employee> empTreeSet;

    public EmployeeSet() {
        this.empTreeSet = new TreeSet<>(new EmpComparator());
    }

    public int addEmployee(Employee emp) {
        if (emp == null) {
            return 1;
        }
        try {
            this.empTreeSet.add(emp);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }
}

public class EmployeeTreeSet {
    public static void main(String[] args) {
        // Create a TreeSet with the custom comparator
        TreeSet<Employee> empSet = new TreeSet<>(new EmpComparator());

        // Add employees to the TreeSet
        empSet.add(new Employee(1, "Alice", 50000.0, 30));
        empSet.add(new Employee(2, "Bob", 60000.0, 35));
        empSet.add(new Employee(3, "Charlie", 50000.0, 25));
        empSet.add(new Employee(4, "David", 55000.0, 40));
        empSet.add(new Employee(5, "Eve", 50000.0, 28));


        System.out.println("Employees sorted by the custom comparator:");
        for (Employee e : empSet) {
            System.out.println("ID: " + e.getId() + ", Name: " + e.getName() + ", Salary: " + e.getSalary() + ", Age: " + e.getAge());
        }

        EmployeeSet empSet1 = new EmployeeSet();
        empSet1.addEmployee(new Employee(1, "Alice",22000,22));
        empSet1.addEmployee(new Employee(2, "Bob", 60000.0,22));
        empSet1.addEmployee(new Employee(3, "Charlie", 50000.0,22));
        empSet1.addEmployee(new Employee(4, "David", 55000.0,22));
        empSet1.addEmployee(new Employee(5, "Eve", 50000.0,23));

        System.out.println("\nemployees in employeSet Method :");
    

        for (Employee e : empSet1.empTreeSet) {
            System.out.println("ID: " + e.getId() + ", Name: " + e.getName() + ", Salary: " + e.getSalary() + ", Age: " + e.getAge());
        }
    }
}
