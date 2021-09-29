class BankAccount{
    //instance variables/ attributes
    private double balance;
    private String name;
    private int accNum;
    private String password;

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

    public void setBalance(int newBalance){
        this.balance = newBalance;
    }
    // getter methods

    public String getName(){
        return this.name;
    }

    public String getPass(){
        return this.password;
    }

    public int getAccountNumber(){
        return this.accNum;
    }

    public double getBalance(){
        return this.balance;
    }
    public String toString(){
        return "Name: "+this.name+"\n"+"Password: "+this.password+"\n"+"Account Number: "+this.accNum+"\n"+"Balance: "+this.balance+"\n";
    }

} // end of Bank account class


/// MAIN PUBLIC CLASS

public class BankAccountTest{
    public static void main (String[] args){
        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount(200.0, "Bill", 123456, "B56");
        System.out.println(b1.toString());
        System.out.println(b2.toString());
    
    } // end of main
} // end of bank account test class