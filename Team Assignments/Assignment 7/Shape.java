import java.util.ArrayList;

/*
* Parent class to Triangle.  Class adds lines to an array list and makes sure the shape made from lines is a valid shape.
* Class also converts the array list into a string format. 
*/

public abstract class Shape {

  private ArrayList<Line> lineList = new ArrayList<Line>();
  private int counter;
  private int count;
  private double totalCircum;


  /**
    * Potential privacy leak when this method is called because it references to the
    * where the location of the line arguement is stored. To fix this we will need to
    * send a copy instead.
    * 
    * Adds lines to array list. 
    * Checks if the end of one point is the start of another in order to make a valid shape.
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

  /**
    * Potential privacy leak when this method is called because it references to the
    * where the location of the ArrayList is stored. To fix this we will need to
    * send a copy instead.
    *
    * @return Line
    */
  protected Line getLine(int i) {
    ArrayList<Line> copy = new ArrayList<Line>();
    for(Line l : lineList) {
      copy.add(l);
    }
    return copy.get(i);
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

  /*
  * Calculates circumference for a given shape.
  * Uses length method in Line class and a for loop to add line
  * lengths together to get circumference.
  * @return double
  */
  public double getCircumference() {
    for(Line l: lineList) {
      totalCircum += l.length();
    }
    return totalCircum;
  }
 
  /*
  * Converts array list into a string format.
  * Adds a comma to separate between coordinate points.
  * Checks position of coordinates to make sure a comma is not added
  * after the last coordinate point.
  * @return String
  */
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
