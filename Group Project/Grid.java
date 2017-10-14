
/**
 * Main Operating Class.
 */

import java.util.Scanner;

public class Grid {

  int x = 5;
  int y = 5;
  String input;

/**
 * Prints the Grid for the Snake to move on.
 *
 * @return void
 */

public void printGrid() {
  String[][] arrayGrid = new String[10][10];
  for(int row = 0; row < 10; row++) {
    for(int column = 0; column < 10; column++) {
        arrayGrid[row][column] = ". ";
        arrayGrid[getY()][getX()] = "S ";
        System.out.print(arrayGrid[row][column]);
    }
    System.out.println();
  }
}

/**
 * Prompts user for movement of the snake.
 *
 * @return void  description
 */

public void userInput() {
  Scanner keyboard = new Scanner(System.in);
  System.out.println("movement: ");
  setInput(keyboard.nextLine());
}

/**
 * Checks if user input is a valid key for movement.
 *
 * @return boolean
 */

public boolean inputValid() {
  boolean valid = false;
    while (valid == false) {
      System.out.println(input);
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
      setY(moveY);
    }
    else if (input.equals("s")) {
      moveY++;
      setY(moveY);
    }
    else if (input.equals("a")) {
      moveX--;
      setX(moveX);
    }
    else if (input.equals("d")) {
      moveX++;
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

}
