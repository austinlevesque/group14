	//Text-base variables
	public final int ARRAY_X = 10, ARRAY_Y = 10;
	private Snake textSnakeA = new Snake(new Point(1, 1), 0);
	private Snake textSnakeB = new Snake(new Point(9,9), 0);
	private Food textFood = new Food(new Point(0, 0), 0);
	private boolean runningGame = true;
  
  	/**
	 * Creates the visual grid through print statements using a standard
	 * nested/double for loop 2D grid of Strings Note, these are strings and not
	 * characters because they include a space
	 * 
	 * @return boolean
	 */ 
	public boolean grid() {
		System.out.println("ScoreA: " + textSnakeA.getScore() + " || " + "ScoreB: " + textSnakeB.getScore());
		String[][] arrayGrid = new String[ARRAY_X][ARRAY_Y];
		for (int row = 0; row < ARRAY_X; row++) {
			for (int column = 0; column < ARRAY_Y; column++) {
				arrayGrid[row][column] = ". ";
				arrayGrid[getTextFood().getTopLeft().getYCoord()][getTextFood().getTopLeft().getXCoord()] = "* ";
				arrayGrid[textSnakeA.getTopLeft().getYCoord()][textSnakeA.getTopLeft().getXCoord()] = "A ";
				arrayGrid[textSnakeB.getTopLeft().getYCoord()][textSnakeB.getTopLeft().getXCoord()] = "B ";
				
				for (int j = textSnakeA.getTail().size(); j > 0; j--) {
					if (arrayGrid[textSnakeA.getTail().get(j - 1).getYCoord()][textSnakeA.getTail().get(j - 1)
							.getXCoord()] == "A ") {
						// if the headA has collided with the tail
						runningGame = false;
					} else {
						arrayGrid[textSnakeA.getTail().get(j - 1).getYCoord()][textSnakeA.getTail().get(j - 1)
								.getXCoord()] = "s ";
					}
				}
				System.out.print(arrayGrid[row][column]);
			}
			System.out.println();
		}
		return runningGame;
	}
  
  	public Snake getTextSnakeA() {
		return textSnakeA;
	}

	public Snake getTextSnakeB() {
		return textSnakeB;
	}
  
  	public Food getTextFood() {
		return textFood;
	}
	
	public void setTextFood(Point p, int i) {
		textFood = new Food(p,i);
	}
