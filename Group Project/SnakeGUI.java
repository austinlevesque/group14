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
public class SnakeGUI extends JFrame implements KeyListener {
	public static final int WINDOW_WIDTH = 750;
	public static final int WINDOW_HEIGHT = 750;
	public static final int DEFAULT_SHAPE_SIZE = 10;
	String holder = "W";
	int i = 0;
	int s = 0;
	Shape snakeCompare;
	Shape foodCompare;
	Point snakePointCompare;
	Point foodPointCompare;
	Shape newFoodShape;
	Shape foodUpdate;


	private ArrayList<Shape> snakes = new ArrayList<Shape>();
	private ArrayList<Shape> foods = new ArrayList<Shape>();

    /**
     * Creates the window that users can use to draw circles.
     */
    public SnakeGUI() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // put one circle in the list to get it started.
		Point temp1 = new Point(330,330);
		Point temp = new Point(330,330);
		Square aSnake = new Square(temp1, DEFAULT_SHAPE_SIZE);
		Square aFood = new Square(temp, DEFAULT_SHAPE_SIZE);
		snakes.add(aSnake);
		foods.add(aFood);
		snakeCompare = snakes.get(0);
		foodUpdate = foods.get(i);
		if(i != 5){
			foods.add(generateFood());
			foodUpdate();
		}
		
		// The following three windows are needed to listen to keyboard events.
		// We need the focus in our content pane in our window to ensure we are informed of keyboard
		// events.
        getContentPane().addKeyListener(this);
        getContentPane().setFocusable(true);
        requestFocusInWindow();

        // This creates a timer.  Whenever the timer goes off (every 200 ms)
        // we call this frame's method to repaint itself.  (Which will
        // indirectly call paint which is defined below.)
        Timer timer = new Timer(200,
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    timerAction();
                }
            });
        // The timer will go off for the first time 1000ms after the timer is started.
        //timer.setInitialDelay(10000);
        timer.start();
    }
	public void foodUpdate() {
		foodCompare = foodUpdate;
	}

	/**
	 * This method will move all circles in our list down and ask the frame to
	 * be re-drawn.
	 */
    public void timerAction() {
		Shape c = snakeCompare;
		if (holder.equals("W")) {
				c.moveUp(15);
		}
		else if (holder.equals("A")) {
				c.moveLeft(15);
		}
		else if (holder.equals("S")) {
				c.moveDown(15);
		}
		else if (holder.equals("D")) {
				c.moveRight(15);
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

        for (Shape c : snakes) {
        	c.draw(canvas);
        }
				Shape f = foodCompare;
				f.draw(canvas);
				
    }

	@Override
	public void keyTyped(KeyEvent event) {
		// Required for KeyListener, but we are not interested in this event so we'll
		// do nothing.
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//int size = 50;

		switch (e.getKeyCode()) {
		case 'W':
			//objectShape(0).moveUp(5);
			System.out.println("w");
			holder = "W";
			break;
		case 'A':
			//objectShape(0).moveLeft(5);
			holder = "A";
			break;
		case 'S':
			//objectShape(0).moveDown(5);
			holder = "S";
			break;
		case 'D':
			//objectShape(0).moveRight(5);
			holder = "D";
			break;
			/*
		case KeyEvent.VK_LEFT:
			System.out.println("l");
			int a = 0;
			for(Shape move: circles) {
				objectShape(a).moveLeft(30);
				a++;
			}
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("right");
			int b = 0;
			for(Shape move: circles) {
				objectShape(b).moveRight(30);
				b++;
			}
			break;
		case KeyEvent.VK_UP:
			System.out.println("up");
			int c = 0;
			for(Shape move: circles) {
				objectShape(c).moveUp(30);
				c++;
			}
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("down");
			int d = 0;
			for(Shape move: circles) {
				objectShape(d).moveDown();
				d++;
			}
			break;
			*/
		}
	}

	/*public Shape objectShape(int num) {
		Shape a = snakes.get(num);
		return a;
	}*/
	
	
	public Shape generateFood(){
	  while (checkFood() == false){
		Random randX = new Random();
		Random randY = new Random();
		Point newFoodLocation = new Point(randX.nextInt(), randY.nextInt());
		newFoodShape = new Square(newFoodLocation, DEFAULT_SHAPE_SIZE);
	  }
	  return newFoodShape;
	}

	public boolean checkFood(){
		snakePointCompare = snakeCompare.getTopLeft();
		foodPointCompare = foodCompare.getTopLeft();
		boolean flag = true;
		if (snakePointCompare.getYCoord() == foodPointCompare.getYCoord() && snakePointCompare.getXCoord() == foodPointCompare.getXCoord()){
			flag = false;
			System.out.println("same place");
			return flag;
		}
		return flag;
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// Required for KeyListener, but we are not interested in this event so we'll
		// do nothing.
	}


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
				SnakeGUI faceWindow = new SnakeGUI();
				faceWindow.setVisible(true);
				faceWindow.setResizable(false);
				//faceWindow.getContentPane().setBackground(new java.awt.Color(205, 155, 155));
				faceWindow.setTitle("Snake");
			}
		});
    }

}
