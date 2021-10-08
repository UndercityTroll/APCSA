import java.util.*;

class EmployeeAccount{
    //instance variables/ attributes
    private int employeeNumber;
    private double grossPay;
    private double stateTax;
    private double federalTax;
    private double fica;
    private double netPay;

    // constructors -> the exact same name as the class name
    public EmployeeAccount(){
        employeeNumber;
        grossPay=0;
        stateTax=0;
        federalTax=0;
        fica=0;
        netPay=0;
    }

    public EmployeeAccount(int employeeNumber, double grossPay, double stateTax, double federalTax, double fica, double netPay){
        this.employeeNumber = employeeNumber;
        this.grossPay = grossPay;
        this.stateTax = stateTax;
        this.federalTax = federalTax;
        this.fica = fica;
        this.netPay = netPay;
    }

    // setter methods

    public void setEmployeeNumber(int newNumber){
        if (newNumber >= 0){
            employeeNumber = newNumber;
        }
    }

    public void setGrossPay(double newGrossPay){
        if (newGrossPay>= 0){
            grossPay = newGrossPay;
        }
    }
    public void setStateTax(double newStateTax){
        if (newStateTax>=0){
            stateTax = newStateTax;
        }
    }
    public void setFederalTax(double newFederalTax){
        if (newFederalTax>=0){
            federalTax = newFederalTax;
        }
    }
    public void setFica(double newFica){
        if (newFica>=0){
            fica = newFica;
        }
    }

    // getter methods

    public int getEmployeeNum(){
        return employeeNumber;
    }
    public double getGrossPay(){
        return grossPay;
    }
    public double getStateTax(){
        return stateTax;
    }
    public double getFederalTax(){
        return federalTax;
    }
    public double getFica(){
        return fica;
    }
    public String toString(){
        return "Employee Number: "+employeeNumber+"\n"+"Gross Pay: $"+grossPay+"\n"+"State Tax: "+stateTax+"%"+"\n"+"Federal Tax: "+federalTax+"%"+"\n"+"Fica: $"+fica;
    }

    public int calculateNetPay(){
        if ((stateTax*grossPay+federalTax*grossPay+fica)>grossPay){
            return -1;
        } else{
            return (grossPay-stateTax-federalTax-fica)
        }
    }

} // end of Employee Account account class


/// MAIN PUBLIC CLASS

public class Payroll{
    public static void main (String[] args){
        //BankAccount b1 = new BankAccount();
        //BankAccount b2 = new BankAccount(200.0, "Bill", 123456, "B56");
        
        EmployeeAccount pain = new EmployeeAccount();

        Scanner console = new Scanner(System.in);
        int choice;
        boolean run = true;
        boolean innerRun = true;

        while (run){
            // header
            System.out.println("Welcome to the hell");
            System.out.println("Please enter one of the following numbers");
            System.out.println("0. Exit");
            System.out.println("1. Create a new account");
            System.out.print("Enter Number: ");
            choice = console.nextInt();
            System.out.println();

            // main if loop
            if(choice==0){
                run = false;
                System.out.println("Thank you for whatever this was");
            } else if (choice==1){
                while (innerRun = true){
                    System.out.println("");
                }
             else{
                System.out.println("Please enter valid input");
            }
        }

    } // end of main
} // end of bank account test class