
/**
 * Main Operating Class.
 */

import java.util.Scanner;
import java.util.Random;

public class Grid {

  int x = 9;
  int y = 9;
  int foodX;
  int foodY;
  String input;
  int yLength = 10;
  int xLength = 10;

/**
 * Prints the Grid for the Snake to move on.
 *
 * @return void
 */

public void printGrid() {
  String[][] arrayGrid = new String[getYlength()][getXlength()];
  for(int row = 0; row < getXlength(); row++) {
    for(int column = 0; column < getYlength(); column++) {
        arrayGrid[row][column] = ". ";
        arrayGrid[getY()][getX()] = "S ";
        arrayGrid[getFoodY()][getFoodX()] = "* ";
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

public void generateFood() {
  Random randX = new Random();
  Random randY = new Random();
  setFoodX(randX.nextInt(xLength));
  setFoodY(randY.nextInt(yLength));
}



/**
 * Prompts user for movement of the snake in any direction according to "a", "s", "w" and "d".
 * Checks if user input is a valid key for movement.
 *
 * @return boolean
 */

public boolean userInput() {
    boolean valid = false;
    while (valid == false) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("movement: ");
        setInput(keyboard.nextLine());
        if (input.equals("w") || input.equals("a") ||input.equals("s") ||input.equals("d")) {
            valid = true;
        }
        else {
        System.out.println("false");
        }
      }
      return valid;
}

/**
 * Takes key input and checks which way for snake to move.
 *
 * @return void
 */

public void moveSnake() {
    int moveY = getY();
    int moveX = getX();

    if (input.equals("w")) {
      moveY--;
        if (moveY < 0) {
          moveY = getYlength() - 1;
        }
      setY(moveY);
    }
    else if (input.equals("s")) {
      moveY++;
        if (moveY > getYlength() - 1) {
          moveY = getYlength() - getYlength();
        }
      setY(moveY);
    }
    else if (input.equals("a")) {
      moveX--;
        if (moveX < 0) {
          moveX = getXlength() - 1;
        }
      setX(moveX);
    }
    else if (input.equals("d")) {
      moveX++;
        if (moveX > getXlength() - 1) {
          moveX = getXlength() - getXlength();
        }
      setX(moveX);
    }

}

/**
 * getter/setter methods
 *
 * @return int
 * @return void
 */

public int getX() {
    return x;
}

public int getY() {
    return y;
}

public void setX(int sx) {
    x = sx;
}

public void setY(int sy) {
    y = sy;
}

public String getInput() {
  return input;
}

public void setInput(String s) {
  input = s;
}

public int getXlength() {
  return xLength;
}
public int getYlength() {
  return yLength;
}

public int getFoodX() {
  return foodX;
}

public void setFoodX(int x) {
  foodX = x;
}

public int getFoodY() {
  return foodY;
}

public void setFoodY(int y) {
  foodY = y;
}



}
