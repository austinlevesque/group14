import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Text {

  private final int ARRAY_X = 10, ARRAY_Y = 10;
  GameObject snake = new Snake(new Point (1,1), 0);
  GameObject food = new Food(new Point(0,0), 0);
  String input;

  public void grid() {
    System.out.println("Game Score: " + snake.score);
    String[][] arrayGrid = new String[ARRAY_X][ARRAY_Y];
    for(int row = 0; row < ARRAY_X; row++) {
		    for(int column = 0; column < ARRAY_Y; column++) {
          arrayGrid[row][column] = ". ";
          arrayGrid[food.getTopLeft().getYCoord()][food.getTopLeft().getXCoord()] = "* ";
          arrayGrid[snake.getTopLeft().getYCoord()][snake.getTopLeft().getXCoord()] = "S ";
          System.out.print(arrayGrid[row][column]);
        }
        System.out.println();
    }
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
		//updateTail(getX(),getY());
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
    /*else{
			this.running = false;
		}*/
		System.out.println("Head Position:"+moveX+","+moveY);
	}

  public void setInput(String s){
	  input = s;
	}

    public static void main(String[] args) {
      boolean running = true;
      Text run = new Text();
      while(running){
        run.grid();
        run.userInput();
        run.moveSnake();
        if(run.eat()) {
          run.food = new Food(run.food.newLoc(10), 0);
          run.snake.score++;
        }
      }
    }
}
