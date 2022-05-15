package Application.classes;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import Application.interfaces.Obiect;

public class selectObject {

	private JFrame frame;
	private Add_Image Add_ImageTemp;
	private JComboBox<String> selectObject;
	private Vector<Obiect> listOfObjects = new Vector<Obiect>();
	private Vector<String> names=new Vector<>();
	private Vector<Color> colors=new Vector<>();
	private JButton export,
					refresh;
	private selectObject selectObjectTemp = this;
	
	public selectObject(JFrame frame, Add_Image Add_ImageTemp, JButton export, JButton refresh) {
		this.frame = frame;
		this.Add_ImageTemp = Add_ImageTemp;
		this.export = export;
		this.refresh = refresh;
		selectObject = Application.classes.Add_Image.getComboBox();
		names = Add_ImageTemp.getNames();
		colors = Add_ImageTemp.getColors();
	}

	public JFrame getFrame() {
		return frame;
	}

	public JComboBox<String> getSelectObject() {
		return selectObject;
	}

	public void createObjectAndDraw() {
		MouseClick mouseClick = new MouseClick(listOfObjects, Add_ImageTemp, selectObject, names, colors);
		Add_Image.geImagePanel().addMouseListener(mouseClick);
		Export exportImage = new Export(frame, export, Add_ImageTemp, selectObjectTemp);
		exportImage.load();
		Refresh refreshImage = new Refresh(refresh, listOfObjects, Add_ImageTemp);
		refreshImage.load();
	}

	public Vector<Obiect> getListOfObjects(){
		return this.listOfObjects;
	}
	
	public boolean listNotEmpty() {
		if(listOfObjects.isEmpty())
			return false;
		return true;
	}
	
	public void listEmpty() {
		listOfObjects.clear();
	}
}
