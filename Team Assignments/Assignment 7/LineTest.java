import static org.junit.Assert.*;

import org.junit.Test;

public class LineTest {

	@Test
	public void test_StartIsTopLeft_EndIsBottomRight() {
		Line line1 = new Line(new Point(1,2), new Point(4,6));
		double length = line1.length();
		
		assertEquals("Line from point (1,2) to (4,6) should be 5.0", 5.0, length, 0.00001);
	}

	@Test
	public void test_StartIsTopRight_EndIsBottomLeft() {
		Line line1 = new Line(new Point(10,2), new Point(4,6));
		double length = line1.length();
		
		assertEquals("Line from point (10,2) to (4,6) should be 7.21110", 7.21110, length, 0.00001);
	}

	@Test
	public void test_StartIsBottomRight_EndIsTopLeft() {
		Line line1 = new Line(new Point(10,20), new Point(4,6));
		double length = line1.length();
		
		assertEquals("Line from point (10,20) to (4,6) should be 15.2315462", 15.2315462, length, 0.00001);
	}

	@Test
	public void test_StartIsBottomLeft_EndIsTopRight() {
		Line line1 = new Line(new Point(2,20), new Point(4,6));
		double length = line1.length();
		
		assertEquals("Line from point (2,20) to (4,6) should be 14.142135", 14.142135, length, 0.00001);
	}
	
	@Test
	public void test_PrivacyLeak_FirstPoint() {
		Point  p1 = new Point(2,20);
		Line line1 = new Line(p1, new Point(4,6));
		
		p1.moveDown(10);
		
		double length = line1.length();
		
		assertEquals("Point (2,20) passed in as argument to constructor.  Instance changed afterwards to (2,30) but this should not effect Line object.  Line from point (2,20) to (4,6) should be 14.142135", 14.142135, length, 0.00001);
		
	}

	public void test_PrivacyLeak_SecondPoint() {
		Point  p1 = new Point(2,20);
		Line line1 = new Line(new Point(4,6), p1);
		
		p1.moveDown(10);
		
		double length = line1.length();
		
		assertEquals("Point (2,20) passed in as second argument to constructor.  Instance changed afterwards to (2,30) but this should not effect Line object.  Line from point (2,20) to (4,6) should be 14.142135", 14.142135, length, 0.00001);
		
	}
}
