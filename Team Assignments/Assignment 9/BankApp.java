import java.awt.event.*;
import java.io.*;


public class BankApp implements ActionListener {
	private BankGUI gui;
	private BankAccount account;
	
	//added
	File file = new File("BankAccountInfo.txt");
	boolean fileExist = file.exists();
	BufferedWriter bw;
	
	PrintWriter pw;
	
	public BankApp() {
		account = new BankAccount(new Customer("test",1));
		gui = new BankGUI(this);
		gui.pack();
		gui.setVisible(true);
		
		
		try {
			fileCreator();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//added this
	public void fileCreator() throws IOException {
		
		if(fileExist) {
			BufferedReader br = new BufferedReader(new FileReader("BankAccountInfo.txt"));
			
		}
		else {
			file.createNewFile();
		}
	}
	
	public void fileWriter() throws IOException {
		bw = new BufferedWriter(new PrintWriter(file));
		bw.write("Balance: " + account.getBalance());
		bw.newLine();
		bw.write("Name: " + account.getAccountHolder().getName());
		bw.newLine();
		bw.write("ID#: " + account.getAccountHolder().getID());
		bw.newLine();
		bw.close();
	}

	
	public void actionPerformed(ActionEvent event){
		try {
			if (event.getActionCommand().equals("deposit")){
				double amount = Double.parseDouble(gui.getAmount());
				account.deposit(amount);
				//added
				fileWriter();
			} else if (event.getActionCommand().equals("withdraw")){
				double amount = Double.parseDouble(gui.getAmount());
				try {
					account.withdraw(amount);
					//added
					fileWriter();
				} catch (InsufficientFundsException ife) {
					gui.setError("Insufficient Funds in Account");
				}
			}
			double balance = account.getBalance();
			gui.clear();
			gui.setBalance("" + balance);
		}
	
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	BankApp app = new BankApp();
            }
        });
    }   
}
