import static org.junit.Assert.*;

import org.junit.Test;

public class BankAccountTest {
        
    private static int accountCounter = 0;
    
	@Test
    public void test_defaultConstructor(){
        BankAccount b = new BankAccount();
        accountCounter++;
        assertEquals("Unexpected balance", 0.0,b.getBalance(), 0.00001);
        assertEquals("Unexpected account number", accountCounter, b.getAccountNumber());
    }

	@Test
    public void test_ConstructorWithStartBalance() {
        BankAccount b = new BankAccount(12.34);
        accountCounter++;
		assertEquals("Unexpected balance",12.34,b.getBalance(), 0.00001);
		assertEquals("Unexpected account number", accountCounter, b.getAccountNumber());
    }
    
	@Test
    public void test_ConstructWithNegativeBalance() {
        BankAccount b = new BankAccount(-12.34);
        accountCounter++;
		assertEquals("Unexpected balance",-12.34,b.getBalance(), 0.00001);
		assertEquals("Unexpected account number", accountCounter, b.getAccountNumber());
    }

	@Test
    public void test_ConstructWithZeroBalance() {
        BankAccount b = new BankAccount();
        accountCounter++;
		assertEquals("Unexpected balance",0.0,b.getBalance(), 0.00001);
		assertEquals("Unexpected account number", accountCounter, b.getAccountNumber());
    }

	@Test
    public void test_CopyConstructor_zeroBalance() {
        BankAccount b = new BankAccount();
        accountCounter++;
        BankAccount copy = new BankAccount(b);
		assertEquals("Unexpected balance",0.0,copy.getBalance(), 0.00001);
		assertEquals("Unexpected account number", accountCounter, copy.getAccountNumber());
		assertEquals("Copy and orginal should not be the same object", false, b == copy);
    }

	@Test
    public void test_CopyConstructor_positiveBalance() {
        BankAccount b = new BankAccount(12345.61);
        accountCounter++;
        BankAccount copy = new BankAccount(b);
		assertEquals("Unexpected balance",12345.61,copy.getBalance(), 0.00001);
		assertEquals("Unexpected account number", accountCounter, copy.getAccountNumber());
		assertEquals("Copy and orginal should not be the same object", false, b == copy);
    }

	@Test
    public void test_CopyConstructor_negativeBalance() {
        BankAccount b = new BankAccount(-12345.61);
        accountCounter++;
        BankAccount copy = new BankAccount(b);
		assertEquals("Unexpected balance",-12345.61,copy.getBalance(), 0.00001);
		assertEquals("Unexpected account number", accountCounter, copy.getAccountNumber());
		assertEquals("Copy and orginal should not be the same object", false, b == copy);
    }
    
	@Test
    public void test_defaultConstructor_multipleAccounts() {
        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount();
        BankAccount b3 = new BankAccount();
        BankAccount b4 = new BankAccount();
        BankAccount b5 = new BankAccount();
		assertEquals("Unexpected balance for account 1",0.0,b1.getBalance(), 0.00001);
		assertEquals("Unexpected account number for 1",accountCounter + 1, b1.getAccountNumber());
		assertEquals("Unexpected balance for account 2",0.0,b2.getBalance(), 0.00001);
		assertEquals("Unexpected account number for 2",accountCounter + 2, b2.getAccountNumber());
		assertEquals("Unexpected balance for account 3",0.0,b3.getBalance(), 0.00001);
		assertEquals("Unexpected account number for 3",accountCounter + 3, b3.getAccountNumber());
		assertEquals("Unexpected balance for account 4",0.0,b4.getBalance(), 0.00001);
        assertEquals("Unexpected account number for 4",accountCounter + 4, b4.getAccountNumber());
		assertEquals("Unexpected balance for account 5",0.0,b5.getBalance(), 0.00001);
        assertEquals("Unexpected account number for 5",accountCounter + 5, b5.getAccountNumber());
        accountCounter += 5;
    }
    
	@Test
    public void test_constructWithPositiveBalance_multipleAccounts() {
        BankAccount b1 = new BankAccount(10.5);
        BankAccount b2 = new BankAccount(7.5);
        BankAccount b3 = new BankAccount(1.2);
        BankAccount b4 = new BankAccount(123.45);
        BankAccount b5 = new BankAccount(65487.4567);
		assertEquals("Unexpected balance for account 1",10.5,b1.getBalance(), 0.00001);
        assertEquals("Unexpected account number for 1",accountCounter + 1, b1.getAccountNumber());
        assertEquals("Unexpected balance for account 2",7.5,b2.getBalance(), 0.00001);
        assertEquals("Unexpected account number for 2",accountCounter + 2, b2.getAccountNumber());
		assertEquals("Unexpected balance for account 3",1.2,b3.getBalance(), 0.00001);
        assertEquals("Unexpected account number for 3",accountCounter + 3, b3.getAccountNumber());
		assertEquals("Unexpected balance for account 4",123.45,b4.getBalance(), 0.00001);
        assertEquals("Unexpected account number for 4",accountCounter + 4, b4.getAccountNumber());
		assertEquals("Unexpected balance for account 5",65487.4567,b5.getBalance(), 0.00001);
        assertEquals("Unexpected account number for 5",accountCounter + 5, b5.getAccountNumber());
        accountCounter += 5;
    }
    
