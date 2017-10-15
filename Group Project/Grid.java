/**
* Main Operating Class.
*/

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Grid{

	/**
	* Variables
	* Future note: Will need to add a direction to indicate where the head is travelling
	* tailX - previous X coordinates of the head
	* tailY - previous Y coordinates of the head
	*/
	int x = 9;
	int y = 9;
	int foodX = 5;
	int foodY = 5;
	String input;
	int yLength = 10;
	int xLength = 10;
	int score;
	int tail = 0;
	boolean gameover = false;
	List<Integer> tailX = new ArrayList<Integer>();
	List<Integer> tailY = new ArrayList<Integer>();
	

	/**
	* Updates 2 lists of X and Y values
	* The lists' length cannot exceed the tail length
	* method called in moveSnake()
	* 
	* @return void
	*/
	public void updateTail(int prevX, int prevY){
		int tail = score;
		tailX.add(prevX);
		tailY.add(prevY);
		if (tailX.size() > tail){
		System.out.println("Tail end Position:"+tailX.get(0)+","+tailY.get(0));
			while(tailX.size() > tail){
				tailX.remove(0);
				tailY.remove(0);
			}
		}
	}
	
	public int gameScore(){
	  if (checkFood() == false){
		setScore(getScore()+1);
	  }
	  return getScore();
	}

	/**
	* Prints the Grid for the Snake to move on.
	*
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

	/**
	* Checks for food on grid.
	*
	* @return boolean
	*/

	public boolean checkFood(){
	boolean flag = true;
	if (getFoodY() == getY() && getFoodX() == getX()){
	  flag = false;
	}
	return flag;
	}

	/**
	* Generates more "s" body parts when it eats "*"
	*
	* @return
	*/

	public void generateBody(){
		if (checkFood() == false){
			
		}
	}

	/**
	* Prompts user for movement of the snake in any direction according to "a", "s", "w" and "d".
	* Austin: Added input reading for "q" to quit the game
	* Checks if user input is a valid key for movement.
	*
	* @return boolean
	*/

	public boolean userInput(){
		boolean valid = false;
		while (valid == false){
			Scanner keyboard = new Scanner(System.in);
			System.out.println("movement: ");
			setInput(keyboard.nextLine());
			if (input.equals("w") || input.equals("a") ||input.equals("s") ||input.equals("d") || input.equals("q")){
				valid = true;
			}else{
			System.out.println("Invalid input! Please use WASD to move or enter 'q' to quit");
			}
		}
		return valid;
	}

	/**
	* Takes key input and checks which way for snake to move.
	*
	* @return void
	*/

	public void moveSnake(){
		int moveY = getY();
		int moveX = getX();
		updateTail(getX(),getY());
		//stores previous location data for the tail

		if (input.equals("w")){
		  moveY--;
			if (moveY < 0) {
			  moveY = getYlength() - 1;
			}
		  setY(moveY);
		}
		else if (input.equals("s")){
		  moveY++;
			if (moveY > getYlength() - 1) {
			  moveY = getYlength() - getYlength();
			}
		  setY(moveY);
		}
		else if (input.equals("a")){
		  moveX--;
			if (moveX < 0) {
			  moveX = getXlength() - 1;
			}
		  setX(moveX);
		}
		else if (input.equals("d")){
		  moveX++;
			if (moveX > getXlength() - 1){
			  moveX = getXlength() - getXlength();
			}
		  setX(moveX);
		}else{
			this.gameover = true;
		}
		System.out.println("Head Position:"+moveX+","+moveY);
	}

	/**
	* Quits the game when called in moveSnake() after the user inputs the character 'q'
	* Removed and added its functionality to main class
	*/
	/*
	public void quit(){
		System.out.println("Quitting game.");
		this.gameover = true;
	}
	*/

	/**
	* getter/setter methods
	*
	* @return int
	* @return void
	*/

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public void setX(int sx){
		x = sx;
	}

	public void setY(int sy){
		y = sy;
	}

	public String getInput(){
	  return input;
	}

	public void setInput(String s){
	  input = s;
	}

	public int getXlength(){
	  return xLength;
	}
	public int getYlength(){
	  return yLength;
	}

	public int getFoodX(){
	  return foodX;
	}

	public void setFoodX(int x){
	  foodX = x;
	}

	public int getFoodY(){
	  return foodY;
	}

	public void setFoodY(int y){
	  foodY = y;
	}

	public int getScore(){
	  return score;
	}

	public void setScore(int scoreToSet){
	  score = scoreToSet;
	}
}
