package run;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class HighScore extends JFrame implements ActionListener {

	private static final int WINDOW_WIDTH = 750;
	// technically 780 + 8 + 8 (from left and right window borders) + 30 from the
	// top left corner of square and + 1 from spawn
	private static final int WINDOW_HEIGHT = 750;
	// 780 + 30 + 8 (from borders.) + 1 from spawn
	// to clarify, (788,780) is the bottom right most square of the grid
	static GUIMainMenu faceWindow = new GUIMainMenu();

	private JButton closeToMain = new JButton("Back to Main Menu");
	TextField text = new TextField(30);
	private Font f = new Font("Comic Sans", Font.BOLD, 30);

	public HighScore() {
		super("Snake - High Scores");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

		closeToMain.setFont(f);
		closeToMain.setBounds(175, 600, 400, 60);
		closeToMain.addActionListener(this);
		closeToMain.setFocusable(false);
		add(closeToMain);

		// The following three windows are needed to listen to keyboard events.
		// We need the focus in our content pane in our window to ensure we are informed
		// of keyboard events
		getContentPane().setFocusable(true);
		requestFocusInWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Back to Main Menu")) {
			System.out.println("back");
			dispose();
		}
			
	}
	
	public static void main(String[] args) {
		System.out.println("new");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				System.out.println("mid");
				HighScore faceWindow = new HighScore();
				faceWindow.setVisible(true);
				faceWindow.getContentPane().setBackground(new Color(200));
				System.out.println("end");

			}
		});
	}

}
