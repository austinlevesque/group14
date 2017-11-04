import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.Color;


/**
 * Snake class for the player controlled snake object
 * Based off of the Shape class used in Assignment 5, written by Nathaly Verwaal.
 *
 * @verison 1.0
 * @author Austin Levesque
 * @author Chris O'Reilly
 * @author Steven Canon-Almagro
 * @author Victor Chu
 * @author Navjot Saran
 */
public class Snake extends GameObject {

	public Snake(Point snakeTopLeft, int snakeSize) {
		super(snakeTopLeft, snakeSize);
	}

	public void draw(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(getTopLeft().getXCoord(), getTopLeft().getYCoord(),getSize() * 2,getSize() * 2);
	}
}
