import static org.junit.Assert.*;

import org.junit.Test;

public class TriangleTest {

	@Test
	public void test_getLine1_PrivacyLeak() {
		Line line1 = new Line(new Point(1,1), new Point(2,2));
		Line line2 = new Line(new Point(2,2), new Point(2,1));
		Line line3 = new Line(new Point(3,3), new Point(1,1));
		Point p1 = new Point(5,5);

		Triangle t1 = new Triangle(line1, line2, line3);

		t1.getLine1().setStart(p1);

		Point p2 = t1.getLine1().getStart();

		boolean unchanged = p2.equals(new Point(5,5));

		assertTrue("Was able to change start point of line directly via object returned from getter method.", !unchanged);

	  }

	@Test
	public void test_getLine2_PrivacyLeak() {
		Line line1 = new Line(new Point(1,1), new Point(2,2));
		Line line2 = new Line(new Point(2,2), new Point(2,1));
		Line line3 = new Line(new Point(3,3), new Point(1,1));
		Point p1 = new Point(5,5);

		Triangle t1 = new Triangle(line1, line2, line3);

		t1.getLine2().setStart(p1);

		Point p2 = t1.getLine2().getStart();

		boolean unchanged = p2.equals(new Point(5,5));

		assertTrue("Was able to change start point of line directly via object returned from getter method.", !unchanged);

	}

	@Test
	public void test_getLine3_PrivacyLeak() {
		Line line1 = new Line(new Point(1,1), new Point(2,2));
		Line line2 = new Line(new Point(2,2), new Point(2,1));
		Line line3 = new Line(new Point(3,3), new Point(1,1));
		Point p1 = new Point(5,5);

		Triangle t1 = new Triangle(line1, line2, line3);

		t1.getLine3().setStart(p1);

		Point p2 = t1.getLine3().getStart();

		boolean unchanged = p2.equals(new Point(5,5));

		assertTrue("Was able to change start point of line directly via object returned from getter method.", !unchanged);

	}

	@Test 
	public void test_getCircumference_AllPointsZero(){
		Line line1 = new Line(new Point(0,0), new Point(0,0));
		Line line2 = new Line(new Point(0,0), new Point(0,0));
		Line line3 = new Line(new Point(0,0), new Point(0,0));

		Triangle t1 = new Triangle(line1, line2, line3);
		assertEquals("Circumference for triangle with coordinates (0,0), (0,0), (0,0) should be zero.", 0, t1.getCircumference(), 0.001);
	}		
	
	@Test 
	public void test_getArea_AllPointsZero() {
		Line line1 = new Line(new Point(0,0), new Point(0,0));
		Line line2 = new Line(new Point(0,0), new Point(0,0));
		Line line3 = new Line(new Point(0,0), new Point(0,0));

		Triangle t1 = new Triangle(line1, line2, line3);
		assertEquals("Area for triangle with coordinates (0,0), (0,0), (0,0) should be zero.", 0, t1.getArea(), 0.001);
	}
	
	@Test 
	public void test_getCircumference_RightAngle() {
		Line line1 = new Line(new Point(0,0), new Point(3,0));
		Line line2 = new Line(new Point(0,0), new Point(0,4));
		Line line3 = new Line(new Point(0,4), new Point(3,0));

		Triangle t1 = new Triangle(line1, line2, line3);
		assertEquals("Circumference for triangle with coordinates (0,0), (0,4), (3,0) should be 12.", 12, t1.getCircumference(), 0.001);
	}
	
	@Test 
	public void test_getArea_RightAngle() {
		Line line1 = new Line(new Point(0,0), new Point(3,0));
		Line line2 = new Line(new Point(0,0), new Point(0,4));
		Line line3 = new Line(new Point(0,4), new Point(3,0));

		Triangle t1 = new Triangle(line1, line2, line3);
		assertEquals("Area for triangle with coordinates (0,0), (0,4), (3,0) should be 6.", 6, t1.getArea(), 0.001);
	}
	
	@Test
	public void test_getCircumference_NonRightAngle() {
		Line line1 = new Line(new Point(0,0), new Point(12,0));
		Line line2 = new Line(new Point(0,0), new Point(5,10));
		Line line3 = new Line(new Point(5,10), new Point(12,0));

		Triangle t1 = new Triangle(line1, line2, line3);
		assertEquals("Circumference for triangle with coordinates (0,0), (12,0), (5,10) should be 35.387.", 35.387, t1.getCircumference(), 0.001);
	}	
	
	@Test
	public void test_getArea_NonRightAngle() {
		Line line1 = new Line(new Point(0,0), new Point(12,0));
		Line line2 = new Line(new Point(0,0), new Point(5,10));
		Line line3 = new Line(new Point(5,10), new Point(12,0));

		Triangle t1 = new Triangle(line1, line2, line3);
		assertEquals("Area for triangle with coordinates (0,0), (12,0), (5,10) should be 60.", 60, t1.getArea(), 0.001);
	}	
	
}
