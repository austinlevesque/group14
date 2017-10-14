/**
 * Main Class that runs the game.
 *
 * @Victor
 * @Steven
 * @Chris
 * @Austin
 * @Nav
 */
 
public class SnakeMain {

    public static void main(String[] args){
        boolean gameOver = false;
        Grid newGrid = new Grid();
        newGrid.printGrid();
        while (gameOver == false) {        
            newGrid.userInput();
            newGrid.moveSnake();
            newGrid.printGrid();

        }
    }
}
