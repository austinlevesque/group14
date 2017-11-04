import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

import java.util.Random;

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

	public String getLoc(Point pointToCheck) {
		String loc = ("("+pointToCheck.getXCoord()+","+pointToCheck.getYCoord()+")");
		return loc;
	}

	public Point newLoc() {
		Random rand1 = new Random();
		Random rand2 = new Random();
		int r1 = rand1.nextInt(788);
		int r2 = rand2.nextInt(780);
		Point newPoint = new Point((r1-((r1%30))+8),r2-(r2%30));
		System.out.println(getLoc(newPoint));
		return newPoint;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size2) {
		size = size2;
	}

	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(getTopLeft().getXCoord(), getTopLeft().getYCoord(),getSize() * 2,getSize() * 2);
	}
}
