import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public abstract class GameObject {

  Point topLeft = new Point(0,0);
  //Point tailPoint = new Point(0,0);
  int size;
  int score = 0;
  String direction = "down";

  public GameObject(Point snakeTopLeft, int snakeSize) {
		topLeft = snakeTopLeft;
		size = snakeSize;
	}

  public Point getTopLeft() {
    return topLeft;
  }

  public int getSize() {
    return size;
  }

  public void moveDir(int amount) {
    if (direction == "down"){
      topLeft.moveDown(amount);
    }else if (direction == "up") {
      topLeft.moveUp(amount);
    }else if (direction == "left"){
      topLeft.moveLeft(amount);
    } else {
      topLeft.moveRight(amount);
    }
  }

  public Point newLoc() {
    Random rand1 = new Random();
    int r1 = rand1.nextInt(26) * 30 + 8;
    int r2 = rand1.nextInt(26) * 30;
    Point newPoint = new Point(r1,r2);
    System.out.println(getLoc(newPoint));
    return newPoint;
  }

  public String getLoc(Point pointToCheck) {
    String loc = ("("+pointToCheck.getXCoord()+","+pointToCheck.getYCoord()+")");
    return loc;
  }

  public abstract void draw(Graphics g);

  /*
    public String getLoc(Point pointToCheck) {
      String loc = ("("+pointToCheck.getXCoord()+","+pointToCheck.getYCoord()+")");
      return loc;
    }
  */

  /*
  public void updateTail(Point prevPt){
    tail.add(prevPt);
    if ((tail.size()-1) > score) {
      while((tail.size()-1) > score){
        tail.remove(0);
      }
    }
  */

  /*
  //OLD CODE FROM TEXT BASED VERSION FOR REFERENCE
  public void updateTail(int prevX, int prevY){
    int tail = score;
    tailX.add(prevX);
    tailY.add(prevY);
    if (tailX.size() > tail){
    System.out.println("Tail end Position:"+tailX.get(0)+","+tailY.get(0));
      while(tailX.size() > tail){
        tailX.remove(0);
        tailY.remove(0);
      }
    }
  }
  */
}
