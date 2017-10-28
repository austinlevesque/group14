import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.Timer;

import java.util.Random;


public class SnakeGUI extends JFrame implements KeyListener {
  public static final int WINDOW_WIDTH = 750;
  public static final int WINDOW_HEIGHT = 750;

  /**
   * Creates the window that users can use to draw circles.
   */
  public SnakeGUI() {
    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    setDefaultCloseOperation(EXIT_ON_CLOSE);


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
                  //timerAction();
              }
          });
      // The timer will go off for the first time 1000ms after the timer is started.
      timer.setInitialDelay(1000);
      timer.start();
  }

  @Override
    public void paint(Graphics canvas){
      // Draws what should be displayed in this window.  this will be called each
  		// time the window needs to be refreshed.  This includes when the window
  		// is displayed, maximized, moved, etc.)

          // We need to do this call to make sure the window is wiped clean before we
          // start drawing.
    }

  @Override
	public void keyPressed(KeyEvent e){
    switch (e.getKeyCode()) {
    case 'A':
      System.out.println("A");
      break;
    case 'S':
      System.out.println("S");
      break;
    case 'W':
      System.out.println("W");
      break;
    case 'D':
      System.out.println("D");
      break;
    /*case KeyEvent.VK_LEFT:
      System.out.println("left");
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
        objectShape(d).moveDown(30);
        d++;
      }
      break;*/
    }
  }

  @Override
  public void keyTyped(KeyEvent event) {
    // Required for KeyListener, but we are not interested in this event so we'll
    // do nothing.
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
      faceWindow.getContentPane().setBackground(new java.awt.Color(204, 166, 166));
    }
  });
  }
}
