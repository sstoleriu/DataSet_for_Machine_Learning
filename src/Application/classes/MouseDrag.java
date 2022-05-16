package Application.classes;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.JComboBox;

import Application.interfaces.Obiect;

public class MouseDrag {

	private boolean drawing=false;
	private Point p1=new Point(0,0);
	private Point p2=new Point(0,0);
	private static Vector<Obiect> listOfObjects;
	@SuppressWarnings("unused")
	private String optiune;
	private Add_Image add_image;
	private static JComboBox<String> selectObjectVar;
	private Vector<String> names=new Vector<>();
	private Vector<Color> colors=new Vector<>();
	private Rectangle selection = new Rectangle();
    private Point clickPoint;
	
	public MouseDrag() {
	}
	
	public MouseDrag(Vector<Obiect> listSelectObject, Add_Image add_image, JComboBox<String> selectObjectVar, Vector<String> names, Vector<Color> colors) {
		MouseDrag.listOfObjects = listSelectObject;
		this.add_image = add_image;
		MouseDrag.selectObjectVar = selectObjectVar;
		this.names = names;
		this.colors = colors;
	}

	
}
