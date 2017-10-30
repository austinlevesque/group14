import java.awt.Color;
import java.awt.Graphics;


public class BodyPart {

  private int xCoor, yCoor, width, height;

  public BodyPart(int xCoor, int yCoor, int tileSize) {
    this.xCoor = xCoor;
    this.yCoor = yCoor;
    width = tileSize;
    height = tileSize;
  }

  public void tick() {

  }

  public void draw(Graphics g) {
    g.setColor(Color.BLACK);
    g.fillRect(xCoor * width, yCoor * height, width, height);
    g.setColor(Color.GREEN);
    g.fillRect(xCoor * width + 1, yCoor * height + 1, width, height);
  }
}
