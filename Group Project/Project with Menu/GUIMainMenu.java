package run_snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUIMainMenu extends JFrame implements ActionListener, KeyListener {
	private static final int WINDOW_WIDTH = 750;
	// technically 780 + 8 + 8 (from left and right window borders) + 30 from the
	// top left corner of square and + 1 from spawn
	private static final int WINDOW_HEIGHT = 750;
	// 780 + 30 + 8 (from borders.) + 1 from spawn
	// to clarify, (788,780) is the bottom right most square of the grid
	String[] args = new String[] {""};
	private JButton newGameBtn = new JButton("New Game");
	private JButton highscoreBtn = new JButton("High Scores");
	TextField text = new TextField(30);
	static GUIMainMenu faceWindow = new GUIMainMenu();


	private Font f = new Font("Comic Sans", Font.BOLD, 50);

	public GUIMainMenu() {
		super("Snake");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

		newGameBtn.setFont(f);
		newGameBtn.setBounds(175, 250, 400, 60);
		highscoreBtn.setFont(f);
		highscoreBtn.setBounds(175, 400, 400, 60);
		newGameBtn.addActionListener(this);
		highscoreBtn.addActionListener(this);
		highscoreBtn.setFocusable(false);
		newGameBtn.setFocusable(false);
		add(newGameBtn);
		add(highscoreBtn);

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
			GUI_Run.main(args);
		} else if (e.getActionCommand().equals("High Scores")) {
			HighScore.main(args);
			System.out.println("High Scores");
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		System.out.println("new");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				System.out.println("mid");
				GUIMainMenu faceWindow = new GUIMainMenu();
				faceWindow.setVisible(true);
				faceWindow.getContentPane().setBackground(new Color(200));
				System.out.println("end");

			}
		});
	}
}
