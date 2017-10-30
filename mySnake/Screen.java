import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.util.ArrayList;

public class Screen extends JPanel implements Runnable{

  public static final int WIDTH = 800, HEIGHT = 800;
  private Thread thread;
  private boolean running = false;

  private BodyPart b;
  private ArrayList<BodyPart> snake;

  private int xCoor = 10, yCoor = 10;
  private int size = 5;

  public Screen() {
    //
    setPreferredSize( new Dimension( WIDTH, HEIGHT ) );

    snake = new ArrayList<BodyPart>();
    //runs start method right as the window opens.
    start();
  }

  //updates stuff
  public void tick() {
    if(snake.size() == 0) {
      b = new BodyPart(xCoor, yCoor, 10);
      snake.add(b);
    }
  }

  //paints onto JPanel
  public void paint(Graphics g) {
    //Draws black lines with two for loops to create a grid.
    g.setColor(Color.BLACK);
    for(int i = 0; i < WIDTH / 10; i++) {
      g.drawLine(i * 10, 0, i * 10, HEIGHT);
    }
    for(int i = 0; i < HEIGHT / 10; i++) {
      g.drawLine(0, i * 10, WIDTH, i * 10);
    }

    for(int i = 0; i < snake.size(); i++) {
      snake.get(i).draw(g);
    }
  }

  public void start() {
    running = true;
    thread = new Thread(this, "Game Loop");
    thread.start();
  }

  public void stop() {


  }

  public void run() {
    while(running) {
      tick();
      repaint();
    }
  }
}
