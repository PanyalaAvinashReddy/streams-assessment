package collections;

import java.util.*;

class employee1{
    private int id;
    private String name;
    private int age;
    private String department;
    private String gender;
    private int year;
    private double salary;

    public employee1(int id, String name, int age, String gender, String department, int year, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department=department;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}


public class employee {

    // Q2: to get all departments
    public static void dep(List<employee1> dep){
        Set<String> e = new HashSet<>();
        for (employee1 i : dep){
            e.add(i.getDepartment());
        }
        System.out.println("Print all the departments : \n"+e);
    }

    // 1 : How many male and female employees are there in the organization?
    // 3 : What is the average age of male and female employees?
    // 11 : What is the average salary of male and female employees?
    // 13 : What is the average salary and total salary of the whole
    public static void avgAgeAvgSalaryCount(List<employee1> dep){
        float sumMale = 0f;
        float sumFemale = 0f;
        int countMale = 0;
        int countFemale = 0;
        double maleSalary = 0;
        double femaleSalary = 0;

        for(employee1 a : dep){
            if(a.getGender().equals("Male")){
                sumMale += a.getAge();
                maleSalary += a.getSalary();
                countMale++;
            }
            if(a.getGender().equalsIgnoreCase("Female")) {
                sumFemale += a.getAge();
                femaleSalary += a.getSalary();
                countFemale++;
            }
        }
        float avgMale = sumMale/countMale;
        float avgFemale = sumFemale/countFemale;
        float avg = (sumMale+sumFemale)/(countMale+countFemale);
        double avgSalaryMale = maleSalary/countMale;
        double avgSalaryFemale = femaleSalary/countFemale;
        double avgSalary = (avgSalaryMale+avgSalaryFemale)/(countMale/countFemale);

        System.out.println("Number of males :" + countMale);
        System.out.println("Number of females : "+countFemale);
        System.out.println("Average age of males :"+avgMale);
        System.out.println("Average age of Females :"+avgFemale );
        System.out.println("Avg of both male and female"+avg);
        System.out.println("Average salary of male : "+ avgSalaryMale);
        System.out.println("Average salary of female : "+ avgSalaryFemale);
        System.out.println("Average salary of both male and female : "+ avgSalary);
        System.out.println("Total Salary of whole : "+(maleSalary+femaleSalary) );
    }

    //4 : Get the details of highest paid employee in the organization?
    public static void highestSalary(List<employee1> emp){
        double highest = 0;
        for (employee1 i : emp) {
            if (i.getSalary() > highest) {
                highest = i.getSalary();
            }
        }
        System.out.println("The highest pay is :"+highest);
    }

    //5 : Get the names of all employees who have joined after 2015?
    public static void joinedAfter(List<employee1> emp){
        List<String> arr = new ArrayList<>();
        for (employee1 i : emp){
            if(2015 < i.getYear()){
                arr.add(i.getName());
            }
        }
        if(arr!=null){
            System.out.print("the employees joined after 2015 : ");
            for (String i : arr){
                System.out.println(i+" ,");
            }
        }
    }

    //6 : Count the number of employees in each department?
    // 12 : List down the names of all employees in each department?
    public static void countOfEmployeesInDepartment(List<employee1> emp){
        Map<String,Integer> departmentCounts = new HashMap<>();
        for(employee1 i : emp){
            String department = i.getDepartment();
            if(departmentCounts.containsKey(department)){
                departmentCounts.put(department,departmentCounts.get(department)+1);
            }else{
                departmentCounts.put(department,1);
            }
        }
        for(Map.Entry<String,Integer> count : departmentCounts.entrySet()){
            System.out.println("Department : "+ count.getKey()+" " + "No of Employees : "+ count.getValue());
        }


        Map<String,String> employeesList = new HashMap<>();
        for (employee1 i : emp) {
            String department = i.getDepartment();
            String name = i.getName();
            if (employeesList.containsKey(department)) {
                employeesList.put(department,employeesList.get(department)+" , "+ name);
            }else{
                employeesList.put(department,name);
            }
        }
        for (Map.Entry<String, String> entry : employeesList.entrySet()) {
            System.out.println("Department : " + entry.getKey() + " names :" + entry.getValue());
        }

    }
    //7 : What is the average salary of each department?
    public static  void salaryOfDepartment(List<employee1> emp){
        double hrSalary = 0,financSalary = 0,securitySalary = 0,productSalary = 0,infaSalary = 0,salesSalary = 0;
        int hrCount = 0,financCount = 0,securityCount = 0,productCount = 0,infraCount = 0,salesCount = 0;
        double hravg = 0,financAvg = 0,securityAvg = 0,productAvg = 0,infraAvg = 0,salesAvg = 0;
        for(employee1 a : emp){
            if(a.getDepartment().equalsIgnoreCase("hr")){
                   hrSalary += a.getSalary();
                   hrCount++;
            }
        }
        for(employee1 a : emp){
            if(a.getDepartment().equalsIgnoreCase("Account And Finance")){
                financSalary += a.getSalary();
                financCount++;
            }
        }
        for(employee1 a : emp){
            if(a.getDepartment().equalsIgnoreCase("Security And Transport")){
                securitySalary += a.getSalary();
                securityCount++;
            }
        }
        for(employee1 a : emp){
            if(a.getDepartment().equalsIgnoreCase("Product Development")){
               productSalary += a.getSalary();
                productCount++;
            }
        }
        for(employee1 a : emp){
            if(a.getDepartment().equalsIgnoreCase("Infrastructure")){
                infaSalary += a.getSalary();
                infraCount++;
            }
        }
        for(employee1 a : emp){
            if(a.getDepartment().equalsIgnoreCase("Sales And Marketing")){
                salesSalary += a.getSalary();
                salesCount++;
            }
        }
        Map<String,Double> employeesList = new HashMap<>();
        for (employee1 i:
             emp) {

            if(i.getDepartment().equalsIgnoreCase("hr")){
                hravg = hrSalary/hrCount;
                employeesList.put(i.getDepartment(),hravg);
            }
            if(i.getDepartment().equalsIgnoreCase("Account And Finance")){
                financAvg = financSalary/financCount;
                employeesList.put(i.getDepartment(),financAvg);
            }
            if(i.getDepartment().equalsIgnoreCase("Security And Transport")){
                securityAvg = securitySalary/securityCount;
                employeesList.put(i.getDepartment(),securityAvg);
            }
            if(i.getDepartment().equalsIgnoreCase("Product Development")){
                productAvg = productSalary/productCount;
                employeesList.put(i.getDepartment(),productAvg);
            }
            if(i.getDepartment().equalsIgnoreCase("Infrastructure")){
                infraAvg = infaSalary/infraCount;
                employeesList.put(i.getDepartment(),infraAvg);
            }
            if(i.getDepartment().equalsIgnoreCase("Sales And Marketing")){
                salesAvg = salesSalary/salesCount;
                employeesList.put(i.getDepartment(),salesAvg);
            }
        }
        for (Map.Entry<String,Double> entry : employeesList.entrySet()) {
            System.out.println("Department : " + entry.getKey() + " AvgSalary :" + entry.getValue());
        }

    }
    //8 : Get the details of youngest male employee in the product
    // 15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
    public static  void youngMale(List<employee1> emp){
        int young = Integer.MAX_VALUE;
        String name = null;
        int old = 10; // assumption
        for (employee1 a : emp) {
            //System.out.println("Checking employee: " + a.getName() + ", Age: " + a.getAge() + ", Gender: " + a.getGender() + ", Department: " + a.getDepartment());
            if (a.getDepartment().equalsIgnoreCase("Product Development") && a.getGender().equalsIgnoreCase("male") && a.getAge() < young) {
                if(a.getAge() < young){
                    young = a.getAge();
                    name = a.getName();
                }
            }
        }
        System.out.println("Youngest employee : "+name+" age "+young);

        for(employee1 b : emp){
            if(b.getAge() >= old){
                old = b.getAge();
                name = b.getName();
            }
        }
        System.out.println("Oldest employee : "+name+" age "+old);
    }

