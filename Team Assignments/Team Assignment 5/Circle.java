import java.awt.Graphics;
import java.awt.Rectangle;

public class Circle extends Shape {

	public Circle(Point circleTopLeft, int circleSize){
		super(circleTopLeft, circleSize);
		topLeft = circleTopLeft;
		size = circleSize;
	}

	public void setSize(int size1) {
		size = size1;
	}

	public void draw(Graphics g){
		g.drawOval(getTopLeft().getXCoord(), getTopLeft().getYCoord(),
				getSize() * 2,
				getSize() * 2);

	}
}
