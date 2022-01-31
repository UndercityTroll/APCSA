import java.util.*;

class Employee{
    //instance variables/ attributes
    private double salary;
    private String name;

    // constructors -> the exact same name as the class name
    public Employee(){
        name = "";
        salary = 0.0;
    }

    public Employee(double salary, String name){
        this.name = name;
        this.salary = salary;
    }

    // setter methods

    public void setName(String newName){
        this.name = newName;
    }

    public void setSalary(double newSalary){
        this.salary = newSalary;
    }
    // getter methods

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    // to string method
    public String toString(){
        return "Name: "+this.name+"\n"+"Salary: "+this.salary;
    }



} // end of Employee class


/// MAIN PUBLIC CLASS

public class EmployeeTester{
    public static void main (String[] args){
        Employee[] arrayMain = new Employee[3];
        arrayMain[0] = new Employee(200, "Bobby");
        arrayMain[1] = new Employee(300, "Bob");
        arrayMain[2] = new Employee(400, "Bo");

        for (Employee emp: arrayMain){
            System.out.println(emp.toString());
        }
    } // end of main
} // end of salary test class