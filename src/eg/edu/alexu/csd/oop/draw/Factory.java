package eg.edu.alexu.csd.oop.draw;

import java.awt.Point;

public interface Factory {
	
	public Shape createShape(String type, Point startPoint, Point endPoint, Point dump);
	public DrawingEngine getDrawingEngine();
	public Shape showPropUnknown(String type, Point startPoint) throws Exception;

}
