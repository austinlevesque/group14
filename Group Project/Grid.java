import java.util.Random;

public class Grid{
	
	/**
	* Prints the Grid for the Snake to move on.
	*
	* Grid generation taken from  http://www.dreamincode.net/forums/topic/233382-2-d-array-grid-design/
	* @return void
	*/
	public void printGrid(){
	  System.out.println("Game Score: " + getScore());
	  String[][] arrayGrid = new String[getYlength()][getXlength()];
	  for(int row = 0; row < getXlength(); row++){
		for(int column = 0; column < getYlength(); column++){
			arrayGrid[row][column] = ". ";
			arrayGrid[getFoodY()][getFoodX()] = "* ";
			arrayGrid[getY()][getX()] = "S ";
			for(int j = tailX.size(); j>0; j--){
			//draws the tail and detects if the head has collided with the tail
				if(arrayGrid[(tailY.get(j-1))][tailX.get(j-1)] == "S "){
				//if the head has collided with the tail
					this.gameover = true;
				}else{
					arrayGrid[(tailY.get(j-1))][tailX.get(j-1)] = "s ";
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
		setFoodX(randX.nextInt(xLength));
		setFoodY(randY.nextInt(yLength));
	  }
	}
	
	public static boolean checkFood(){
		boolean flag = true;
		if (getFoodY() == getY() && getFoodX() == getX()){
			flag = false;
		}
		return flag;
	}
	
}
