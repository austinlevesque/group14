import java.awt.Graphics;
import java.awt.Rectangle;

public class Circle {
	private Point topLeft = new Point(0,0);
	private int radius = 50;

	public Circle(int size) {
		radius = size;
	}

	public Circle(Point x, int y) {
		topLeft = x;
		radius = y;
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

	public void draw(Graphics g){
		g.drawOval(topLeft.getXCoord(), topLeft.getYCoord(),
				radius * 2,
				radius * 2);

	}
}
