import java.util.Scanner;

public class Grid {

int x = 0;
int y = 0;

public void printGrid() {
  String[][] arrayGrid = new String[10][10];

  for(int row = 0; row < 10; row++)
  {
    for(int column = 0; column < 10; column++)
    {
        arrayGrid[row][column] = ". ";
        
        arrayGrid[getX()][getY()] = "S ";

        System.out.print(arrayGrid[row][column]);
    }
    System.out.println();
    
  }
}

public boolean userInput() {
    boolean valid = false; 
    while (valid == false) {    
        Scanner keyboard = new Scanner(System.in);
        System.out.println("movement: ");
        String rawInput = keyboard.nextLine();
        inputValid(rawInput);
        valid = true;
    
    }
    moveSnake(rawInput);
    return valid;

}

public boolean inputValid(String rawInput) {
        System.out.println(rawInput);   
        boolean valid = false;
        if (rawInput.equals("w") || rawInput.equals("a") ||rawInput.equals("s") ||rawInput.equals("d")) {
            valid = true;    
        } 
        else {
        System.out.println("false");
        userInput();
        }
        moveSnake(rawInput);

    return valid;
}
public int getX() {
    return this.x;
}

public int getY() {
    return this.y;
}

public int setX(int sx) {
    x = sx;
    return this.x; 
}

public int setY(int sy) {
    y = sy;
    return this.y;
} 

public void moveSnake(String rawInput) {
    if (rawInput.equals("w")) {
        setX(getX + 1);        
        printGrid();    
    }
}
/*
public static setX(String rawInput) {
    if (rawInput.equals("w")) {
        x -= 1;
    if (rawInput.equals("S")) {

    
}*/



}
