import static org.junit.Assert.*;

import org.junit.Test;

public class BankAccountTest{
    
	// testing constructors
	@Test
    public void test_ConstructorWithAccountHolder() {
        BankAccount b = new BankAccount(new Customer("test1", 1));
		assertEquals("Unexpected balance",0.0,b.getBalance(), 0.00001);
		assertEquals("Unexpected customer name", "test1", b.getAccountHolder().getName());
		assertEquals("Unexpected customer id", 1, b.getAccountHolder().getID());
    }
    
	@Test
    public void test_ConstructorWithStartBalance() {
        BankAccount b = new BankAccount(12.34, new Customer("test2",2));
		assertEquals("Unexpected balance",12.34,b.getBalance(), 0.00001);
		assertEquals("Unexpected customer name", "test2", b.getAccountHolder().getName());
		assertEquals("Unexpected customer id", 2, b.getAccountHolder().getID());
    }
    
	@Test
    public void test_ConstructWithNegativeBalance() {
        BankAccount b = new BankAccount(-12.34, null);
		assertEquals("Unexpected balance",-12.34,b.getBalance(), 0.00001);
    }

	@Test
    public void test_CopyConstructor_zeroBalance() {
		Customer c = new Customer("CopyTest", 3);
        BankAccount b = new BankAccount(c);
        BankAccount copy = new BankAccount(b);
		assertEquals("Unexpected balance",0.0,copy.getBalance(), 0.00001);
		assertEquals("Copy and orginal should not be the same object", false, b == copy);
		assertEquals("Copy and orginal should reference same customer", c, b.getAccountHolder());
    }

	@Test
    public void test_CopyConstructor_positiveBalance() {
        BankAccount b = new BankAccount(12345.61, null);
        BankAccount copy = new BankAccount(b);
		assertEquals("Unexpected balance",12345.61,copy.getBalance(), 0.00001);
		assertEquals("Copy and orginal should not be the same object", false, b == copy);
    }

	@Test
    public void test_CopyConstructor_negativeBalance() {
        BankAccount b = new BankAccount(-12345.61, null);
        BankAccount copy = new BankAccount(b);
		assertEquals("Unexpected balance",-12345.61,copy.getBalance(), 0.00001);
		assertEquals("Copy and orginal should not be the same object", false, b == copy);
    }

	
	// Testing deposit
	@Test
    public void test1(){
        BankAccount b = new BankAccount(((Customer)null));
        assertEquals("Expected initial balance to be 0.0", 0.0, b.getBalance(), 0.0);
    }
    
	@Test
    public void test2() {
        BankAccount b = new BankAccount(((Customer)null));
        b.deposit(10.25);
        assertEquals("Deposited 10.25.", 10.25, b.getBalance(), 0.0);
    }
    
	@Test
    public void test3() {
        BankAccount b = new BankAccount(((Customer)null));
        b.deposit(10.25);
        b.deposit(21945.67);
        assertEquals("Deposited first 10.25 then 21945.67", 21955.92, b.getBalance(), 0.0);
    }
    
	@Test
    public void test4() {
        BankAccount b = new BankAccount(((Customer)null));
        b.deposit(-10.25);
        assertEquals("Tried to deposit a negative amount", 0.00, b.getBalance(), 0.0);
    }
        
    // testing withdraw
	@Test
    public void test5() {
        BankAccount b = new BankAccount(((Customer)null));
        b.deposit(500.00);
        b.withdraw(44.25);
        assertEquals("Withdrew 44.25 after depositing 500.00", 455.75, b.getBalance(), 0.0);
    }
    
	@Test
    public void test6() {
        BankAccount b = new BankAccount(((Customer)null));
        b.deposit(399.99);
        b.withdraw(399.99);
        assertEquals("Withdrew 399.99 after depositing 399.99", 0.0, b.getBalance(), 0.0);
    }
    
	@Test
    public void test7() {
        BankAccount b = new BankAccount(((Customer)null));
        b.deposit(5.00);
        b.withdraw(5.01);
        assertEquals("Withdrew 5.01 after depositing 5.00", 5.00, b.getBalance(), 0.0);
    }
    
    // testing transfer
	@Test
    public void test11() {
        BankAccount b = new BankAccount(((Customer)null));
        b.deposit(12345.67);
        BankAccount b2 = new BankAccount(((Customer)null));
        b.transfer(12.34, b2);
        assertEquals("After transfer, expected from account to go from balance 12345.67 to 12334.33", 12333.33, b.getBalance(), 0.0);
        assertEquals("After transfer, expected to account to go from balance 0.00 to 12.34", 12.34, b2.getBalance(), 0.0);
    }
    
	@Test
    public void test12() {
        BankAccount b = new BankAccount(((Customer)null));
        b.deposit(12345.67);
        BankAccount b2 = new BankAccount(((Customer)null));
        b.transfer(12345.67, b2);
        assertEquals("After transfer, expected from account to go from balance 12345.67 to 0.00", 0.0, b.getBalance(), 0.0);
        assertEquals("After transfer, expected to account to go from balance 0.00 to 12345.67", 12345.67, b2.getBalance(), 0.0);
    }
    
	@Test
    public void test13() {
        BankAccount b = new BankAccount(((Customer)null));
        b.deposit(12345.67);
        BankAccount b2 = new BankAccount(((Customer)null));
        b.transfer(12345.68, b2);
        assertEquals("Expected balance in from account unchanged (overdraft).", 12345.67, b.getBalance(), 0.0);
        assertEquals("Expected balance in to account unchanged (overdraft)", 0.00, b2.getBalance(), 0.0);
    }
}
