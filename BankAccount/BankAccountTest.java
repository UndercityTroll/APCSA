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
        thpassword = aPassword;
    }

    // setter methods

    public void setName(String newName){
        name = newName;
    }

    public void setNum(int newNum){
        accNum = newNum;
    }

    public void setPass(String newpass){
        password = newpass;
    }

    public void setNum(int newBalance){
        balance = newBalance;

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
        return this.Balance;
    }

    // BankAccount b1 = new BankAccount();
    // BankAccount b2 = new BankAccount(200.0, "Bill", 123456, "B56")
}