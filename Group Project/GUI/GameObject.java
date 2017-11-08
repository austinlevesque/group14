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
  int r1;
  int r2;

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

  public Point newLoc(int range) {
    Random rand1 = new Random();
    Point newPoint = new Point(0,0);
    if(range == 26) {
      r1 = rand1.nextInt(26) * 30 + 8;
      r2 = rand1.nextInt(26) * 30;
    }
    else if (range == 10) {
      r1 = rand1.nextInt(11);
      r2 = rand1.nextInt(11);
    }
    System.out.println(getLoc(newPoint));
    newPoint.setXCoord(r1);
    newPoint.setYCoord(r2);
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
