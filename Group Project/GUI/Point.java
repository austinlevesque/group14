import java.util.ArrayList;
/**
 * Most of this code is used from the code provided in the original Point.java for assingment 5.
 * Heavily edited to check boundary locations and keep the snake perfectly alligned with the grid
 * Class representing a point on the screen.  The top left point on the screen
 * is considered (0,0).  Moving to the right increases the x-coordinate,
 * moving down, increases the y-coordinate.
 */
public class Point {
    private int xcoord = 0;
    private int ycoord = 0;

    public Point(int x, int y){
      xcoord = x;
      ycoord = y;
    }

    public int getXCoord() {
        return xcoord;
    }

    public int getYCoord() {
        return ycoord;
    }

    /**
     * To ensure the point falls on the screen, the xcoordinate must be non-negative.
     * @param xValue the value for the xcoordinate of this point.
     */
    public void setXCoord(int xValue) {
      if(xValue <= 0) {
        xcoord = 788;
      }
      else if(xValue >= 812) {
        xcoord = 8;
      }
      else {
        xcoord = xValue;
      }
    }

    //specifically for text based.
    public void setXCoord1(int xValue) {
        xcoord = xValue;
    }

    /**
     * To ensure the point falls on the screen, the y-coordinate must be non-negative.
     * @param yValue the value for the ycoordinate of this point.
     */
    public void setYCoord(int yValue) {
      if (yValue <= 0) {
        ycoord = 780;
      }
      else if(yValue >= 804) {
        ycoord = 30;
      }
      else {
        ycoord = yValue;
      }
    }

    //specifically for text based.
    public void setYCoord1(int yValue) {
        ycoord = yValue;
    }

    /**
     * Move the point up by the specified amount.
     * @param amount the number to add to the ycoord of this point.
     */
    public void moveUp(int amount) {
    	//To go up on the screen, we need to get closer to zero: we must subtract
        setYCoord(ycoord - amount);
    }

    /**
     * Move the point down by the specified amount.
     * @param amount the number to subtract from the ycoord of this point.
     */
    public void moveDown(int amount) {
    	// to go down we need to go further away from 0
        setYCoord(ycoord + amount);
    }

    /**
     * Move the point right (or east) the specified amount.
     * @param amount the number to add to the xcoord of this point.
     */
    public void moveRight(int amount) {
        setXCoord(xcoord + amount);
    }

    /**
     * Move the point left (or west) by the specified amount.
     * @param amount the number to subtract from the xcoord of this point.
     */
    public void moveLeft(int amount) {
        setXCoord(xcoord - amount);
    }
}
