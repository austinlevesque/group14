import java.awt.event.*;
import java.io.*;

public class BankApp implements ActionListener {
	private BankGUI gui;
	private BankAccount account;
	File file = new File("BankAccountInfo.txt");
	PrintWriter pw;
	boolean action = true;
	public BankApp() {
		
		try {
			account = new BankAccount(new Customer("test",1));
			gui = new BankGUI(this);
			gui.pack();
			gui.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void actionPerformed(ActionEvent event){
		if (event.getActionCommand().equals("deposit")){
			double amount = Double.parseDouble(gui.getAmount());
			account.deposit(amount);
			//added this
			try {
				fileCreator();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (event.getActionCommand().equals("withdraw")){
			double amount = Double.parseDouble(gui.getAmount());
			
			//added this, withdrawl doesnt work.
			try {
				fileCreator();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				account.withdraw(amount);
			} catch (InsufficientFundsException ife) {
				gui.setError("Insufficient Funds in Account");
			}
		}
		double balance = account.getBalance();
		gui.clear();
		gui.setBalance("" + balance);
	}
	
	//added this
	public void fileCreator() throws IOException {
		
		if(!file.exists()) {
			file.createNewFile();
		}
		else {
			pw = new PrintWriter(file);
			pw.println("Balance: " + account.getBalance());
			pw.println("Name: " + account.getAccountHolder().getName());
			pw.println("ID#: " + account.getAccountHolder().getID());
			pw.close();
		}

	}

	
    public static void main(String[] args) throws IOException {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	BankApp app = new BankApp();
            }
        });
    }
	

}
