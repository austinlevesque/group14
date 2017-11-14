import static org.junit.Assert.*;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ShapeTest {
	class Temp extends Shape {
		public double getArea() {
			return 0.0;
		}
	}
	
	private boolean isAbstractAndContainsAbstractMethod(){
		boolean classAbstract = false;
		boolean containsAbstractMethod = false;
		try {
			BufferedReader in = new BufferedReader(new FileReader("Shape.java"));
			String line = in.readLine();
			while (line != null) {
				if (line.contains("public abstract class Shape")){
					classAbstract = true;
				} else if (line.contains("public abstract double getArea")){
					containsAbstractMethod = true;
				}
				line = in.readLine();
			}
		} catch (FileNotFoundException e) {
			classAbstract = false;
		} catch (IOException e) {
			classAbstract =  false;
		}
		return classAbstract && containsAbstractMethod;
	}

	// addLine and circumference tests
	@Test
	public void test_addSingleLine() {
		assertTrue("Shape class must be declared abstract and contain abstractgetArea method.", isAbstractAndContainsAbstractMethod());
		Shape s = new Temp();
		s.addLine(new Line(new Point(1,2), new Point(4,6)));
		double circumference = s.getCircumference();
		
		assertEquals("Shape with single line from point (1,2) to (4,6) should have circumference 5.0", 5.0, circumference, 0.00001);
	}

	@Test
	public void test_addTwoLines() {
		assertTrue("Shape class must be declared abstract and contain abstractgetArea method.", isAbstractAndContainsAbstractMethod());
		Temp s = new Temp();
		s.addLine(new Line(new Point(1,2), new Point(4,6)));
		s.addLine(new Line(new Point(4,6), new Point(10,2)));
		
		double circumference = s.getCircumference();
		
		assertEquals("Shape with two llnes[(1,2),(4,6)] and [(4,6),(10,2)] should have circumference 12.21110", 12.21110, circumference, 0.00001);
	}

	@Test
	public void test_addThreeLines() {
		assertTrue("Shape class must be declared abstract and contain abstractgetArea method.", isAbstractAndContainsAbstractMethod());
		Shape s = new Temp();
		s.addLine(new Line(new Point(1,2), new Point(4,6)));
		s.addLine(new Line(new Point(4,6), new Point(10,2)));
		s.addLine(new Line(new Point(10,2), new Point(1,2)));
		
		double circumference = s.getCircumference();
		
		assertEquals("Shape with three lines[(1,2),(4,6)], [(4,6),(10,2)] and [(10,2),(1,2)] should have circumference 21.21110", 21.21110, circumference, 0.00001);
	}
	
	@Test
	public void test_toString() {
		assertTrue("Shape class must be declared abstract and contain abstractgetArea method.", isAbstractAndContainsAbstractMethod());
		Shape s = new Temp();
		s.addLine(new Line(new Point(1,2), new Point(4,6)));
		s.addLine(new Line(new Point(4,6), new Point(10,2)));
		s.addLine(new Line(new Point(10,2), new Point(1,2)));
		
		assertEquals("Shape with three lines[(1,2),(4,6)], [(4,6),(10,2)] and [(10,2),(1,2)] should have string representation [(1,2),(4,6)], [(4,6),(10,2)],[(10,2),(1,2)]", 
		"[(1,2),(4,6)],[(4,6),(10,2)],[(10,2),(1,2)]", s.toString());

	}
}
