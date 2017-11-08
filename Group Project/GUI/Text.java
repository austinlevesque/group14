import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Text {

  private final int ARRAY_X = 10, ARRAY_Y = 10;
  Snake snake = new Snake(new Point (1,1), 0);
  Food food = new Food(new Point(0,0), 0);
  String input;
  boolean runningGame = true;


  List<Integer> tailX = new ArrayList<Integer>();
  List<Integer> tailY = new ArrayList<Integer>();

  public boolean grid() {
    System.out.println("Game Score: " + snake.score);
    String[][] arrayGrid = new String[ARRAY_X][ARRAY_Y];
    for(int row = 0; row < ARRAY_X; row++) {
		    for(int column = 0; column < ARRAY_Y; column++) {
          arrayGrid[row][column] = ". ";
          arrayGrid[food.getTopLeft().getYCoord()][food.getTopLeft().getXCoord()] = "* ";
          arrayGrid[snake.getTopLeft().getYCoord()][snake.getTopLeft().getXCoord()] = "S ";
          for(int j = snake.tail.size(); j>0; j--){
            if(arrayGrid[snake.tail.get(j-1).getYCoord()][snake.tail.get(j-1).getXCoord()] == "S "){
            //if the head has collided with the tail
              runningGame = false;
            }
            else {
              arrayGrid[snake.tail.get(j-1).getYCoord()][snake.tail.get(j-1).getXCoord()] = "s ";
            }
          }
          System.out.print(arrayGrid[row][column]);
        }
        System.out.println();
    }
    return runningGame;
  }

  /*
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
   */

   public boolean getRunningGame() {
     return runningGame;
   }


  public boolean eat(){
    boolean flag = false;
    if (snake.getTopLeft().getXCoord() == food.getTopLeft().getXCoord() && snake.getTopLeft().getYCoord() == food.getTopLeft().getYCoord()){
      flag = true;
    }
    return flag;
  }

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

  public void moveSnake(){

		int moveX = snake.getTopLeft().getXCoord();
    int moveY = snake.getTopLeft().getYCoord();
		snake.updateTail(moveX, moveY);
		//stores previous location data for the tail
		if (input.equals("w")){
      moveY--;
      if (moveY < 0) {
        moveY = ARRAY_Y - 1;
      }
      snake.getTopLeft().setYCoord1(moveY);
		}
		else if (input.equals("s")){
      moveY++;
     if (moveY > ARRAY_Y - 1) {
       moveY = 0;
     }
     snake.getTopLeft().setYCoord1(moveY);
		}
		else if (input.equals("a")){
      moveX--;
     if (moveX < 0) {
       moveX = ARRAY_X - 1;
     }
     snake.getTopLeft().setXCoord1(moveX);
		}
		else if (input.equals("d")){
      moveX++;
      if (moveX > ARRAY_X - 1){
        moveX = 0;
      }
      snake.getTopLeft().setXCoord1(moveX);
		}
    else {
			runningGame = false;
		}
		if (snake.tail.size() > 0){
			System.out.println("Tail Position:"+snake.tail.get(0).getXCoord()+","+snake.tail.get(0).getYCoord());
		}
		System.out.println("Head Position:"+moveX+","+moveY);
	}

  public void setInput(String s){
	  input = s;
	}

    public static void main(String[] args) {
      Text run = new Text();
      boolean running = true;
      while(running){
        running = run.grid();
        run.grid();
        run.userInput();
        run.moveSnake();
        if(run.eat()) {
          run.food = new Food(run.food.newLoc(10), 0);
          run.snake.score++;
        }
        running = run.grid();
      }
      System.out.println("Game Over.");
    }
}
