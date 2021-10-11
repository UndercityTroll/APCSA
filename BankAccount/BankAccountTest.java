import java.util.*;

class BankAccount{
    //instance variables/ attributes
    private double balance;
    private String name;
    private int accNum;
    private String password;
    // constants
    public static double OVERDRAWN_PENALTY = 20;

    // constructors -> the exact same name as the class name
    public BankAccount(){
        name = "";
        accNum = 000000;
        balance = 0.0;
        password = "";
    }

    public BankAccount(double aBalance, String name, int accNum, String aPassword){
        this.name = name;
        this.accNum = accNum;
        balance = aBalance;
        password = aPassword;
    }

    // setter methods

    public void setName(String newName){
        this.name = newName;
    }

    public void setNum(int newNum){
        this.accNum = newNum;
    }

    public void setPass(String newpass){
        this.password = newpass;
    }

    public void setBalance(double newBalance){
        this.balance = newBalance;
    }
    // getter methods

    public String getName(){
        return name;
    }

    public String getPass(){
        return password;
    }

    public int getAccountNumber(){
        return accNum;
    }

    public double getBalance(){
        return balance;
    }
    public String toString(){
        return "Name: "+this.name+"\n"+"Password: "+this.password+"\n"+"Account Number: "+this.accNum+"\n"+"Balance: "+this.balance+"\n";
    }

    // other methods
    public String withdraw(double amount, String pass){
        if (pass == password){
            balance -= amount;
            if (balance<0){
                balance -= OVERDRAWN_PENALTY;
                return ("Overdraft");
            } else {
                return ("Password valid; withdrawl accepted");
            }
        } else {
            return ("Password invalid; withdrawl declined");
        }
    }

    public String deposit(double amount, String pass){
        if (pass==password) {
            balance+=amount;
            return ("Password valid; deposit accepted");
        } else {
            return ("Password invalid; deposit declined");
        }
    }

} // end of Bank account class


/// MAIN PUBLIC CLASS

public class BankAccountTest{
    public static void main (String[] args){
        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount(200.0, "Bill", 123456, "B56");
        //System.out.println(b1.toString());
        //System.out.println(b2.toString());


        // cringe creation of class with user input
        Scanner console = new Scanner(System.in);

        System.out.println("Lets create some debt for you!");
        System.out.print("What is your name: ");
        String name = console.nextLine();
        System.out.println();

        System.out.print("Set a password: ");
        String pass = console.nextLine();
        System.out.println();

        System.out.print("How much cash money u got: $");
        double bal = console.nextDouble();
        System.out.println();

        BankAccount b3 = new BankAccount(bal, name, (int)(Math.random()*999999),pass);
        System.out.println("awesome your path to deficit is in way!");

        System.out.println("Available Funds: $"+b3.getBalance());
        System.out.print("How much money do you want to withdraw: ");
        int withdraw = console.nextInt();
        System.out.println();

        System.out.print("Please enter password: ");
        String tempPass = console.nextLine();
        System.out.println(b3.withdraw(withdraw,tempPass));
        System.out.println("New Available Funds: $"+b3.getBalance());

    } // end of main
} // end of bank account test class