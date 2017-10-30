import java.awt.Graphics;
import java.awt.Rectangle;

public class Snake{

	Point topLeft = new Point(0,0);
	int size;
	String direction = "down";
	
	public Snake(Point snakeTopLeft, int snakeSize) {
		topLeft = snakeTopLeft;
		size = snakeSize;
	}

	//public abstract void draw(Graphics g);

	public Point getTopLeft() {
		return topLeft;
	}

	public int getSize() {
		return size;
	}

	public void moveDown(int amount) {
		direction = "down";
		topLeft.moveDown(amount);
	}
	
	public void moveUp(int amount) {
		direction = "up";
		topLeft.moveUp(amount);
	}
	
	public void moveLeft(int amount) {
		direction = "left";
		topLeft.moveLeft(amount);
	}
	
	public void moveRight(int amount) {
		direction = "right";
		topLeft.moveRight(amount);
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
	
	public void setSize(int size2) {
		size = size2;
	}

	public void draw(Graphics g){
		g.drawRect(getTopLeft().getXCoord(), getTopLeft().getYCoord(),getSize() * 2,getSize() * 2);
	}
}
