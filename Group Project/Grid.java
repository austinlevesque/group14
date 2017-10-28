import java.util.Random;

public class Grid{
	
	int score;
	Snake mainSnake;
	
	//Constructors
	public Grid(){
	}
	
	public Grid(Snake main,int scr){
		mainSnake = main;
		score = scr;
	}
	
	/**
	* Prints the Grid for the Snake to move on.
	*
	* Grid generation taken from  http://www.dreamincode.net/forums/topic/233382-2-d-array-grid-design/
	* @return void
	*/
	public void printGrid(){
	  System.out.println("Game Score: " + getScore());
	  String[][] arrayGrid = new String[mainSnake.getYlength()][mainSnake.getXlength()];
	  for(int row = 0; row < mainSnake.getXlength(); row++){
		for(int column = 0; column < mainSnake.getYlength(); column++){
			arrayGrid[row][column] = ". ";
			arrayGrid[mainSnake.getFoodY()][mainSnake.getFoodX()] = "* ";
			arrayGrid[mainSnake.getY()][mainSnake.getX()] = "S ";
			for(int j = mainSnake.tailX.size(); j>0; j--){
			//draws the tail and detects if the head has collided with the tail
				if(arrayGrid[(mainSnake.tailY.get(j-1))][mainSnake.tailX.get(j-1)] == "S "){
				//if the head has collided with the tail
					mainSnake.gameover = true;
				}else{
					arrayGrid[(mainSnake.tailY.get(j-1))][mainSnake.tailX.get(j-1)] = "s ";
				}
			}
			System.out.print(arrayGrid[row][column]);
		}
		System.out.println();
	  }
	}
	
	/**
	* Generates random coordinates for the food.
	*
	* @return int
	*/

	public void generateFood(){
	  while (checkFood() == false){
		Random randX = new Random();
		Random randY = new Random();
		mainSnake.setFoodX(randX.nextInt(mainSnake.xLength));
		mainSnake.setFoodY(randY.nextInt(mainSnake.yLength));
	  }
	}
	
	public boolean checkFood(){
		boolean flag = true;
		if (mainSnake.getFoodY() == mainSnake.getY() && mainSnake.getFoodX() == mainSnake.getX()){
			flag = false;
		}
		return flag;
	}
	
	public int getScore(){
	  	  return score;
  	}

  	public void setScore(int scoreToSet){
  	  score = scoreToSet;
  	}
	
}
