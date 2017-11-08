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
	
	ArrayList<Point> tail = new ArrayList<Point>();
	ArrayList<Snake> tailSnakes = new ArrayList<Snake>();
	ArrayList<String> tailStrings = new ArrayList<String>();
	//can't think of a better way to use the contains() method than with a string list

	public Snake(Point snakeTopLeft, int snakeSize) {
		super(snakeTopLeft, snakeSize);
	}

	public void draw(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(getTopLeft().getXCoord(), getTopLeft().getYCoord(),getSize() * 2,getSize() * 2);
	}
	
	public void updateTail(int prevPtX,int prevPtY){
		Point prevPt = new Point(prevPtX,prevPtY);
	    tail.add(prevPt);
	    tailStrings.add(getLoc(prevPt));
	    Snake tempTail = new Snake(prevPt, 15);
	    tailSnakes.add(tempTail);
	    if ((tail.size()) > score) {
	      while((tail.size()) > score){
	        tail.remove(0);
	        tailSnakes.remove(0);
	        tailStrings.remove(0);
	      }
	    }
	}
}
