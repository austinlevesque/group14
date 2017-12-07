package run;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameOverScreen extends JFrame implements ActionListener {

	private static final int WINDOW_WIDTH = 750;
	// technically 780 + 8 + 8 (from left and right window borders) + 30 from the
	// top left corner of square and + 1 from spawn
	private static final int WINDOW_HEIGHT = 750;
	// 780 + 30 + 8 (from borders.) + 1 from spawn
	// to clarify, (788,780) is the bottom right most square of the grid
	String[] args = new String[] {""};
	private JButton newGameBtn = new JButton("New Game");
	private JButton mainMenuBtn = new JButton("Main Menu");
	TextField text = new TextField(30);
	private JLabel gameover = new JLabel("test");
	static GUIMainMenu faceWindow = new GUIMainMenu();

	private Font f = new Font("Comic Sans", Font.BOLD, 50);

	public GameOverScreen() {
		super("Battlesnakes");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		gameover.setForeground(Color.WHITE);

		gameover.setFont(f);
		newGameBtn.setFont(f);
		gameover.setText("<html>Game Over</html>");
		gameover.setBounds(230, 50, 900, 150);
		newGameBtn.setBounds(175, 250, 400, 60);
		mainMenuBtn.setFont(f);
		mainMenuBtn.setBounds(175, 400, 400, 60);
		newGameBtn.addActionListener(this);
		mainMenuBtn.addActionListener(this);
		mainMenuBtn.setFocusable(false);
		newGameBtn.setFocusable(false);
		add(gameover);
		add(newGameBtn);
		add(mainMenuBtn);

		// The following three windows are needed to listen to keyboard events.
		// We need the focus in our content pane in our window to ensure we are informed
		// of keyboard events
		getContentPane().setFocusable(true);
		requestFocusInWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("New Game")) {
			System.out.println("New Game");
			GUI.main(args);
			GUI.getGameBoard().resetGame();
		} else if (e.getActionCommand().equals("Main Menu")) {
				System.out.println("back");
				dispose();
		}
	}

	public static void main(String[] args) {
		System.out.println("new");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				System.out.println("mid");
				GameOverScreen faceWindow = new GameOverScreen();
				faceWindow.setVisible(true);
				faceWindow.getContentPane().setBackground(new Color(200));
				System.out.println("end");

			}
		});
	}
}
