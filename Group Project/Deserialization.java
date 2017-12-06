package fileio;

import java.io.*;

import gameobjects.Snake;
import move.Point;

public class DeserializeGame {

	public Snake loadGameA(Snake snakeA) {
	      try {
	         FileInputStream fileIn = new FileInputStream("snakeA.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         snakeA = null;
	         snakeA = (Snake) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      } catch (ClassNotFoundException c) {
	         System.out.println("Snake class noy found");
	         c.printStackTrace();
	      }
	      return snakeA;
	}
	
    public Snake loadGameB(Snake snakeB) {
	      try {
		         FileInputStream fileIn = new FileInputStream("snakeB.ser");
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         snakeB = null;
		         snakeB = (Snake) in.readObject();
		         in.close();
		         fileIn.close();
		      } catch (IOException i) {
		         i.printStackTrace();
		      } catch (ClassNotFoundException c) {
		         System.out.println("Snake class not found");
		         c.printStackTrace();
		      }
	      return snakeB;
	      
	}

	public Point loadPoint1(Point p1) {
		 try {
	         FileInputStream fileIn = new FileInputStream("point1.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         p1 = null;
	         p1 = (Point) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      } catch (ClassNotFoundException c) {
	         System.out.println("Point class not found");
	         c.printStackTrace();
	      }
      return p1;
	}
	
	public Point loadPoint2(Point p2) {
		 try {
	         FileInputStream fileIn = new FileInputStream("point2.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         p2 = null;
	         p2 = (Point) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      } catch (ClassNotFoundException c) {
	         System.out.println("Point class not found");
	         c.printStackTrace();
	      }
     return p2;
	}
	
	public Point loadPoint3(Point p3) {
		 try {
	         FileInputStream fileIn = new FileInputStream("point3.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         p3 = null;
	         p3 = (Point) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      } catch (ClassNotFoundException c) {
	         System.out.println("Point class not found");
	         c.printStackTrace();
	      }
     return p3;
	}
}
