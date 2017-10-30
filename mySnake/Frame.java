import java.awt.GridLayout;
import javax.swing.JFrame;

public class Frame extends JFrame{

  public Frame() {
    init();
  }

  public void init() {
    // Sets gridlayout type which will creat equally size rows/columns.
    // The inputs are # of rows, cols and then horiz/veritcal gaps which are ignored here.
    setLayout(new GridLayout(1, 1, 0, 0));
    Screen s = new Screen();
    //adds object to the frame.
    add(s);
    //screen class will make the frame size the same.
    pack();
    //center frame into middle of screen.
    setLocationRelativeTo(null);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Snake");
    setResizable(false);
  }

  public static void main(String[] args) {
    Frame f = new Frame();
  }
}
