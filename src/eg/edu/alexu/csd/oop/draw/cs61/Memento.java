package eg.edu.alexu.csd.oop.draw.cs61;

import java.util.ArrayList;

import eg.edu.alexu.csd.oop.draw.Shape;

public class Memento {
	
	private ArrayList<Shape> shapes;
	
	public Memento(ArrayList<Shape> shapes) {

		this.shapes = new ArrayList<>();
		for (int i = 0; i < shapes.size(); i++) {
			this.shapes.add(shapes.get(i));
		}
		
	}
	
	public ArrayList<Shape> getMemento() {
		
		ArrayList<Shape> shapes = new ArrayList<>();
		for (int i = 0; i < this.shapes.size(); i++) {
			shapes.add(this.shapes.get(i));
		}
		return shapes;
		
	}

}
