import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

import java.util.Random;

/**
 * Application for drawing circles on the screen.  When the user click, a circle
 * will be created on the spot of default size.  When dragging the mouse, the circle
 * will have the size indicated by the drag area.
 * @author Nathaly Verwaal
 *
 */
public class DrawingApp extends JFrame implements KeyListener {
	public static final int WINDOW_WIDTH = 827;
	public static final int WINDOW_HEIGHT = 819;
	public static final int DEFAULT_CIRCLE_SIZE = 100;

	//private ArrayList<Shape> circles = new ArrayList<Shape>();
	int score = 0;
	Snake aSnake = new Snake(randomNum(), 15);
	Food aFood = new Food(randomNum(), 15);

    /**
     * Creates the window that users can use to draw circles.
     */
    public DrawingApp() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // put one circle in the list to get it started.
		//Point temp = new Point(0,0);
		//Point temp1 = new Point(8,30);
		//Circle aCircle = new Circle(temp, DEFAULT_CIRCLE_SIZE);
		//Snake aSnake = new Snake(temp1, 15);
		//circles.add(aCircle);
        //circles.add(aSnake);

		// The following three windows are needed to listen to keyboard events.
		// We need the focus in our content pane in our window to ensure we are informed of keyboard
		// events.
        getContentPane().addKeyListener(this);
        getContentPane().setFocusable(true);
        requestFocusInWindow();

        // This creates a timer.  Whenever the timer goes off (every 200 ms)
        // we call this frame's method to repaint itself.  (Which will
        // indirectly call paint which is defined below.)
        Timer timer = new Timer(400,
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    timerAction();
                }
            });
        // The timer will go off for the first time 1000ms after the timer is started.
        timer.setInitialDelay(1000);
        timer.start();
    }

	/**
	 * This method will move all circles in our list down and ask the frame to
	 * be re-drawn.
	 */
    public void timerAction() {
		aSnake.moveDir(30);
		if((aSnake.getTopLeft().getXCoord() == aFood.getTopLeft().getXCoord()) && (aSnake.getTopLeft().getYCoord() == aFood.getTopLeft().getYCoord())) {
			score++;
			System.out.println("Score: " + score);
		}
		repaint();
    }

	@Override
    public void paint(Graphics canvas) {
		// Draws what should be displayed in this window.  this will be called each
		// time the window needs to be refreshed.  This includes when the window
		// is displayed, maximized, moved, etc.)

        // We need to do this call to make sure the window is wiped clean before we
        // start drawing.
        super.paint(canvas);

        aSnake.draw(canvas);
        aFood.draw(canvas);
    }

	@Override
	public void keyTyped(KeyEvent event) {
		// Required for KeyListener, but we are not interested in this event so we'll
		// do nothing.
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int size = 50;
		switch (e.getKeyCode()) {
		/*
		case 'C':
			System.out.println("C");
			circles.add(new Circle(randomNum(), DEFAULT_CIRCLE_SIZE));
			break;
		case 'S':
			System.out.println("S");
			circles.add(new Snake(randomNum(), DEFAULT_CIRCLE_SIZE));
			break;
		 */
		case KeyEvent.VK_LEFT:
			aSnake.direction = "left";
			System.out.println(aSnake.direction);
			//aSnake.moveLeft(30);
			break;
		case KeyEvent.VK_RIGHT:
			aSnake.direction = "right";
			System.out.println(aSnake.direction);
			//aSnake.moveRight(30);
			break;
		case KeyEvent.VK_UP:
			aSnake.direction = "up";
			System.out.println(aSnake.direction);
			//aSnake.moveUp(30);
			break;
		case KeyEvent.VK_DOWN:
			aSnake.direction = "down";
			System.out.println(aSnake.direction);
			//aSnake.moveDown(30);
			break;
		}
	}

	public Point randomNum() {
		Random rand1 = new Random();
		Random rand2 = new Random();
		int r1 = rand1.nextInt(829);
		int r2 = rand2.nextInt(819);
		Point p = new Point(r1, r2);
		return p;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Required for KeyListener, but we are not interested in this event so we'll
		// do nothing.
	}

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
				DrawingApp faceWindow = new DrawingApp();
				faceWindow.setVisible(true);
		   		faceWindow.getContentPane().setBackground(new java.awt.Color(250, 50, 50));
			}
		});
    }

}
