import java.awt.Graphics;
import java.awt.Rectangle;

public class Food{

	Point topLeft = new Point(0,0);
	int size;
	
	public Food(Point foodTopLeft, int foodSize) {
		topLeft = foodTopLeft;
		size = foodSize;
	}

	//public abstract void draw(Graphics g);

	public Point getTopLeft() {
		return topLeft;
	}

	public int getSize() {
		return size;
	}
	
	public void setSize(int size2) {
		size = size2;
	}

	public void draw(Graphics g){
		g.drawOval(getTopLeft().getXCoord(), getTopLeft().getYCoord(),getSize() * 2,getSize() * 2);
		g.fillOval(getTopLeft().getXCoord(), getTopLeft().getYCoord(),getSize() * 2,getSize() * 2);
	}
}
