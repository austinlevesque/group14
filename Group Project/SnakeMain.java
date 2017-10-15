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
        boolean gameover = false;
        Grid newGrid = new Grid();
        newGrid.printGrid();
        while (gameover == false){
            newGrid.userInput();
            newGrid.moveSnake();
            newGrid.gameScore();
            newGrid.generateFood();
            newGrid.printGrid();
			gameover = newGrid.gameover;
        }
    }
}
