import java.util.ArrayList;

public abstract class Shape {

  private ArrayList<Line> lineList = new ArrayList<Line>();
  private int counter;
  private double totalCircum;


  /**
    * Potential privacy leak when this method is called because it references to the
    * where the location of the line arguement is stored. To fix this we will need to
    * send a copy instead.
    *
    * @return void
    */
  protected void addLine(Line l) {
    Line copy = new Line(l.getStart(),l.getEnd());
    if (lineList.size() == 0){
      lineList.add(copy);
    }
    else if(copy.getStart().getXCoord() == lineList.get(counter).getEnd().getXCoord() &&
    copy.getStart().getYCoord() == lineList.get(counter).getEnd().getYCoord()) {
      lineList.add(copy);
      counter++;
    }
  }

  public abstract double getArea();

  //not to sure how to do this method
  protected Line getLine(int i) {
    return lineList.get(i);
  }

  /**
    * Potential privacy leak when this method is called because it references to the
    * current location where the ArrayList is stored. To fix this we will need to
    * send a copy instead.
    *
    * @return ArrayList<Line>
    */
  public ArrayList<Line> getShape() {
    ArrayList<Line> copy = new ArrayList<Line>();
    for(Line l : lineList) {
      copy.add(l);
    }
    return copy;
  }

  public double getCircumference() {
    for(Line l: lineList) {
      totalCircum += l.length();
    }
    return totalCircum;
  }

  public String toString(){
    String stringHolder = "";
    for(Line l : lineList) {
      stringHolder += l.toString();
    }
    return stringHolder;
  }
}
