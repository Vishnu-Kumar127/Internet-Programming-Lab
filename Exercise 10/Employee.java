package Exercise_10;

import java.util.Date;

public class Employee {
    private String name;
    private String department;
    private double salary;
    private Date hireDate;

    public Employee(String name, String department, double salary, Date hireDate) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.hireDate = hireDate;
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

    public Date getHireDate() {
        return hireDate;
    }
}