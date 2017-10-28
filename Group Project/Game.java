/**
 * Main Class to run the Snake game
 * 
 * @author Austin Levesque
 * @author Chris O'Reilly
 * @author Steven Canon-Almagro
 * @author Victor Chu
 * @author Navjot Saran
 */
public class Game{
	
	static int score;
	
	/**
	 * Runs the game until the game is over or the user quits.
	 */
    public static void main(String[] args){
        boolean gameover = false;
        Snake mainSnake = new Snake(score);
        Grid gameGrid = new Grid(mainSnake,score);
        gameGrid.printGrid();
        while (gameover == false){
        	mainSnake.userInput();
        	mainSnake.moveSnake();
        	gameScore(gameGrid);
        	gameGrid.generateFood();
        	gameGrid.printGrid();
			gameover = mainSnake.gameover;
        }
		System.out.println("Game Over.");
    }
    
    public static int gameScore(Grid gameGrid){
    	if (gameGrid.checkFood() == false){
    		setScore(getScore()+1);
    	}
    	return getScore();
  	}
    
    //getters+setters
    public static int getScore(){
  	  return score;
  	}

  	public static void setScore(int scoreToSet){
  	  score = scoreToSet;
  	}
}