    // 9 : Who has the most working experience in the organization?
    public static void experienceEmployee(List<employee1> emp){
        int experience = Integer.MAX_VALUE;
        String name1 = "";
        for(employee1 i : emp ){
            if(i.getYear() < experience){
                experience = i.getYear() ;
                name1 = i.getName();
            }
        }
        System.out.println("Most experienced person : " + name1);
    }
    // 10 : How many male and female employees are there in the sales
    public static void employeeSales(List<employee1> emp){
        int count = 0;
        int count1 = 0;
        for(employee1 i : emp){
            if(i.getDepartment().equalsIgnoreCase("Sales And Marketing") & i.getGender().equalsIgnoreCase("male")){
                count++;
            }
            if(i.getDepartment().equalsIgnoreCase("Sales And Marketing") & i.getGender().equalsIgnoreCase("female")){
                count1++;
            }
        }
        System.out.println(count+" Male Employee are there in sales");
        System.out.println(count1 +" Female Employee are there in sales");
    }
    // 14 : Separate the employees who are younger or equal to 25 years from
    public static void youngerThan25(List<employee1> emp){
        System.out.println("employees below age 25 : ");
        for(employee1 i : emp){
            if(i.getAge() <= 25){
                System.out.println("Name : "+i.getName()+" age : "+i.getAge());
            }
        }
    }



    public static void main(String[] args) {
        List<employee1> emp = new ArrayList<>();
        emp.add(new employee1(111, "Vishnu Priya", 32, "Female", "HR", 2011, 25000.0));
        emp.add(new employee1(122, "Vinay Raj", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        emp.add(new employee1(133, "Avinash Reddy", 29, "Male", "Infrastructure", 2012, 18000.0));
        emp.add(new employee1(144, "Bhanu Prasad", 28, "Male", "Product Development", 2014, 32500.0));
        emp.add(new employee1(155, "Aish Roy", 27, "Female", "HR", 2013, 22700.0));
        emp.add(new employee1(166, "Raj Vignesh", 43, "Male", "Security And Transport", 2016, 10500.0));
        emp.add(new employee1(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        emp.add(new employee1(188, "Chandra Mouli", 31, "Male", "Product Development", 2015, 34500.0));
        emp.add(new employee1(199, "Shilpa Shetty", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        emp.add(new employee1(200, "Kumar Raja", 38, "Male", "Security And Transport", 2015, 11000.5));
        emp.add(new employee1(211, "Ameen Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        emp.add(new employee1(222, "Sunil Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        emp.add(new employee1(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        emp.add(new employee1(244, "Shankar Dada", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        emp.add(new employee1(255, "Alia Butt", 23, "Male", "Infrastructure", 2018, 12700.0));
        emp.add(new employee1(266, "Santhi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        emp.add(new employee1(277, "Sunil Shetty", 31, "Male", "Product Development", 2012, 35700.0));

        //average age of employees
        avgAgeAvgSalaryCount(emp);
        // print all departments
        dep(emp);
        //the highest pay output Q4
        highestSalary(emp);
        // employees joined after 2015
        joinedAfter(emp);
        //no of employees in department
        countOfEmployeesInDepartment(emp);
        //youngest male
        youngMale(emp);
        //employees in sales
        employeeSales(emp);
        //employess below 25 years
        youngerThan25(emp);

        experienceEmployee(emp);
        salaryOfDepartment(emp);
    }
}
