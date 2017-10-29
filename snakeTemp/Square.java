import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.*;
import javax.swing.*;


public class Square extends Shape {

  public Square(Point squareTopLeft, int squareSize){
		super(squareTopLeft, squareSize);
	}

	public void draw(Graphics g){
		g.drawRect(getTopLeft().getXCoord(), getTopLeft().getYCoord(),
				getSize() * 2,
				getSize() * 2);
    g.setColor(Color.orange);
    g.fillRect(getTopLeft().getXCoord(), getTopLeft().getYCoord(),
				getSize() * 2,
				getSize() * 2);

	}
}
