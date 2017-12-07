package gameobjects;

import move.Point;

public class GameBoard {

	private static final int SHAPE_SIZE = 15;
	private Point p1 = new Point(8, 30);
	private Point p2 = new Point(98, 120);
	private Point p3 = new Point(788, 780);
	private Snake aSnake = new Snake(p1, SHAPE_SIZE);
	private Snake bSnake = new Snake(p3, SHAPE_SIZE);
	private Food aFood = new Food(p2, SHAPE_SIZE);

	public void guiUpdateSnake() {
		aSnake.updateTail(p1.getXCoord(), p1.getYCoord());
		bSnake.updateTail(p3.getXCoord(), p3.getYCoord());
		aSnake.moveDir(30);
		bSnake.moveDir(30);
		if (aSnake.getTailStrings().contains(aSnake.getLoc(p1))) {
			System.out.println("Game over");
			resetGame();
		}
		if (aSnake.getLoc(aSnake.getTopLeft()).equals(aFood.getLoc(aFood.getTopLeft()))) {
			aSnake.setScore(aSnake.getScore() + 1);
			aFood = new Food(aFood.newLoc(26), 15);
		}
		if (bSnake.getLoc(bSnake.getTopLeft()).equals(aFood.getLoc(aFood.getTopLeft()))) {
			bSnake.setScore(bSnake.getScore() + 1);
			aFood = new Food(aFood.newLoc(26), 15);
		}
	}

	public void resetGame() {
		final int SHAPE_SIZE = 15;
		p1 = new Point(8, 30);
		p2 = new Point(98, 120);
		p3 = new Point(788, 780);
		aSnake = new Snake(p1, SHAPE_SIZE);
		bSnake = new Snake(p3, SHAPE_SIZE);
		aFood = new Food(p2, SHAPE_SIZE);
	}

	public Snake getSnakeA() {
		return aSnake;
	}

	public Snake getSnakeB() {
		return bSnake;
	}

	public Food getFood() {
		return aFood;
	}
}
