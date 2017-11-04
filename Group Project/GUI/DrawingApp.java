import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

import java.util.Random;


/**
 * Application for drawing the snake gui in a window.
 * Based off of the DrawingApp.java used in Assignment 5, written by Nathaly Verwaal.
 * Currently references a tail in the code but doesn't actually draw it yet
 *
 * @verison 1.0
 * @author Austin Levesque
 * @author Chris O'Reilly
 * @author Steven Canon-Almagro
 * @author Victor Chu
 * @author Navjot Saran
 */
public class DrawingApp extends JFrame implements KeyListener {
	public static final int WINDOW_WIDTH = 1250; //technically 780 + 8 + 8 (from left and right window borders) + 30 from the top left corner of square and + 1 from spawn
	public static final int WINDOW_HEIGHT = 819; //780 + 30 + 8 (from borders.) + 1 from spawn
	//to clarify, (788,780) is the bottom right most square of the grid

	Point p1 = new Point(8,30);
	Point p2 = new Point(98,120);
	//Point p3 = new Point(1000,1000); //purposely out of bounds
	Snake aSnake = new Snake(p1, 15);
	Food aFood = new Food(p2, 15);
	//Snake aTail = new Snake(p3, 15);

    /**
     * Creates a window that the game will be played in
     */
    public DrawingApp() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
				setResizable(false);
				setLocationRelativeTo(null);

		// The following three windows are needed to listen to keyboard events.
		// We need the focus in our content pane in our window to ensure we are informed of keyboard
		// events.
        getContentPane().addKeyListener(this);
        getContentPane().setFocusable(true);
        requestFocusInWindow();

        /**
         * Timer that goes off every 400ms
         * Calls frame method to repaint itself which indirectly calls paint()
         */
        Timer timer = new Timer(400, new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		timerAction();
    		}
        });
        // The timer will go off for the first time 1000ms after the timer is started.
        timer.setInitialDelay(1000);
        timer.start();
    }

	/**
	 * Moves the snake in it's current direction and checks if it has collided with the food and then calls the objects to be repainted
	 */
    public void timerAction() {
    	//System.out.println(aSnake.getLoc(aSnake.getTopLeft()));
    	//aSnake.updateTail(aSnake.getTopLeft());
		aSnake.moveDir(30);
		if((aSnake.getTopLeft().getXCoord() == aFood.getTopLeft().getXCoord()) && (aSnake.getTopLeft().getYCoord() == aFood.getTopLeft().getYCoord())) {
			aSnake.score++;
			aFood = new Food(aFood.newLoc(),15);
			//aTail = new Snake(aSnake.tail.get((aSnake.score)-1),15);
			System.out.println("Score: " + aSnake.score);
		}
		repaint();
    }

	@Override
    public void paint(Graphics canvas) {
		// Draws the gui. Called in timerAction() every 400ms

        // Wipes the window clean
        super.paint(canvas);
				//canvas.fillRect(C)

				canvas.setColor(Color.BLACK);
				canvas.fillRect(8,30,810,810);
        //Draws the snake and food
        aSnake.draw(canvas);
        aFood.draw(canvas);

        //aTail.draw(canvas);
        /*
        if (aSnake.tail.size() > 0){
    		//System.out.println(aSnake.tail.get(0));
        	//aTail = aSnake.tail.get(0);
        	p3 = aSnake.tail.get(0);
        	Snake aTail = new Snake(p3, 15);
        	aTail.draw(canvas);
    	}
    	*/
    }

	/**
	 * Checks for key-presses and changes the instance variable direction for the aSnake object, which changes the direction it's traveling
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int size = 50;
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			aSnake.direction = "left";
			System.out.println(aSnake.direction);
			break;
		case KeyEvent.VK_RIGHT:
			aSnake.direction = "right";
			System.out.println(aSnake.direction);
			break;
		case KeyEvent.VK_UP:
			aSnake.direction = "up";
			System.out.println(aSnake.direction);
			break;
		case KeyEvent.VK_DOWN:
			aSnake.direction = "down";
			System.out.println(aSnake.direction);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Required for KeyListener. Does nothing for this code
	}

	@Override
	public void keyTyped(KeyEvent event) {
		// Required for KeyListener. Does nothing for this code
	}

	/**
	 * Main function that initializes the game and window as well as its background color
	 * @param args
	 */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
				DrawingApp faceWindow = new DrawingApp();
				faceWindow.setVisible(true);
		   		faceWindow.getContentPane().setBackground(Color.YELLOW);

			}
		});
    }

}
