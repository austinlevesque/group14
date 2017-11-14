import static org.junit.Assert.*;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class TriangleTest {
	
	private boolean triangleContainsAddLineMethod(){
		boolean containsMethod = false;
		try {
			BufferedReader in = new BufferedReader(new FileReader("Triangle.java"));
			String line = in.readLine();
			while (line != null) {
				line = line.replaceAll("\\s+","");
				if (line.contains("addLine(Line")){
					containsMethod = true;
				}
				line = in.readLine();
			}
		} catch (FileNotFoundException e) {
			containsMethod = false;
		} catch (IOException e) {
			containsMethod =  false;
		}
		return containsMethod;
	}


	@Test
	public void test_Triangle_getCircumference() {
		assertFalse("Either no Triangle.java file or it contains a definition of addLine method", triangleContainsAddLineMethod());
		Triangle t = new Triangle(new Line(new Point(1,2), new Point(4,6)),
			new Line(new Point(4,6), new Point(10,2)),
			new Line(new Point(10,2), new Point(1,2)));
		
		double circumference = t.getCircumference();
		
		assertEquals("Triangle with three lines[(1,2),(4,6)], [(4,6),(10,2)] and [(10,2),(1,2)] should have circumference 21.21110", 21.21110, circumference, 0.00001);
	}

	@Test
	public void test_getArea() {
		assertFalse("Either no Triangle.java file or it contains a definition of addLine method", triangleContainsAddLineMethod());
		Triangle t = new Triangle(new Line(new Point(14,12), new Point(14,17)),
			new Line(new Point(14,17), new Point(20,17)),
			new Line(new Point(20,17), new Point(14,12)));
			
		double area = t.getArea();
		
		assertEquals("Triangle with three lines between points[(14,12),(14,17),(20,17)] should have area 15", 
		15.0, area, 0.001);
	}

}
