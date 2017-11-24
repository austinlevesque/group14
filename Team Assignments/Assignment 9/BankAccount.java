public class BankAccount extends Object implements Measurable {
	public static final double ACCOUNT_FEE = 5.50;
	private double balance;
	private Customer accountHolder;
	private int accountID;
	
	public BankAccount(Customer aCustomer){
		this(0.0, aCustomer);
	}
	
	public BankAccount(double initialBalance, Customer aCustomer){
		super();
		balance = initialBalance;
		accountHolder = new Customer(aCustomer);
	}
	
	public BankAccount(BankAccount toCopy) {
		balance = toCopy.balance;
		accountHolder = toCopy.accountHolder;
	}
	
	public double getMeasure(){
		return balance;
	}
	
	protected void setBalance(double newBalance){
		balance = newBalance;
	}
	
	public void monthEnd(){
		// Withdraw even if the result is an overdraft.
		setBalance(balance - ACCOUNT_FEE);
	}

	public boolean equals(BankAccount other){
		boolean isEqual = false;
		if (other instanceof BankAccount) {
			BankAccount b = (BankAccount)other;
			if (accountID == b.accountID) {
				isEqual = true;
			} 
		}
		return isEqual;
		
	}
	
	public String toString() {
		return accountHolder.toString() + ":" + balance;
	}
	
	public Customer getAccountHolder(){
		return new Customer(accountHolder);
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
		}
	}
	
	public void withdraw(double amount) throws InsufficientFundsException {
		if (amount > 0 && amount <= balance){
			balance -= amount;
		}else {
			throw new InsufficientFundsException();
		}
	}
	
	public void transfer(double amount, BankAccount toAccount) throws InsufficientFundsException  {
		withdraw(amount);
		toAccount.deposit(amount);
	}
}