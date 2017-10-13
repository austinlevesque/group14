public class BankAccount{
    
    double balance;
    Customer accountHolder;
    BankAccount copy = new BankAccount();
    
    //default constructor
    public BankAccount(){
        balance = 0;
        accountHolder = null;
    }
    
    public Customer getAccountHolder() {
        return accountHolder;
    }
    /*
	public BankAccount(Customer acc){
        accountHolder = acc;
    }
    */
	
    public BankAccount(double bal, Customer acc){
        balance = bal;
        accountHolder = acc;
    }
    
    //copy constructor
    public BankAccount(BankAccount accountToCopy){
        copy = accountToCopy;
    }
    
    //methods
    public double getBalance(){     //returns object balance
        return balance;
    }
    
    public double deposit(double amount) {      //takes an amount and adds that to the bank account it's called with
        //balance += amount;
        //double b = this.getBalance();
        if(amount<0){ //if a negative number is deposited
            return 0; //deposit nothing
        }
        return ((this.balance)+=amount);   
    } 

    public double withdraw (double amount) {    //takes an amount and removes that from the bank account it's called with
        if(amount>this.getBalance()){ //if withdrawing more money than held
            return this.getBalance(); //gives as much as possible without overdrawing
        }
        return ((this.balance)-=amount);
    }
    
    public void transfer (double amount, BankAccount account) { //takes an amount and the bank account to transfer to
        //moves the amount from a bank account to the account in the argument
        //eg b1.transfer(50.0, b2) will move 50 dollars from b1 to b2
        //b1.(50.0,b1) will work but is pointless
        if(amount>this.getBalance()){ //if transferring more money than held
            amount = 0; //transfer will decline
        }
        double w = this.withdraw(amount);
        double d = account.deposit(amount);
    }
    
    public static void main(String[] args) {
        //Would require constructors which get declined by the test class
        
        /*//BankAccount b1 = new BankAccount(100.0, 20.0);    //bank account object named 'b1'
        BankAccount b = new BankAccount(new Customer("test1", 1));
        */
		/*
        BankAccount b2 = new BankAccount(6000.0);   //bank account object named 'b2'    
        System.out.println("Bank Account 1 balance: $" +b1.getBalance()+"\nBank Account 2 balance: $"+b2.getBalance());
        b1.deposit(50.0);
        System.out.println("Bank Account 1 balance: $" +b1.getBalance()+"\nBank Account 2 balance: $"+b2.getBalance());
        b1.withdraw(75.0);
        System.out.println("Bank Account 1 balance: $" +b1.getBalance()+"\nBank Account 2 balance: $"+b2.getBalance());
        b1.transfer(175,b2);
        System.out.println("Bank Account 1 balance: $" +b1.getBalance()+"\nBank Account 2 balance: $"+b2.getBalance());
		*/
    }
}
