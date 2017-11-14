
public class Point {

  private int xcoord;
  private int ycoord;

  public Point(int x, int y) {
    setXCoord(x);
    setYCoord(y);
  }

  public Point(Point pointToCopy) {
    setXCoord(pointToCopy.getXCoord());
    setYCoord(pointToCopy.getYCoord());
  }

  public void setXCoord(int x) {
    if(x >= 0){
      xcoord = x;
    }
    else if(x < 0 && getXCoord() > 0) {
    }
    else {
      xcoord = 0;
    }
  }

  public int getXCoord() {
    return xcoord;
  }

  public void setYCoord(int y) {
    if(y >= 0) {
      ycoord = y;
    }
    else if(y < 0 && getYCoord() > 0) {
    }
    else{
      ycoord = 0;
    }
  }

  public int getYCoord() {
    return ycoord;
  }

  public void moveUp(int dist) {
    setYCoord(getYCoord() - dist);
  }

  public void moveDown(int dist) {
    setYCoord(getYCoord() + dist);
  }

  public void moveRight(int dist) {
    setXCoord(getXCoord() + dist);
  }

  public void moveLeft(int dist) {
    setXCoord(getXCoord() - dist);
  }

  public double distance(Point arg) {
    int x;
    int y;
    double dist;
    x = (arg.getXCoord() - getXCoord()) * (arg.getXCoord() - getXCoord());
    y = (arg.getYCoord() - getYCoord()) * (arg.getYCoord() - getYCoord());
    dist = Math.sqrt(x + y);
    return dist;
  }

  public boolean equals(Point arg) {
    boolean flag = false;
    if (arg.getXCoord() == getXCoord() && arg.getYCoord() == getYCoord()) {
      flag = true;
    }
    return flag;
  }
}
