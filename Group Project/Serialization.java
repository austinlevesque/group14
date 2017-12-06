package fileio;
import gameobjects.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import move.Point;

public class SerializeGame {
	
	public SerializeGame() {
	}

	public void saveGame(Snake saveSnakeA, Snake saveSnakeB) {
		
		try {
			FileOutputStream fileOut =
			         new FileOutputStream("snakeA.ser");
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(saveSnakeA);
			         out.close();
			         fileOut.close();
			         System.out.printf("Serialized data is saved in snakeA.ser");
			      } catch (IOException i) {
			         i.printStackTrace();
			      }
		try {
			FileOutputStream fileOut =
			         new FileOutputStream("snakeB.ser");
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(saveSnakeB);
			         out.close();
			         fileOut.close();
			         System.out.printf("Serialized data is saved in snakeB.ser");
			      } catch (IOException i) {
			         i.printStackTrace();
			      }
	}

	public void saveGamePoint(Point p1, Point p2, Point p3) {
		try {
			FileOutputStream fileOut =
			         new FileOutputStream("point1.ser");
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(p1);
			         out.close();
			         fileOut.close();
			         System.out.printf("Serialized data is saved in point1.ser");
			      } catch (IOException i) {
			         i.printStackTrace();
			      }
		try {
			FileOutputStream fileOut =
			         new FileOutputStream("point2.ser");
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(p2);
			         out.close();
			         fileOut.close();
			         System.out.printf("Serialized data is saved in point2.ser");
			      } catch (IOException i) {
			         i.printStackTrace();
			      }
		try {
			FileOutputStream fileOut =
			         new FileOutputStream("point3.ser");
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(p3);
			         out.close();
			         fileOut.close();
			         System.out.printf("Serialized data is saved in point3.ser");
			      } catch (IOException i) {
			         i.printStackTrace();
			      }
	}

}
