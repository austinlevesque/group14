import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Shape {

  private Point topLeft = new Point(0,0);
  private int size;

  public Shape(Point shapeTopLeft, int shapeSize){
    topLeft = new Point(shapeTopLeft());
    size = shapeSize;
  }

  public abstract void Draw(Graphics g);

  public Point getTopLeft() {
    Point temp = new Point(topLeft());
    return temp;
  }

  public int getSize() {
    return size;
  }

  public void moveDown(int amount) {
    topLeft.moveDown(amount);
  }

  public void moveUp(int amount) {
    topLeft.moveUp(amount);
  }

  public void moveLeft(int amount) {
    topLeft.moveLeft(amount);
  }

  public void moveRight(int amount) {
    topLeft.moveRight(amount);
  }
}
