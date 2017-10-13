public class Test {
	public static void main(String[] args){
		Customer c1 = new Customer("Joe Smith", 123);
		BankAccount b = new BankAccount(50.0, c1);
		Customer c2 = b.getAccountHolder();
		c2.setName("Ana Bell");
		
		System.out.println(c1.getName());
	}
}