import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

/**
 * Food class for the player controlled snake object
 * Based off of the Shape class used in Assignment 5, written by Nathaly Verwaal.
 *
 * @verison 1.0
 * @author Austin Levesque
 * @author Chris O'Reilly
 * @author Steven Canon-Almagro
 * @author Victor Chu
 * @author Navjot Saran
 */
public class Food extends GameObject {

	public Food(Point foodTopLeft, int foodSize) {
		super(foodTopLeft, foodSize);
	}

	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(getTopLeft().getXCoord(), getTopLeft().getYCoord(),getSize() * 2,getSize() * 2);
	}
}
