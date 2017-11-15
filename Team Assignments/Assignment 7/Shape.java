import java.util.ArrayList;

public abstract class Shape {

  private ArrayList<Line> lineList = new ArrayList<Line>();
  private int counter;
  private double totalCircum;
  private String stringHolder = " ";

  protected void addLine(Line l) {
    if (lineList.size() == 0){
      lineList.add(l);
    }
    else if(l.getStart().getXCoord() == lineList.get(counter).getEnd().getXCoord() &&
    l.getStart().getYCoord() == lineList.get(counter).getEnd().getYCoord()) {
      lineList.add(l);
      counter++;
    }
  }

  public abstract double getArea();

  //not to sure how to do this method
  protected Line getLine() {
    return lineList.get(0);
  }

  public ArrayList getShape() {
    return lineList;
  }

  public double getCircumference() {
    for(Line l: lineList) {
      totalCircum += l.length();
    }
    return totalCircum;
  }

  //still working on
  public String toString(){
    /*
    for(Line l: lineList) {
      l.toString();
    }
		return asString + ":" + interestRate + ", " + transactionCounter;
    */
    return stringHolder;
  }
}
