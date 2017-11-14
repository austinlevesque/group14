import java.util.ArrayList;

public abstract class Shape {

  private ArrayList<Line> lineList = new ArrayList<Line>();
  private int counter;
  private double totalCircum;
  private String stringHolder = " ";

  protected void addLine(Line line) {
    if (lineList.size() == 0){
      lineList.add(line);
    }
    else if(lineList.get(counter).getEnd() == line.getStart()) {
      lineList.add(line);
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
    for(ArrayList l : lineList){
      stringHolder
    }
		return asString + ":" + interestRate + ", " + transactionCounter;
	}*/
  return stringHolder;
  }
}
