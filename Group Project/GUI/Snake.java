import java.awt.Graphics;
import java.awt.Rectangle;

public class Snake extends Shape {
	String direction = "down";

  public Snake(Point snakeTopLeft, int snakeSize){
		super(snakeTopLeft, snakeSize);
		topLeft = snakeTopLeft;
		size = snakeSize;
	}

	public void setSize(int size2) {
		size = size2;
	}

	public void draw(Graphics g){
		g.drawRect(getTopLeft().getXCoord(), getTopLeft().getYCoord(),
				getSize() * 2,
				getSize() * 2);

	}
}
