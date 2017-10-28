import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 * Snake object for the game project
 * 
 * @verison 1.1
 * @author Austin Levesque
 * @author Chris O'Reilly
 * @author Steven Canon-Almagro
 * @author Victor Chu
 * @author Navjot Saran
 */
public class Snake{
	
	//Variables
	//Future note: Will need to add a direction to indicate where the head is travelling
	int score;
	int x = 9;
	int y = 9;
	int foodX = 5;
	int foodY = 5;
	String input;
	int xLength = 10;
	int yLength = 10;
	int tail = 0;
	boolean gameover = false;
	List<Integer> tailX = new ArrayList<Integer>();
	List<Integer> tailY = new ArrayList<Integer>();
	

	public Snake(int scr){
		score = scr;
	}
	
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

	/**
	* Checks for food on grid.
	*
	* @return boolean
	*/

	
	/**
	* Generates more "s" body parts when it eats "*"
	* Flagged for deletion. Method works the same way as tailUpdate()
	* @return
	*/

	/*
	public void generateBody(){
		if (checkFood() == false){
			
		}
	}
	*/

	/**
	 * Prompts user for movement of the snake in any direction using "w", "a", "s", "d" or the "q" key to quit.
	 * Checks if user input is a valid key for movement.
	 * TO-DO: Need try+finally statements with the finally running a in.close(); to close the keyboard listener
	 * https://stackoverflow.com/questions/12519335/resource-leak-in-is-never-closed
	 * This may be resolved when we use event listeners
	 * 
	 * @return valid: boolean - Based on if the input is valid or not
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

	//getters+setters
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
}
