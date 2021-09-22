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

    // BankAccount b1 = new BankAccount();
    // BankAccount b2 = new BankAccount(200.0, "Bill", 123456, "B56")
}