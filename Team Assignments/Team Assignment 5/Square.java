import java.awt.Graphics;
import java.awt.Rectangle;

public class Square extends Shape {

  public Square(Point squareTopLeft, int squareSize){
		super(squareTopLeft, squareSize);
		topLeft = squareTopLeft;
		size = squareSize;
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
