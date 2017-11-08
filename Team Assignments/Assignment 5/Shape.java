import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Shape {

  Point topLeft = new Point(0,0);
  int size;

  public Shape(Point shapeTopLeft, int shapeSize){
    topLeft = shapeTopLeft;
    size = shapeSize;
  }

  public abstract void draw(Graphics g);

  public Point getTopLeft() {
    return topLeft;
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
