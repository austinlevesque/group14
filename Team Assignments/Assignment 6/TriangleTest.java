import static org.junit.Assert.*;

import org.junit.Test;


/*
- check if lines form a triangle.
-
*/

public class TriangleTest {

  @Test
  public void test_getLine1_privacyLeak() {
    Line line1 = new Line(new Point(1,1), new Point(2,2));
    Line line2 = new Line(new Point(2,2), new Point(2,1));
    Line line3 = new Line(new Point(2,1), new Point(1,1));
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
    Line line3 = new Line(new Point(2,1), new Point(1,1));
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
    Line line3 = new Line(new Point(2,1), new Point(1,1));
    Point p1 = new Point(5,5);

    Triangle t1 = new Triangle(line1, line2, line3);

    t1.getLine3().setStart(p1);

    Point p2 = t1.getLine3().getStart();

    boolean unchanged = p2.equals(new Point(5,5));

    assertTrue("Was able to change start point of line directly via object returned from getter method.", unchanged);
  }

  @Test
  public void test_getCircumference() {
    Line line1 = new Line(new Point(1,1), new Point(2,2));  //root 2
    Line line2 = new Line(new Point(2,2), new Point(2,1));  //1
    Line line3 = new Line(new Point(2,1), new Point(1,1));  //root8

    Triangle t1 = new Triangle(line1, line2, line3);
    double circumference = t1.getCircumference();

    assertEquals("Triangle circumference should be", 5.242641, circumference, 0.00001);
  }

  @Test
  public void test_getArea_RightTriangle() {
    Line line1 = new Line(new Point(1,1), new Point(2,2));  //root 2
    Line line2 = new Line(new Point(2,2), new Point(2,1));  //1
    Line line3 = new Line(new Point(2,1), new Point(1,1));  //root8

    Triangle t1 = new Triangle(line1, line2, line3);
    double circumference = t1.getCircumference();

    assertEquals("Triangle circumference should be", 5.242641, circumference, 0.00001);
  }

  /*
  @Test
  public void test_defaultLine() {
    Line line1 = new Line(new Point(1,1), new Point(1,1));
    Line line2 = new Line(new Point(1,1), new Point(1,1));
    Line line3 = new Line(new Point(1,1), new Point(1,1));

    Triangle t1 = new Triangle(line1, line2, line3);

    Point p1 = t1.getLine1().getStart();
    Point p2 = t1.getLine2().getStart();
    Point p3 = t1.getLine3().getStart();
    Point p4 = t1.getLine1().getEnd();
    Point p5 = t1.getLine2().getEnd();
    Point p6 = t1.getLine3().getEnd();


    boolean unchanged = p1.equals(new Point());


    assertTrue("Was able to change start point of line directly via object returned from getter method.", unchanged);
  } */




}