	@Test
    public void test_CopyConstructorAfterCreatingMultipleAccounts() {
        BankAccount b1 = new BankAccount(10.5);
        BankAccount b2 = new BankAccount(7.5);
        BankAccount b3 = new BankAccount(1.2);
        BankAccount b4 = new BankAccount(123.45);
        BankAccount b5 = new BankAccount(65487.4567);
        BankAccount copy = new BankAccount(b3);
		assertEquals("Unexpected balance",1.2,copy.getBalance(), 0.00001);
		assertEquals("Unexpected account number", accountCounter + 3, copy.getAccountNumber());
        assertEquals("Copy and orginal should not be the same object", false, b3 == copy);
        accountCounter += 5;
    }
    
    
	@Test
    public void test_toString_zeroBalance() {
        BankAccount b = new BankAccount();
        accountCounter++;
		assertEquals(accountCounter + ",0.00", b.toString());
    }
    
	@Test
    public void test_toString_moreThan2PointsPrecisionBalance() {
        BankAccount b = new BankAccount(10.1567);
        accountCounter++;
		assertEquals(accountCounter + ",10.16", b.toString());
    }
        
	@Test
    public void test_equals_afterCopyConstructor() {
        BankAccount b1 = new BankAccount();
        accountCounter++;
        BankAccount b2 = new BankAccount(b1);
		assertEquals("They have same account number (by using copy constructor), so should be considered equal", 
                                true,b1.equals(b2));
    }
    
	@Test
    public void test_equals_Copy_CopyChanged() {
        BankAccount b1 = new BankAccount(10.50);
        accountCounter++;
        BankAccount b2 = new BankAccount(b1);
        b2.deposit(12.34);
		assertEquals("They have same account number (12345), so should be considered equal", 
                                true,b1.equals(b2));
    }
    
	@Test
    public void test_equals_DifferentAccountNumbers() {
        BankAccount b1 = new BankAccount(10.50);
        BankAccount b2 = new BankAccount(10.50);
        accountCounter += 2;
        assertEquals("They have different account numbers, so should be considered unequal", 
                                false,b1.equals(b2));
    }
    
	@Test
    public void test_deposit10ToAccountWithZeroBalance() {
        BankAccount b = new BankAccount();
        accountCounter++;
        b.deposit(10.0);
        assertEquals("Unexpected balance", 10.0,b.getBalance(), 0.00001);
    }
    
	@Test
    public void test_multipleDeposits() {
        BankAccount b = new BankAccount();
        accountCounter++;
        b.deposit(5.00);
        b.deposit(4.56);
        b.deposit(11.90);
        b.deposit(16.00);
        assertEquals("Unexpected balance", 37.46, b.getBalance(), 0.00001);
    }
    
	@Test
    public void test_deposit_NegativeAmount() {
        BankAccount b = new BankAccount();
        accountCounter++;
        b.deposit(-12.45);
        assertEquals("Unexpected balance", 0.0,b.getBalance(), 0.00001);
    }
    
	@Test
    public void test_withdraw_WithdrawLessThanBalance() {
        BankAccount b = new BankAccount(20.00);
        accountCounter++;
        b.withdraw(15.50);
        assertEquals("Unexpected balance", 4.50,b.getBalance(), 0.00001);
    }
    
	@Test
    public void test_withdraw_WithdrawMoreThanBalance() {
        BankAccount b = new BankAccount(15.00);
        accountCounter++;
        b.withdraw(20.0);
        assertEquals("Unexpected balance", 15.00,b.getBalance(), 0.00001);
    }
    
	@Test
    public void test_withdraw_WithdrawEntireBalance() {
        BankAccount b = new BankAccount(5.00);
        accountCounter++;
        b.withdraw(5.00);
        assertEquals("Unexpected balance", 0.00,b.getBalance(), 0.00001);
    }
    
	@Test
    public void test_withdraw_sequenceOfWithdrawals() {
        BankAccount b = new BankAccount(50.00);
        accountCounter++;
        b.withdraw(.5);
        b.withdraw(5.1);
        b.withdraw(20.0);
        assertEquals("Unexpected balance", 24.40,b.getBalance(), 0.00001);
    }
    
	@Test
    public void test_transfer_TransferLessThanBalance() {
		BankAccount b1 = new BankAccount(50.00);
        BankAccount b2 = new BankAccount(546.21);
        accountCounter+=2;
        b1.transfer(15.45,b2);
        assertEquals("Unexpected balance for first account", 34.55,b1.getBalance(), 0.00001);
		assertEquals("Unexpected balance for 2nd account", 561.66,b2.getBalance(), 0.00001);
    }
    
	@Test
    public void test_transfer_TransferEntireBalance() {
        BankAccount b1 = new BankAccount(50.00);
        BankAccount b2 = new BankAccount(546.21);
        accountCounter+=2;
        b1.transfer(50.00,b2);
        assertEquals("Unexpected balance for first account", 0.0,b1.getBalance(), 0.00001);
        assertEquals("Unexpected balance for 2nd account", 596.21,b2.getBalance(), 0.00001);
    }
    
	@Test
    public void test_transfer_TransferMoreThanBalance() {
        BankAccount b1 = new BankAccount(50.00);
        BankAccount b2 = new BankAccount(546.21);
        accountCounter+=2;
        b1.transfer(51.00,b2);
        assertEquals("Unexpected balance for first account", 50.0,b1.getBalance(), 0.00001);
        assertEquals("Unexpected balance for 2nd account", 546.21,b2.getBalance(), 0.00001);
    }
    
}
