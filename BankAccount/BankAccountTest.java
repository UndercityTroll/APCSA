import java.util.*;

// Vikram Murugan
// Creates a class of Bank Account which will allow different accounts to be compared based on size

class BankAccount implements Comparable<BankAccount>{
    //instance vars
    private double balance;
    private String name;
    private int acctNum;
    private String password;
    private static final double OVERDRAW_PENALTY = 20.0;

    //default constructor
    public BankAccount() {
        balance = 0;
        name = null;
        acctNum = 0;
        password = null;
    }

    public BankAccount(String name, double balance, int acctNum, String password) {
        this.balance = balance;
        this.name = name;
        this.acctNum = acctNum;
        this.password = password;
    }

    //mutators
    public void setBalance(double balance){
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNumber(int acctNum) {
        this.acctNum = acctNum;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //accesors
    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
    public int getAccountNumber() {
        return acctNum;
    }

    public String getPassword() {
        return password;
    }

    //toString
    public String toString(){
        return "\nName: " + name + "\nBalance: " + balance + "\nAcctNum: " + acctNum + "\nPassword: " + password;
    }

    //compareTo
    public int compareTo(BankAccount other){
        if (this.balance > other.balance) {
            return 1;
        } else if (this.balance < other.balance) {
            return -1;
        } else {
            return 0;
        }
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void deposit(double amount, String password) {
        if (password.equals(this.password)) {
            balance += amount;
        } else {
            System.out.println("password invalid; deposit declined");
        }
    }

    public void withdraw(double amount, String Password) {
        if (password.equals(this.password)) {
            balance -= amount;
            if (balance < 0) {
                System.out.println("Accouunt Overdrawn. $20 deducted");
                balance -= OVERDRAW_PENALTY;
            }
        } else {
            System.out.println("password invalid; withdrawal declined");
        }
    }
}

public class BankAccountTest {
    public static void main(String[] args){
        ArrayList<BankAccount> accountList = new ArrayList<>();

        accountList.add(new BankAccount("Sus", 100000, 1234, "asdfhklj"));
        accountList.add(new BankAccount("Sus #2", 50000, 5678, "asfd"));
        accountList.add(new BankAccount("Sus #3", 75000, 910, "qwerqwerq"));

        System.out.println("Accounts: " + accountList);
        Collections.sort(accountList);
        System.out.println("Accounts: " + accountList);

        /*Scanner reader = new Scanner(System.in);
        BankAccount account = new BankAccount("sus", 100.0, 12414142, "asdfasdf");

        System.out.println(account);
        System.out.print("What is your deposit? ");
        double deposit = reader.nextDouble();
        System.out.print("What is your password? ");
        account.deposit(deposit, reader.next());
        System.out.println(account);

        System.out.print("What is your withdrawal? ");
        double withdrawal = reader.nextDouble();
        System.out.print("What is your password? ");
        account.deposit(withdrawal, reader.next());
        System.out.println(account);

		System.out.print("What is your name? ");
		account.setName(reader.next());
		System.out.print("What is your Balance? ");
		account.setBalance(reader.nextDouble());
		System.out.print("What is your Account Number? ");
		account.setAccountNumber(reader.nextInt());
		System.out.print("What is your Password? ");
		account.setPassword(reader.next());

		System.out.println();
		System.out.println(account);

		System.out.print("How much money do you want to add? ");
		account.deposit(reader.nextDouble());
		System.out.println("Balance: " + account.getBalance());

		System.out.print("How much money do you want to remove? ");
		account.withdraw(reader.nextDouble());
		System.out.println("Balance: " + account.getBalance());

		System.out.println(account);*/

    }
}