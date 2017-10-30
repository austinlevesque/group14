import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake{

	Point topLeft = new Point(0,0);
	int size;
	int score = 0;
	String direction = "down";
	ArrayList<Point> tail = new ArrayList<Point>();
	
	public Snake(Point snakeTopLeft, int snakeSize) {
		topLeft = snakeTopLeft;
		size = snakeSize;
	}

	//public abstract void draw(Graphics g);

	public Point getTopLeft() {
		return topLeft;
	}
	
	public String getLoc(Point pointToCheck) {
		String loc = ("("+pointToCheck.getXCoord()+","+pointToCheck.getYCoord()+")");
		return loc;
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
	
	public void updateTail(Point prevPt){
		tail.add(prevPt);
		while(tail.size() > score){
			tail.remove(0);
		}
	}
	
	/*
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
	
	public void setSize(int size2) {
		size = size2;
	}

	public void draw(Graphics g){
		g.drawRect(getTopLeft().getXCoord(), getTopLeft().getYCoord(),getSize() * 2,getSize() * 2);
		g.fillRect(getTopLeft().getXCoord(), getTopLeft().getYCoord(),getSize() * 2,getSize() * 2);
	}
}
