
public class Triangle {

	private Line line1, line2, line3;

	public Triangle(Line line1, Line line2, Line line3) {
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
	}

	public Line getLine1(){
		return line1;
	}

	public Line getLine2() {
		return line2;
	}

	public Line getLine3() {
		return line3;
	}

	public double getCircumference() {
		return 0.0;
	}

	public double getArea(){
		return 0.0;
	}

}
