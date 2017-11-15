public class Triangle extends Shape {

	public Triangle(Line line1, Line line2, Line line3) {
		addLine(line1);
		addLine(line2);
		addLine(line3);
	}

	public double getArea() {
		double s1 = getShape().get(0).length();
		double s2 = getShape().get(1).length();
		double s3 = getShape().get(2).length();
		double s = (s1 + s2 + s3) / 2;
    double area = Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
		return area;
	}
}
