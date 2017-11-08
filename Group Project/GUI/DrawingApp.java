import java.util.ArrayList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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

	Font f = new Font("Comic Sans", Font.BOLD, 50);
	JLabel scoreLabel = new JLabel("Score: 0");

	Point p1 = new Point(8,30);
	Point p2 = new Point(98,120);
	//Point p3 = new Point(8,30);
	//Point p3 = new Point(1000,1000); //purposely out of bounds
	Snake aSnake = new Snake(p1, 15);
	//Snake aTail = new Snake(p3, 15);
	Food aFood = new Food(p2, 15);
	//ArrayList<Snake> tailList = new ArrayList<Snake>();
	//Snake aTail = new Snake(p3, 15);

    /**
     * Creates a window that the game will be played in
     */
    public DrawingApp(int color1, int color2, int color3) {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
			  setResizable(false);
			  setLocationRelativeTo(null);
		    setLayout(null);

				// The following three windows are needed to listen to keyboard events.
				// We need the focus in our content pane in our window to ensure we are informed of keyboard
				// events.
        getContentPane().addKeyListener(this);
        getContentPane().setFocusable(true);
        requestFocusInWindow();
	    			if (color1 <= 100 || color2 <= 100 || color3 <= 1 ){
					scoreLabel.setForeground(Color.WHITE);
				}
				scoreLabel.setFont(f);
				scoreLabel.setBounds(900, 10, 900, 100);
				add(scoreLabel);

        /**
         * Timer that goes off every 400ms
         * Calls frame method to repaint itself which indirectly calls paint()
         */
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
    	//System.out.println("Snake Old Location: "+ aSnake.getLoc(aSnake.getTopLeft()));
    	//if(aSnake.tail.size()>0) {
    		/*for(int j = mainSnake.tailX.size(); j>0; j--){
    			System.out.println("Snake Tail Location: "+ aSnake.tail.get(0));
    		}*/
    	//}
    	aSnake.updateTail(p1.getXCoord(),p1.getYCoord());
    	/*
		if (aSnake.tail.size() > 0){
			for(int j = aSnake.tail.size(); j>0; j--){
				//arrayGrid[(mainSnake.tailY.get(j-1))][mainSnake.tailX.get(j-1)] = "s ";
				Snake tempTail = new Snake(aSnake.tail.get(j-1), 15);
				tailList.add(tempTail);
			}
			//tailList.add(new Snake(aSnake.tail.get(0), 15));
		}
		*/
    	//System.out.println("Snake Tail Location: ("+ aTail.getTopLeft().getXCoord()+","+aTail.getTopLeft().getYCoord()+")");
		//System.out.println("Snake Tail Location: ("+ aTail.getTopLeft().getXCoord()+","+aTail.getTopLeft().getYCoord()+")");
		//System.out.println("Snake New Location: "+ aSnake.getLoc(aSnake.getTopLeft()));
		aSnake.moveDir(30);
		//ArrayList<Point> testList = new ArrayList<Point>();
		//testList.add(p1);
		//System.out.println(p1);
		/*
		if (((aSnake.tail.size())) > 0){
			System.out.println(aSnake.tailStrings.get(0));
		}
		*/
		if(aSnake.tailStrings.contains(aSnake.getLoc(p1))){
            System.out.println("Game over");
            System.exit(0);
        }
		/*
		if(aSnake.getLoc(aSnake.getTopLeft()).equals(aFood.getLoc(aFood.getTopLeft()))) {
			
		}
		*/
		if(aSnake.getLoc(aSnake.getTopLeft()).equals(aFood.getLoc(aFood.getTopLeft()))) {
			aSnake.score++;
			aFood = new Food(aFood.newLoc(26),15);
			//aTail = new Snake(aSnake.tail.get((aSnake.score)-1),15);
			scoreLabel.setText("Score: " + aSnake.score);
		}
		repaint();
    }

	@Override
    public void paint(Graphics canvas) {
		// Draws the gui. Called in timerAction() every 400ms

        // Wipes the window clean
        super.paint(canvas);

				canvas.setColor(Color.WHITE);
				canvas.fillRect(8,30,810,780);

        //Draws the snake and food
				/*
		if (((aSnake.tail.size())) > 0){
			System.out.println("Tail Size: "+ aSnake.tail.size());
			System.out.println("Tail 0 X: "+ aSnake.tail.get(0).getXCoord());
			System.out.println("Snake Tail Location: ("+ aSnake.tail.get(0).getXCoord()+","+aSnake.tail.get(0).getYCoord()+")");
			Point p4 = new Point (aSnake.tail.get(0).getXCoord(),aSnake.tail.get(0).getYCoord());
			//p3 = aSnake.tail.get(0);
			//p3 = new Point(aSnake.tail.get(1).getXCoord(),aSnake.tail.get(1).getYCoord());
	        aTail = new Snake(p4, 15);
		}
		*/
				
		//Point p4 = p1;
		//aTail.draw(canvas);

        aSnake.draw(canvas);
        //aTail.draw(canvas);
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
        for (Snake s : aSnake.tailSnakes) {
        	s.draw(canvas);
        }
    }

	/**
	 * Checks for key-presses and changes the instance variable direction for the aSnake object, which changes the direction it's traveling
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int size = 50;
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			aSnake.direction = "left";
			System.out.println(aSnake.direction);
			break;
		case KeyEvent.VK_D:
			aSnake.direction = "right";
			System.out.println(aSnake.direction);
			break;
		case KeyEvent.VK_W:
			aSnake.direction = "up";
			System.out.println(aSnake.direction);
			break;
		case KeyEvent.VK_S:
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
							int color1, color2, color3;
			                Random rand = new Random();
			                color1 = rand.nextInt(255)+1;
			                color2 = rand.nextInt(255)+1;
			                color3 = rand.nextInt(255)+1;
							DrawingApp faceWindow = new DrawingApp(color1, color2, color3);
							faceWindow.setVisible(true);
					   	faceWindow.getContentPane().setBackground(new Color(color1, color2, color3));

			}
		});
    }

}
