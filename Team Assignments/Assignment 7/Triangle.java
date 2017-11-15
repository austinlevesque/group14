/*
* Child class of Shape.  This class uses addLine method in Shape
* to add lines in the shape of a triangle.
* This class also calculates the area of the triangle
*/

public class Triangle extends Shape {
	
	/*
	* Constructor that calls addLine method in Shape to add lines to the array list.
	*/
	public Triangle(Line line1, Line line2, Line line3) {
		addLine(line1);
		addLine(line2);
		addLine(line3);
	}
	
	/*
	* This method calculates area of a triangle.
	* Takes side lengths from a method in Shape and uses Heron's Formula 
	* to calculate the area.
	* @return double
	*/
	public double getArea() {
		double s1 = getShape().get(0).length();
		double s2 = getShape().get(1).length();
		double s3 = getShape().get(2).length();
		double s = (s1 + s2 + s3) / 2;
    		double area = Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
		return area;
	}
}
