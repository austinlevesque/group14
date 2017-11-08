import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Simple Banking Application which shows the current balance and allows desposit and withdrawls.
 *
 */
public class BankAccountGUI extends JFrame implements ActionListener{

  private BankAccount bank = new BankAccount();
  private JLabel currentBalance;
  private double balance = bank.getBalance();
  private JLabel test;
  private JLabel deposit;
  private JTextField entry = new JTextField(10);

  /**
   * public BankAccountGUI - description
   *
   * @return {type}  description
   */
  public BankAccountGUI() {

    super("BankAccountApp");
    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel content = new JPanel();
    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

    currentBalance = new JLabel("Your Current Balance is:");
    content.add(currentBalance);

    test = new JLabel("$" + Double.toString(balance));
    content.add(test);

    deposit = new JLabel("Deposit / Withdraw Amount ($):");
    content.add(deposit);

    entry.setAlignmentX(Component.CENTER_ALIGNMENT);
    content.add(entry);

    JButton depositBtn = new JButton("Deposit");
    depositBtn.setActionCommand("DEPOSIT");
		depositBtn.addActionListener(this);
		depositBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		content.add(depositBtn);

    JButton withdrawBtn = new JButton("Withdraw");
    withdrawBtn.setActionCommand("WITHDRAW");
    withdrawBtn.addActionListener(this);
    withdrawBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
    content.add(withdrawBtn);

    super.getContentPane().add(content);
  }


  /**
   * public void - description
   *
   * @param  {type} ActionEvent event description
   * @return {type}                   description
   */
  public void actionPerformed(ActionEvent event) {
    if (event.getActionCommand().equals("DEPOSIT")) {
      balance += Double.parseDouble(entry.getText());
      test.setText("$" + Double.toString(balance));
    }
    else if(event.getActionCommand().equals("WITHDRAW")) {
      balance -= Double.parseDouble(entry.getText());
      test.setText("$" +Double.toString(balance));
    }
  }


  /**
   * @public static - description
   *
   * @param  {type} String[] args description
   * @return {type}               description
   */
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run(){
        BankAccountGUI gui = new BankAccountGUI();
        gui.pack();
        gui.setVisible(true);
      }
    });
  }
}
