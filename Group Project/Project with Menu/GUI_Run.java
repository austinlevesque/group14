package run_snake;
import gameobjects.*;
import move.Point;
import fileio.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;

/**
 * GUI Code for Snake Game Project
 * Based off of DrawingApp.java by Nathaly Verwaal used in Team Assignment 5
 *
 * @author Austin Levesque
 * @author Chris O'Reilly
 * @author Steven Canon-Almagro
 * @author Victor Chu
 * @author Navjot Saran
 */
@SuppressWarnings("serial")
public class GUI_Run extends JFrame implements KeyListener, ActionListener{
	private static final int WINDOW_WIDTH = 1250;
	//technically 780 + 8 + 8 (from left and right window borders) + 30 from the top left corner of square and + 1 from spawn
	private static final int WINDOW_HEIGHT = 819;
	//780 + 30 + 8 (from borders.) + 1 from spawn
	//to clarify, (788,780) is the bottom right most square of the grid

	static int color1, color2, color3;
	private Font f = new Font("Comic Sans", Font.BOLD, 50);
	private Font c = new Font("Comic Sans", Font.BOLD, 30);

	private JLabel aScoreLabel = new JLabel("<html><u>Player 1</u><br>Score: 0<html>");
	private JLabel bScoreLabel = new JLabel("<html><u>Player 2</u><br>Score: 0<html>");
	private JButton closeGameBtn = new JButton("Close to Main Menu");
	TextField text = new TextField(30);
	
	private Point p1 = new Point(8, 30);
	private Point p2 = new Point(98,120);
	private Point p3 = new Point(788,780);
	private Snake aSnake = new Snake(p1, 15);
	private Snake bSnake = new Snake(p3,15);
	private Food aFood = new Food(p2, 15);
	static GUI_Run faceWindow = new GUI_Run(color1, color2, color3);

	/**
	 * Creates a window that the game will be played in
	 * Default Constructor
	 * @param color1
	 * @param color2
	 * @param color3
	 */
	
    public GUI_Run(int color1, int color2, int color3) {
    	super("Snake");
    	setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        

		//The following three windows are needed to listen to keyboard events.
		//We need the focus in our content pane in our window to ensure we are informed of keyboard events
        getContentPane().addKeyListener(this);
        getContentPane().setFocusable(true);
        requestFocusInWindow();
        if(color1 <= 100 || color2 <= 100 || color3 <= 1 ) {
        	aScoreLabel.setForeground(Color.WHITE);
        	bScoreLabel.setForeground(Color.WHITE);
        }
        aScoreLabel.setFont(f);
		bScoreLabel.setFont(f);
		aScoreLabel.setBounds(900, 10, 900, 150);
		bScoreLabel.setBounds(900, 200, 900, 150);
		closeGameBtn.setFont(c);
		closeGameBtn.setBounds(825,710,400,60);
		closeGameBtn.addActionListener(this);
		closeGameBtn.setFocusable(false);
		add(closeGameBtn);
		add(aScoreLabel);
		add(bScoreLabel);

        //Timer that goes off every 400ms
        //Calls frame method to repaint itself which indirectly calls paint()
        Timer timer = new Timer(400, new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		timerAction();
    		}
        });
        timer.start();
    }

	/**
	 * Moves the snake in it's current direction and checks if it has collided with the food and then calls the objects to be repainted
	 */
    public void timerAction() {
    	aSnake.updateTail(p1.getXCoord(),p1.getYCoord());
    	bSnake.updateTail(p3.getXCoord(),p3.getYCoord());
    	aSnake.moveDir(30);
		bSnake.moveDir(30);
		if(aSnake.getTailStrings().contains(aSnake.getLoc(p1))){
            System.out.println("Game over");
            System.exit(0);
        }
		if(aSnake.getLoc(aSnake.getTopLeft()).equals(aFood.getLoc(aFood.getTopLeft()))) {
			aSnake.setScore(aSnake.getScore()+1);
			aFood = new Food(aFood.newLoc(26),15);
			aScoreLabel.setText("<html><u>Player 1</u><br>Score: <html>" + aSnake.getScore());
		}
		if(bSnake.getLoc(bSnake.getTopLeft()).equals(aFood.getLoc(aFood.getTopLeft()))) {
			bSnake.setScore(bSnake.getScore()+1);
			aFood = new Food(aFood.newLoc(26),15);
			bScoreLabel.setText("<html><u>Player 2</u><br>Score: <html>" + bSnake.getScore());
		}
		repaint();
    }

    /**
     * Paint method which manually draws the GUI, including the snake, tail, and food
     * Called in timerAction() every 400ms
     * Wipes the window clean every time it's called
     * @param canvas
     */
	@Override
    public void paint(Graphics canvas) {
		super.paint(canvas);
		canvas.setColor(Color.WHITE);
		canvas.fillRect(8,30,810,780);
        aSnake.draw(canvas);
        bSnake.draw(canvas);
        aFood.draw(canvas);
        for (Snake s : aSnake.getTailSnakes()) {
        	s.draw(canvas);
        }
        for (Snake s : bSnake.getTailSnakes()) {
        	s.draw(canvas);
        }
    }

	/**
	 * Checks for key-presses and changes the instance variable direction for the aSnake object, which changes the direction it's traveling
	 * @param e
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			aSnake.setDir("left");
			break;
		case KeyEvent.VK_D:
			aSnake.setDir("right");
			break;
		case KeyEvent.VK_W:
			aSnake.setDir("up");
			break;
		case KeyEvent.VK_S:
			aSnake.setDir("down");
			break;
		case KeyEvent.VK_LEFT:
			bSnake.setDir("left");
			break;
		case KeyEvent.VK_RIGHT:
			bSnake.setDir("right");
			break;
		case KeyEvent.VK_UP:
			bSnake.setDir("up");
			break;
		case KeyEvent.VK_DOWN:
			bSnake.setDir("down");
			break;
		}
	}

	
	/**
	 * Required for KeyListener. Does nothing for this code
	 */
	@Override
	public void keyReleased(KeyEvent e) {
	}

	/**
	 * Required for KeyListener. Does nothing for this code
	 */
	@Override
	public void keyTyped(KeyEvent event) {
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Close to Main Menu")) {
			faceWindow.setVisible(false);
		}
	}
	
	/**
	 * Main function that initializes the game and window as well as its background color
	 * @param args
	 */
    public static void main(String[] args) {
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
    		public void run() {
    			int color1, color2, color3;
    			Random rand = new Random();
    			color1 = rand.nextInt(255)+1;
                color2 = rand.nextInt(255)+1;
                color3 = rand.nextInt(255)+1;
				faceWindow.setVisible(true);
			   	faceWindow.getContentPane().setBackground(new Color(color1, color2, color3));
			}
		});
    }
}
