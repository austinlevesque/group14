import static org.junit.Assert.*;

import org.junit.Test;

public class TriangleTest {

  @Test
  public void test_getLine1_privacyLeak() {
    Line line1 = new Line(new Point(1,1), new Point(2,2));
    Line line2 = new Line(new Point(2,2), new Point(2,1));
    Line line3 = new Line(new Point(3,3), new Point(1,1));
    Point p1 = new Point(5,5);

    Triangle t1 = new Triangle(line1, line2, line3);

    t1.getLine1().setStart(p1);

    Point p2 = t1.getLine1().getStart();

    boolean unchanged = p2.equals(new Point(5,5));

    assertTrue("Was able to change start point of line directly via object returned from getter method.", unchanged);

  }

  @Test
  public void test_getLine2_privacyLeak() {
    Line line1 = new Line(new Point(1,1), new Point(2,2));
    Line line2 = new Line(new Point(2,2), new Point(2,1));
    Line line3 = new Line(new Point(3,3), new Point(1,1));
    Point p1 = new Point(5,5);

    Triangle t1 = new Triangle(line1, line2, line3);

    t1.getLine2().setStart(p1);

    Point p2 = t1.getLine2().getStart();

    boolean unchanged = p2.equals(new Point(5,5));

    assertTrue("Was able to change start point of line directly via object returned from getter method.", unchanged);

  }

  @Test
  public void test_getLine3_privacyLeak() {
    Line line1 = new Line(new Point(1,1), new Point(2,2));
    Line line2 = new Line(new Point(2,2), new Point(2,1));
    Line line3 = new Line(new Point(3,3), new Point(1,1));
    Point p1 = new Point(5,5);

    Triangle t1 = new Triangle(line1, line2, line3);

    t1.getLine3().setStart(p1);

    Point p2 = t1.getLine3().getStart();

    boolean unchanged = p2.equals(new Point(5,5));

    assertTrue("Was able to change start point of line directly via object returned from getter method.", unchanged);

  }




}
