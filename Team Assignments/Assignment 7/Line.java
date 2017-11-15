public class Line {

  private Point start = new Point(0,0);
  private Point end = new Point(0,0);

  public Line(Point a, Point b){
    setStart(a);
    setEnd(b);
  }

  public void setStart(Point arg) {
    start = new Point(arg);
  }

  public Point getStart() {
    Point temp = new Point(start);
    return temp;
  }

  public void setEnd(Point arg) {
    end = new Point(arg);
  }
  public Point getEnd() {
    Point temp = new Point(end);
    return temp;
  }

  public double length() {
    int x = (start.getXCoord() - end.getXCoord()) * (start.getXCoord() - end.getXCoord());
    int y = (start.getYCoord() - end.getYCoord()) * (start.getYCoord() - end.getYCoord());
    double temp = Math.sqrt(x + y);
    return temp;
  }

  public String toString() {
    return "[" + getStart().toString() + "," + getEnd().toString() + "]";
  }
}
