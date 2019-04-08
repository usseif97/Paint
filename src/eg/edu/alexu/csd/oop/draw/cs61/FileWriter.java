package eg.edu.alexu.csd.oop.draw.cs61;

import java.io.BufferedWriter;
import java.io.File;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.Point;

import eg.edu.alexu.csd.oop.draw.Shape;

public class FileWriter {

	public void JSONWriter(String path, Shape[] shapes) {

		File file = new File(path);
		BufferedWriter bw = null;
		try {

			file.createNewFile();

			bw = new BufferedWriter(new java.io.FileWriter(file));

			bw.write("{\"ShapeArray\" : [\n");
			
			for (int i = 0; i < shapes.length; i++) {
				
				bw.write("{ \"className\" : \" " + shapes[i].getClass().toString().split(" ")[1] + "\",\n");
				
				bw.write("\"x\" : \"" + ((Point) shapes[i].getPosition()).x + "\",\n");
				bw.write("\"y\" : \"" + ((Point) shapes[i].getPosition()).y + "\",\n");
				
				//Iterator it = shapes[i].getProperties().entrySet().iterator();
				bw.write("{\"Map\" : [\n");
				bw.write("{ ");
				Map<String, Double> map = shapes[i].getProperties();
				//System.out.println(shapes[i].getProperties().size() + "AHOOOOOOOOOOOOOOOOOO");
				for (Entry<String, Double> entry : map.entrySet()) {
					 //System.out.println(entry.getKey() + "/" + entry.getValue());
					bw.write("\"" + entry.getKey() + "\" : \"" + entry.getValue() + "\",\n");
				}
				bw.write("} \n");
				bw.write("]} \n");
				
				/*while (it.hasNext()) {
					Map.Entry pair = (Map.Entry) it.next();
					fw.write("\"" + pair.getKey() + "\" : \"" + pair.getValue() + "\",\n");
					it.remove(); // avoids a ConcurrentModificationException
				}*/
				
				bw.write("\"color\" : \"" + shapes[i].getColor() + "\",\n");
				bw.write("\"fillcolor\" : \"" + shapes[i].getFillColor() + "\"\n");
				bw.write("},\n\n");
				
			}
			
			bw.write("]}");
			bw.flush();
			bw.close();

		} catch (Exception e) {

		}

	}
	
	/*//Iterator it = shapes[i].getProperties().entrySet().iterator();
				fw.write("{\"Map\" : [\n");
				fw.write("{ ");
				Map<String, Double> map = shapes[i].getProperties();
				//System.out.println(shapes[i].getProperties().size() + "AHOOOOOOOOOOOOOOOOOO");
				for (Entry<String, Double> entry : map.entrySet()) {
					 //System.out.println(entry.getKey() + "/" + entry.getValue());
					fw.write("\"" + entry.getKey() + "\" : \"" + entry.getValue() + "\",\n");
				}*/

	public void XMLWriter(String path, Shape[] shapes) {

		File file = new File(path);
		BufferedWriter bw = null;
		try {

			file.createNewFile();
			
			bw = new BufferedWriter(new java.io.FileWriter(file));

			bw.write("<Paint>\n");

			for (int i = 0; i < shapes.length; i++) {

				bw.write("<Shape ");

				bw.write("id = " + "\"" + shapes[i].getClass().toString().split(" ")[1] + "\">\n");

				bw.write("<x>" + ((Point) shapes[i].getPosition()).x + "</x>\n");
				bw.write("<y>" + ((Point) shapes[i].getPosition()).y + "</y>\n");

				bw.write("<map>\n");
				Map<String, Double> map = shapes[i].getProperties();
				for (Entry<String, Double> entry : map.entrySet()) {
					 //System.out.println(entry.getKey() + "/" + entry.getValue());
					bw.write("<" + entry.getKey() + ">" + entry.getValue() + "</" + entry.getKey() + ">\n");
				}
				/*Iterator it = shapes[i].getProperties().entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pair = (Map.Entry) it.next();
					fw.write("<" + pair.getKey() + ">" + pair.getValue() + "</" + pair.getKey() + ">\n");
					it.remove(); // avoids a ConcurrentModificationException
				}*/

				bw.write("</map>\n");

				bw.write("<color>" + shapes[i].getColor() + "</color>\n");
				bw.write("<fillcolor>" + shapes[i].getFillColor() + "</fillcolor>\n");

				bw.write("</Shape>\n");

			}

			bw.write("</Paint>");
			bw.flush();
			bw.close();


		} catch (Exception e) {

		}

	}

}
