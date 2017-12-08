package run;

import move.*;
import java.util.Scanner;

import gameobjects.*;

/**
 * Text based code for Snake Game Project
 * 
 * @author Austin Levesque
 * @author Chris O'Reilly
 * @author Steven Canon-Almagro
 * @author Victor Chu
 * @author Navjot Saran
 *
 */
public class Textbase_Run {
	
	/**
	 * Runs the game as well as generates new food locations when the food has been
	 * eaten + updates the score Runs on a while loop until the game has ended
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GameBoard run = new GameBoard();
		KeyboardInput k = new KeyboardInput();
		boolean running = true;
		while (running) {
			running = run.grid();
			run.grid();
			k.userInput();
			run.getTextSnakeA().textMoveSnakeA(run.ARRAY_X,run.ARRAY_Y, k.getInput());
			if (run.getTextSnakeA().eat(run.getTextFood())) {
				run.setTextFood(run.getTextFood().newLoc(10), 0);
				run.getTextSnakeA().setScore(run.getTextSnakeA().getScore() + 1);
			}
			running = run.grid();
		}
		System.out.println("Game Over.");
	}
}
