package run;

import gameobjects.*;
import move.KeyboardInput;
import move.Point;
import fileio.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;

/**
 * GUI Code for Snake Game Project Based off of DrawingApp.java by Nathaly
 * Verwaal used in Team Assignment 5
 *
 * @author Austin Levesque
 * @author Chris O'Reilly
 * @author Steven Canon-Almagro
 * @author Victor Chu
 */
@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener, KeyListener {
	private static final int WINDOW_WIDTH = 1250;
	// technically 780 + 8 + 8 (from left and right window borders) + 30 from the
	// top left corner of square and + 1 from spawn
	private static final int WINDOW_HEIGHT = 819;
	// 780 + 30 + 8 (from borders.) + 1 from spawn
	// to clarify, (788,780) is the bottom right most square of the grid

	private Font f = new Font("Comic Sans", Font.BOLD, 50);
	private Font c = new Font("Comic Sans", Font.BOLD, 30);
	private JLabel aScoreLabel = new JLabel("<html><u>Player 1</u><br>Score: 0<html>");
	private JLabel bScoreLabel = new JLabel("<html><u>Player 2</u><br>Score: 0<html>");
	private JLabel highscore = new JLabel("<html><u>High Score</u><br>Score: 0</html>");
	private JButton closeGameBtn = new JButton("Close to Main Menu");
	TextField text = new TextField(30);

	static int color1, color2, color3;
	static GUI faceWindow = new GUI(color1, color2, color3);
	static GameBoard board = new GameBoard();

	/**
	 * Creates a window that the game will be played in and will have three random
	 * integers to determine a random RGB value to be the background color. Default
	 * Constructor
	 * 
	 * @param color1
	 * @param color2
	 * @param color3
	 */

	public GUI(int color1, int color2, int color3) {
		super("Battlesnakes");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

		// The following three windows are needed to listen to keyboard events.
		// We need the focus in our content pane in our window to ensure we are informed
		// of keyboard events
		getContentPane().addKeyListener(this);
		getContentPane().setFocusable(true);
		requestFocusInWindow();

		if (color1 <= 100 || color2 <= 100 || color3 <= 1) {
			highscore.setForeground(Color.WHITE);
			aScoreLabel.setForeground(Color.WHITE);
			bScoreLabel.setForeground(Color.WHITE);
		}
		highscore.setFont(f);
		aScoreLabel.setFont(f);
		bScoreLabel.setFont(f);
		highscore.setBounds(900, 410, 900, 150);
		aScoreLabel.setBounds(900, 10, 900, 150);
		bScoreLabel.setBounds(900, 200, 900, 150);
		closeGameBtn.setFont(c);
		closeGameBtn.setBounds(825, 710, 400, 60);
		closeGameBtn.addActionListener(this);
		closeGameBtn.setFocusable(false);
		add(highscore);	
		add(closeGameBtn);
		add(aScoreLabel);
		add(bScoreLabel);

		// Timer that goes off every 400ms
		// Calls frame method to repaint itself which indirectly calls paint()
		Timer timer = new Timer(400, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timerAction();
			}
		});
		timer.start();
	}

	public GUI() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Moves the snake in it's current direction and checks if it has collided with
	 * the food and then calls the objects to be repainted
	 */
	public void timerAction() {
		board.guiUpdateSnake();
		aScoreLabel.setText("<html><u>Player 1</u><br>Score: <html>" + board.getSnakeA().getScore());
		bScoreLabel.setText("<html><u>Player 2</u><br>Score: <html>" + board.getSnakeB().getScore());
		repaint();
	}

	/**
	 * Paint method which manually draws the GUI, including the snake, tail, and
	 * food Called in timerAction() every 400ms Wipes the window clean every time
	 * it's called
	 * 
	 * @param canvas
	 */
	@Override
	public void paint(Graphics canvas) {
		super.paint(canvas);
		canvas.setColor(Color.WHITE);
		canvas.fillRect(8, 30, 810, 780);
		board.getSnakeA().draw(canvas);
		board.getSnakeB().draw(canvas);
		board.getFood().draw(canvas);
		for (Snake s : board.getSnakeA().getTailSnakes()) {
			s.draw(canvas);
		}
		for (Snake s : board.getSnakeB().getTailSnakes()) {
			s.draw(canvas);
		}
	}
	
	public static void disposeMethod() {
		faceWindow.dispose();
	}

	/**
	 * Checks for key-presses and changes the instance variable direction for the
	 * aSnake object, which changes the direction it's traveling
	 * 
	 * @param e
	 */ 
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			board.getSnakeA().setDir("left");
			break;
		case KeyEvent.VK_D:
			board.getSnakeA().setDir("right");
			break;
		case KeyEvent.VK_W:
			board.getSnakeA().setDir("up");
			break;
		case KeyEvent.VK_S:
			board.getSnakeA().setDir("down");
			break;
		case KeyEvent.VK_LEFT:
			board.getSnakeB().setDir("left");
			break;
		case KeyEvent.VK_RIGHT:
			board.getSnakeB().setDir("right");
			break;
		case KeyEvent.VK_UP:
			board.getSnakeB().setDir("up");
			break;
		case KeyEvent.VK_DOWN:
			board.getSnakeB().setDir("down");
			break;
		}
	} 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Close to Main Menu")) {
			faceWindow.setVisible(false);
		}
	}
	
	public static GameBoard getGameBoard() {
		return board;
	}

	/**
	 * Main function that initializes the game and window as well as its background
	 * color
	 * 
	 * @param args
	 */
	public static int generateRandomRGBValue() {
		int color;
		Random rand = new Random();
		color = rand.nextInt(255) + 1;
		return color;
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				int color1 = generateRandomRGBValue();
				int color2 = generateRandomRGBValue();
				int color3 = generateRandomRGBValue();
				faceWindow.setVisible(true);
				faceWindow.getContentPane().setBackground(
						new Color(color1, color2, color3));
			}
		});
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




}

