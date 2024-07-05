package STREAMS;

import java.util.*;
import java.util.stream.*;

class employee2{
    private int id;
    private String name;
    private int age;
    private String department;
    private String gender;
    private int year;
    private double salary;

    public employee2(int id, String name, int age, String gender,String department,  int year, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.gender = gender;
        this.year = year;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}

public class streams {
    public static void main(String[] args) {
        List<employee2> emp1 = new ArrayList<>();
        emp1.add(new employee2(111, "Vishnu Priya", 32, "Female", "HR", 2011, 25000.0));
        emp1.add(new employee2(122, "Vinay Raj", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        emp1.add(new employee2(133, "Avinash Reddy", 29, "Male", "Infrastructure", 2012, 18000.0));
        emp1.add(new employee2(144, "Bhanu Prasad", 28, "Male", "Product Development", 2014, 32500.0));
        emp1.add(new employee2(155, "Aish Roy", 27, "Female", "HR", 2013, 22700.0));
        emp1.add(new employee2(166, "Raj Vignesh", 43, "Male", "Security And Transport", 2016, 10500.0));
        emp1.add(new employee2(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        emp1.add(new employee2(188, "Chandra Mouli", 31, "Male", "Product Development", 2015, 34500.0));
        emp1.add(new employee2(199, "Shilpa Shetty", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        emp1.add(new employee2(200, "Kumar Raja", 38, "Male", "Security And Transport", 2015, 11000.5));
        emp1.add(new employee2(211, "Ameen Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        emp1.add(new employee2(222, "Sunil Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        emp1.add(new employee2(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        emp1.add(new employee2(244, "Shankar Dada", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        emp1.add(new employee2(255, "Alia Butt", 23, "Male", "Infrastructure", 2018, 12700.0));
        emp1.add(new employee2(266, "Santhi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        emp1.add(new employee2(277, "Sunil Shetty", 31, "Male", "Product Development", 2012, 35700.0));

        // using streams
        long count = emp1.stream()
                .filter(gender -> gender.getGender().equalsIgnoreCase("male"))
                .count();
        System.out.println("Number of male employees: " + count);


        //1 : How many male and female employees are there in the organization?
        System.out.println("Number of male employees: ");
        List<String> example = emp1.stream()
                .filter(gender -> gender.getGender().equalsIgnoreCase("male"))
                .map(gender -> gender.getName()+" - " + gender.getGender()).collect(Collectors.toList());
        example.forEach(System.out::println);
        System.out.println("\nNumber of Female employees: ");
        emp1.stream().filter(gender -> gender.getGender().equalsIgnoreCase("female")).forEach(gender -> System.out.println(gender.getName()+" - "+gender.getGender()));


        // 2 : Print the name of all departments in the organization?
        List<String> departmentn = emp1.stream().map(department -> department.getDepartment()).distinct().collect(Collectors.toList());
        System.out.println("\n Department Names :");
        departmentn.forEach(System.out::println);


        //3 : What is the average age of male and female employees?
        OptionalDouble avgmale = emp1.stream().filter(e->e.getGender().equalsIgnoreCase("male")).mapToInt(employee2::getAge).average();
        System.out.println("Average age of Male Employees : "+avgmale);
        OptionalDouble avgFemale = emp1.stream().filter(e->e.getGender().equalsIgnoreCase("female")).mapToInt(employee2::getAge).average();
        System.out.println("Average age of Female Employees : "+avgFemale);


        // 4 : Get the details of highest paid employee in the organization?
        OptionalDouble highestPay = emp1.stream().mapToDouble(employee2::getSalary).max();

        Optional<employee2> emphighest = emp1.stream().filter(e->e.getSalary() == highestPay.getAsDouble()).findFirst();
        emphighest.ifPresent(employee2 -> {
            System.out.println("The highest Paid : " +employee2.getName()+" "+employee2.getSalary());
        });


         // 5 : Get the names of all employees who have joined after 2015?
        System.out.println("\nEmployees joined after 2015 :");
        emp1.stream().filter(join -> join.getYear() > 2015).map(join -> join.getName() + " - " + join.getYear()).forEach(System.out::println);


        //  6 : Count the number of employees in each department?
        Map<String, Long>  depCount = emp1.stream().collect(Collectors.groupingBy(employee2::getDepartment,Collectors.counting()));
        System.out.println("\n count of employees in each department : ");
        for (Map.Entry<String,Long> entry : depCount.entrySet()){
            System.out.println(entry.getKey()+" - "+entry.getValue());
        }


        // 7 : What is the average salary of each department?
        Map<String,Double> avgsalary = emp1.stream()
                .collect(Collectors.groupingBy(employee2::getDepartment,Collectors.averagingDouble(employee2::getSalary)));
        // traditional method to print map
        for (Map.Entry<String,Double> entry : avgsalary.entrySet()){
            System.out.println("Average Salary in "+entry.getKey()+" : "+entry.getValue());
        }
        // can also be printed as :
        avgsalary.forEach((department, avgSalary) -> {
            System.out.println("Average salary in " + department + ": " + avgSalary);
        });


        //  8 : Get the details of youngest male employee in the product
        System.out.println("\n employee in Product development with east experience :");
        Stream<employee2> ProductEmployees = emp1.stream().filter(e->e.getDepartment().equalsIgnoreCase("product development"));
        Stream<employee2> productMaleyoungemp = ProductEmployees.filter(e->e.getGender().equalsIgnoreCase("male"));
        Optional<employee2> youngmale = productMaleyoungemp.min(Comparator.comparing(employee2::getAge));
        youngmale.ifPresent(employee2 -> {
            System.out.println(employee2.getName()+" "+employee2.getAge()+" "+employee2.getGender());
        });


        // 9 : Who has the most working experience in the organization?
        System.out.println("\n employee with most experience :");
        Optional<employee2> yearfilter = emp1.stream().min(Comparator.comparing(employee2::getYear));
        yearfilter.ifPresent(employee2 -> {
            System.out.println(employee2.getName()+" "+employee2.getYear());
        });


        // 10 : How many male and female employees are there in the sales and
        Stream<employee2> empinSales = emp1.stream().filter(e -> e.getDepartment().equalsIgnoreCase("Sales And Marketing"));
        Stream<employee2>  maleemp = empinSales.filter(e -> e.getGender().equalsIgnoreCase("male"));
        long count1 = maleemp.count();
        System.out.println("\nTotal number of male employees in sales : "+count1);
        Stream<employee2> empinSales1 = emp1.stream().filter(e -> e.getDepartment().equalsIgnoreCase("Sales And Marketing"));
        Stream<employee2> female = empinSales1.filter(e -> e.getGender().equalsIgnoreCase("female"));
        long count2 = female.count();
        System.out.println("Total number of female employees in sales : "+count2);


        // 11 : What is the average salary of male and female employees?
        Stream<employee2> avgfil = emp1.stream().filter(e -> e.getGender().equalsIgnoreCase("male"));
        OptionalDouble avgMale = avgfil.mapToDouble(employee2::getSalary).average();
        System.out.println("\nAverage Male Salary : "+avgMale);

        Stream<employee2> avgfil2 = emp1.stream().filter(e -> e.getGender().equalsIgnoreCase("female"));
        OptionalDouble avgfemale = avgfil2.mapToDouble(employee2::getSalary).average();
        System.out.println("Average Female Salary : "+avgfemale);


        // 12 : List down the names of all employees in each department?
        Map<String,List<String>> nameDep = emp1.stream()
                .collect(Collectors.groupingBy(employee2::getDepartment,Collectors.mapping(employee2::getName,Collectors.toList())));
        System.out.println("\nAll Employees of each department : ");
        for (Map.Entry<String,List<String>> entry : nameDep.entrySet()){
            System.out.println(entry.getKey()+" - "+entry.getValue());
        }


        // 13 : What is the average salary and total salary of the whole
        OptionalDouble avgSalary = emp1.stream().mapToDouble(employee2::getSalary).average();
        System.out.println("\nthe total avg Salary : "+avgSalary);
        Double total = emp1.stream().mapToDouble(employee2::getSalary).sum();
        System.out.println("Total Sum of Salary : "+total);


        // 14 : Separate the employees who are younger or equal to 25 years from
        System.out.println("\nEmployees age less then or equal to 25 : ");
        emp1.stream().filter(young -> young.getAge() <= 25).map(young-> young.getName()+" - "+young.getAge()).forEach(System.out::println);


        //15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
        System.out.println("\nEmployee oldest having age and department :");
        Optional<employee2> emp2 = emp1.stream().max(Comparator.comparing(employee2::getAge));
        emp2.ifPresent(employee2 -> {
            System.out.println(employee2.getName()+ " "+employee2.getAge()+" "+employee2.getDepartment());
        });


    }
}
