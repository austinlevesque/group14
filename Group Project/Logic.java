package gameObjects;

import move.Point;
import java.awt.*;
import java.util.Random;

/**
 * Logic Class for Snake Game Project
 * 
 * @author Austin Levesque
 * @author Chris O'Reilly
 * @author Steven Canon-Almagro
 * @author Victor Chu
 * @author Navjot Saran
 *
 */
public abstract class Logic {

	private Point topLeft = new Point(0, 0);
	private int size;
	private int score = 0;
	private String direction = "down";
	// private boolean checkFood = false;

	/**
	 * Default Constructor
	 * 
	 * @param snakeTopLeft
	 * @param snakeSize
	 */
	public Logic(Point snakeTopLeft, int snakeSize) {
		topLeft = snakeTopLeft;
		size = snakeSize;
	}

	/**
	 * @param snakeLoc
	 * @param foodLoc
	 * @return boolean
	 */
	public boolean foodBoolean(String snakeLoc, String foodLoc) {
		if (snakeLoc.equals(foodLoc)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Moves the snake object in the direction it's facing by 'amount' units
	 * 
	 * @param amount
	 */
	public void moveDir(int amount) {
		if (direction == "down") {
			topLeft.moveDown(amount);
		} else if (direction == "up") {
			topLeft.moveUp(amount);
		} else if (direction == "left") {
			topLeft.moveLeft(amount);
		} else {
			topLeft.moveRight(amount);
		}
	}

	/**
	 * Generates a new random point
	 * 
	 * @param range
	 * @return Randomly generated Point
	 */
	public Point newLoc(int range) {
		int r1;
		int r2;
		Random rand1 = new Random();
		Point newPoint = new Point(0, 0);
		if (range == 26) {
			r1 = rand1.nextInt(26) * 30 + 8;
			r2 = rand1.nextInt(26) * 30;
			newPoint.setXCoord(r1);
			newPoint.setYCoord(r2);
		} else if (range == 10) {
			r1 = rand1.nextInt(9) + 1;
			r2 = rand1.nextInt(9) + 1;
			newPoint.setXCoord1(r1);
			newPoint.setYCoord1(r2);
		}
		// System.out.println(getLoc(newPoint));
		return newPoint;
	}

	/**
	 * Takes a point as an argument and returns it in a string format
	 * 
	 * @param pointToCheck
	 * @return String of point provided "(x,y)"
	 */
	public String getLoc(Point pointToCheck) {
		String loc = ("(" + pointToCheck.getXCoord() + "," + pointToCheck.getYCoord() + ")");
		return loc;
	}

	public Point getTopLeft() { // tested
		return topLeft;
	}

	public int getSize() { // tested
		return size;
	}

	public int getScore() { // tested
		return score;
	}

	public String getDir() {
		return direction;
	}

	/*
	 * public void setTopLeft(Point newTopLeft) { topLeft = newTopLeft; }
	 */

	public void setSize(int newSize) { // tested
		if (newSize >= 1) {
			size = newSize;
		}
	}

	public void setScore(int newScore) { // tested
		if (newScore >= 0) {
			score = newScore;
		}
	}

	public void setDir(String newDir) {
		direction = newDir;
	}

	/**
	 * Draw Method for GUI
	 */
	public abstract void draw(Graphics g);
}
