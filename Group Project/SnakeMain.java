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
            Grid newGrid = new Grid();
            newGrid.printGrid();
            newGrid.userInput();
            newGrid.moveSnake();
            newGrid.printGrid();
        }
    }
