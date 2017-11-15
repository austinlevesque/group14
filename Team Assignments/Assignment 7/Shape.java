import java.util.ArrayList;

public abstract class Shape {

  private ArrayList<Line> lineList = new ArrayList<Line>();
  private int counter;
  private int count;
  private double totalCircum;

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

  /**
    * Potential privacy when this method is called because it references to the
    * current location where the ArrayList is stored. To fix this we will need to
    * send a copy instead.
    *
    * @return ArrayList<Line<
    */
  public ArrayList<Line> getShape() {
    ArrayList<Line> copy = new ArrayList<Line>();
    for(Line l : lineList) {
      copy.add(l);
    }
    return lineList;
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
		   if (count != lineList.size() - 1){
				stringHolder += l.toString() + ",";
				}
				else{
					stringHolder += l.toString();
				}
			count++;	
      } return stringHolder;
	}
}
