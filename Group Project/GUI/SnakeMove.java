
public class SnakeMove {

  Point topLeft = new Point(0,0);
  int size;
  int score = 0;
  String direction = "down";

  public GameObject(Point snakeTopLeft, int snakeSize) {
    topLeft = snakeTopLeft;
    size = snakeSize;
  }

  public void moveDir(int amount) {
    if (direction == "down"){
      topLeft.moveDown(amount);
    }else if (direction == "up") {
      topLeft.moveUp(amount);
    }else if (direction == "left"){
      topLeft.moveLeft(amount);
    } else {
      topLeft.moveRight(amount);
    }
  }


}
