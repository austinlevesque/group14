public class BankAccount{
    
    //variables
    double balance;
    Customer accountHolder;
    BankAccount account;
	
    //Constructors
    /** Default constructor
    * takes no arguments and runs no lines of code
    */
    public BankAccount(){
    }
    
    /** Customer constructor
    * @param acc - A Customer object that takes the same (String,ID) parameters that the class requires
    *
    */
    public BankAccount(Customer acc){
        accountHolder = new Customer(acc);
    }
	
    /** Full constructor
    * @param bal - double balance that declares the initial balance of the BankAccount when it's created
    * @param acc - Customer object taking (String,ID)
    */
    public BankAccount(double bal, Customer acc){
        balance = bal;
        accountHolder = acc;
    }
    
    /** Copy Constructor
    * @param accountToCopy - BankAccount object to copy
    */
    BankAccount(BankAccount accountToCopy){
		setBalance(accountToCopy.balance);
    }
    
    //methods
    /**
    * @returns the balance of the object as a double
    */
    public double getBalance(){
        return balance;
    }

	/**
	* @param bal - double balance that you want to change the new balance to
	* @returns void (nothing)
	*/
    public void setBalance(double bal){
		this.balance = bal;
    }
	
	/**
	* @returns accountHolder - the accountHolder customer object of the bankaccount object
	*/
	public Customer getAccountHolder() {
        return accountHolder;
    }
    
	/** takes an amount and adds that to the bank account it's called with
	* @param amount - double that you wish to deposit into the account
	* @returns the balance + the amount (as a double) inputted when the method is called
	*/
    public double deposit(double amount) {
        if(amount<0){ //if a negative number is deposited
            return 0; //deposit nothing
        }
        return ((this.balance)+=amount);   
    } 

	/** takes an amount and removes that from the bank account it's called with
	* @param amount - double that you wish to withdraw
	* @returns all of the money in the bank account if you try to overdraw
	* @returns the amount in the bank account - the amount you withdraw
	*/
    public double withdraw (double amount) {
        if(amount>this.getBalance()){ 
		//if withdrawing more money than held
            return this.getBalance(); 
			//gives as much as possible without overdrawing
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
}
