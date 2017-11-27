import java.awt.event.*;
import java.io.*;
import java.util.*;


public class BankApp implements ActionListener {
	private BankGUI gui;
	private BankAccount account;
	//added
	File file = new File("BankAccountInfo.txt");
	boolean fileExist = file.exists();
	BufferedWriter bw;
	private Scanner x;
	private double balanceToSet;
	private String nameToSet;
	private int idToSet;
	ArrayList<String> list = new ArrayList<String>(); 
	
	PrintWriter pw;
	
	public BankApp() {
		try {
			fileCreator();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		variablesToSet();
		account = new BankAccount(balanceToSet,new Customer(nameToSet,idToSet));
		gui = new BankGUI(this);
		gui.setBalance(list.get(1));
		gui.pack();
		gui.setVisible(true);		
		

		/*openFile();
		variablesToSet();
		System.out.println(list);
		System.out.println(balanceToSet);
		System.out.println(nameToSet);
		System.out.println(idToSet);
		*/
	}
	
	
	public void variablesToSet() {
		while(x.hasNext()) {
			list.add(x.next());
		}	
		balanceToSet = Double.parseDouble(list.get(1));
		nameToSet = list.get(3);
		idToSet = Integer.parseInt(list.get(5));
		
	}
	
	//added this
	public void fileCreator() throws IOException {
		
		if(fileExist) {
			x = new Scanner(new File ("BankAccountInfo.txt"));
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
